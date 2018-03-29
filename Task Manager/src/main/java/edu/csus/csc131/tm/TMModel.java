package edu.csus.csc131.tm;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TMModel implements ITMMODEL
{
    private LinkedList<String> entries = new LinkedList<>();
    private Time t;
    private Log l;

    public TMModel()
    {
        this("log.txt");
    }
    private TMModel(String fileName)
    {
        l = new Log(fileName);
        entries = l.readEntries();
    }
    public boolean startTask(String name)
    {
        String format = String.format("%s %s start", LocalDateTime.now().toString(),name);
        return (l.write(format));
    }
    public boolean stopTask(String name)
    {
        String format = String.format("%s %s stop", LocalDateTime.now().toString(),name);
        return (l.write(format));
    }
    public boolean describeTask(String name, String description)
    {
        String format = String.format("%s %s describe %s", LocalDateTime.now().toString(),name, description);
        return (l.write(format));
    }
    public boolean sizeTask(String name, String size)
    {
        String format = String.format("%s %s size %s", LocalDateTime.now().toString(),name, size);
        return (l.write(format));
    }
    public boolean deleteTask(String name)
    {
        return(l.deleteTask(name));
    }
    public boolean renameTask(String oldName, String newName)
    {
        return(l.renameTask(oldName, newName));
    }

    public boolean categoryTask(String name, String category)
    {
        String format = String.format("%s %s category %s", LocalDateTime.now().toString(),name, category);
        return (l.write(format));
    }
    public boolean deadLineTask(String name, String deadLine)
    {
        String format = String.format("%s %s deadLine %s", LocalDateTime.now().toString(),name, deadLine);
        return (l.write(format));
    }
    public String taskSize(String name)
    {
        String size = "";

        for(String s: entries)
        {
            if(s.contains("size") && s.contains(name))
            {
                StringTokenizer stok = new StringTokenizer(s);
                stok.nextToken();
                stok.nextToken();
                stok.nextToken();
                size = stok.nextToken();
            }
        }
        return size;
    }
    public String taskDescription(String name)
    {
        String description = "";
        StringBuilder sb = new StringBuilder();
        for(String s: entries)
        {
            if(s.contains("describe") && s.contains(name)) {
                StringTokenizer stok = new StringTokenizer(s);
                stok.nextToken();
                stok.nextToken();
                stok.nextToken();
                while(stok.hasMoreTokens())
                {
                    sb.append(stok.nextToken());
                    sb.append(" ");
                }
                sb.append(" ");
            }
            description = sb.toString();
        }
        return description;
    }
    public String taskElapsedTime(String name)
    {
        t = new Time();
        return t.computeElapsedTime(getTimeList(name));
    }
    public TreeSet<String> taskNamesForSize(String size)
    {
        TreeSet<String> names = taskNames();
        TreeSet<String> temp = new TreeSet<>();
        for(String n: names)
        {
            if(taskSize(n).equalsIgnoreCase(size))
                temp.add(n);
        }
        return temp;
    }
    public String elapsedTimeForAllTasks()
    {
        TreeSet<String> taskNames = taskNames();
        t = new Time();
        Time ti = new Time();
        long elapsedTimeForAllTasks=0;
        long time;

        for(String s: taskNames)
        {
            time = ti.getSeconds(t.computeElapsedTime(getTimeList(s)));
            elapsedTimeForAllTasks += time;
        }
        return (new Time().getTimeFormat(elapsedTimeForAllTasks));
    }
    public TreeSet<String> taskNames()
    {
        l.readEntries();
        TreeSet<String> names = new TreeSet<>();
        String name;

        for(String s: entries)
        {
            StringTokenizer stok = new StringTokenizer(s);
            stok.nextToken();
            name = stok.nextToken();
            names.add(name);
        }
        return names;
    }
    public TreeSet<String> taskSizes()
    {
        l.readEntries();
        TreeSet<String> sizes = new TreeSet<>();
        String size;

        for(String line: entries)
        {
            if(line.contains("size"))
            {
                StringTokenizer stok = new StringTokenizer(line);
                stok.nextToken();
                stok.nextToken();
                stok.nextToken();
                size = stok.nextToken();
                sizes.add(size);
            }
        }
        return sizes;
    }
    public String minTimeForSize(String size)
    {
        TreeSet<String> taskNames = taskNamesForSize(size);
        long minValue = Long.MAX_VALUE;
        Time t = new Time();

        for(String name: taskNames)
        {
            if(t.getSeconds(taskElapsedTime(name)) < minValue)
                minValue = t.getSeconds(taskElapsedTime(name));
        }
        return t.getTimeFormat(minValue);
    }
    public String maxTimeForSize(String size)
    {
        TreeSet<String> taskNames = taskNamesForSize(size);
        long maxValue = 0;
        Time t = new Time();

        for(String name: taskNames)
        {
            if(t.getSeconds(taskElapsedTime(name)) > maxValue)
                maxValue = t.getSeconds(taskElapsedTime(name));
        }
        return t.getTimeFormat(maxValue);
    }
    public String avgTimeForSize(String size)
    {
        TreeSet<String> taskNames = taskNamesForSize(size);
        long total =0, average, numOfTasks = 0;
        Time t = new Time();

        for(String name: taskNames)
        {
            total += t.getSeconds(taskElapsedTime(name));
            numOfTasks++;
        }
        average = total / numOfTasks;
        return t.getTimeFormat(average);
    }
    private LinkedList<String> getTimeList(String taskName)
    {
        LinkedList<String> timeList = new LinkedList<>();
        for(String a: entries)
        {
            if(a.contains(taskName))
            {
                if(a.contains("start"))
                {
                    StringTokenizer stok = new StringTokenizer(a);
                    timeList.add(stok.nextToken());
                }
                if(a.contains("stop"))
                {
                    StringTokenizer stok = new StringTokenizer(a);
                    timeList.add(stok.nextToken());
                }

            }
        }
        return timeList;
    }


    @Override
    public String taskCategory(String name) {
        return null;
    }

    @Override
    public String taskDeadLine(String name)
    {

        return null;
    }
}