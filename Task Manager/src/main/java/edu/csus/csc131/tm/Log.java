package edu.csus.csc131.tm;

import java.io.*;
import java.util.*;

public class Log
{
    private String fileName;
    private LinkedList<String> entries = new LinkedList<>();

    /*
     * constructor
     * builds from filename
     */
    Log(String fileName) {this.fileName=fileName;}

    /*
     * write function
     * writes String parameter to member file
     */
    public boolean write(String format)
    {
        boolean b = true;
        try
        {
            FileWriter fw = new FileWriter(fileName,true);
            fw.write(format + "\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
            b=false;
        }
        return b;
    }
    /*
     * Given a string from the log file,
     * this function takes the first word (which should be name)
     * and returns it.
     * Only works if task names are single-word entries?
     */
    private String extractName(String entry)
    {
        StringTokenizer st = new StringTokenizer(entry);
        String taskName;

        st.nextToken();
        taskName = st.nextToken();

        return taskName;
    }

    /*
     * Formats data for entry into log
     */
    private String getnewLine(String line, String taskName)
    {
        StringTokenizer st = new StringTokenizer(line);
        StringBuilder sb = new StringBuilder();

        String time = st.nextToken();
        st.nextToken();

        sb.append(time);
        sb.append(" ");
        sb.append(taskName);
        sb.append(" ");
        while(st.hasMoreElements())
        {
            sb.append(st.nextToken());
            sb.append(" ");
        }
        return sb.toString();
    }


    public boolean renameTask(String taskName, String newName)
    {
        File inputFile = new File(fileName);
        File tempFile = new File("myTempFile.txt");
        boolean noErrors = true;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String newLine;
            String currentLine;

            while((currentLine = reader.readLine()) != null)
            {
                String trimmedLine = currentLine.trim();
                String programName = extractName(trimmedLine);
                if(programName.equals(taskName))
                {
                    newLine = getnewLine(trimmedLine, newName);
                    writer.write(newLine + System.getProperty("line.separator"));
                }
                else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
        }
        catch (IOException io)
        {
            System.err.println("ERROR: could not open file");
            noErrors=false;
        }
        tempFile.renameTo(inputFile);
        return noErrors;
    }

    public boolean deleteTask(String taskName)
    {
        File inputFile = new File(fileName);
        File tempFile = new File("myTempFile.txt");
        boolean b = true;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = "";
            String currentLine;

            while((currentLine = reader.readLine()) != null)
            {
                String trimmedLine = currentLine.trim();
                String programName = extractName(trimmedLine);
                if(programName.equals(taskName))
                    lineToRemove = trimmedLine;
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
        }
        catch (IOException io)
        {
            System.err.println("ERROR: could not open file");
            b = false;
        }
        tempFile.renameTo(inputFile);
        return b;
    }
    /*
     *
     */
    public LinkedList<String> readEntries()
    {
        entries.clear();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while(line != null)
            {
                entries.add(line);
                line = br.readLine();
            }
            br.close();
        }
        catch (Exception e)
        {
            System.err.println("Error File not found");
        }
        return entries;
    }
}