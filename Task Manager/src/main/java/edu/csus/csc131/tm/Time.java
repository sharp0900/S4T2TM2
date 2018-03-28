package edu.csus.csc131.tm;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Time
{
    public String getTimeFormat(long totalSeconds)
    {
        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;

        long seconds = totalSeconds % SECONDS_IN_A_MINUTE;
        long totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        long minutes = totalMinutes % MINUTES_IN_AN_HOUR;
        long hours = totalMinutes / MINUTES_IN_AN_HOUR;
        return String.format("%02d:%02d:%02d", hours,minutes,seconds);

    }
    public long getSeconds(String time)
    {
        StringTokenizer st = new StringTokenizer(time,":");
        long hours = Long.parseLong(st.nextToken());
        long minutes = Long.parseLong(st.nextToken());
        long seconds = Long.parseLong(st.nextToken());

        return (hours * 3600 + minutes * 60 + seconds);

    }
    public long timeBetween(LocalDateTime start, LocalDateTime stop)
    {
        return ChronoUnit.SECONDS.between(start,stop);
    }
    public String computeElapsedTime(LinkedList<String> loggedTimes)
    {
        String elapsedTime="";
        LinkedList<String> times = loggedTimes;
        int i=0;
        String dumStart="", dumStop;
        long timeElapsed=0;
        for(String s: times) //calculates all the elapsed times by calculating 1 start/stop set at a time
        {
            i++;
            if(i == 1)
            {
                dumStart = s;
            }
            if(i == 2)
            {
                dumStop = s;
                LocalDateTime start = LocalDateTime.parse(dumStart);
                LocalDateTime stop = LocalDateTime.parse(dumStop);
                timeElapsed += new Time().timeBetween(start,stop);
            }
            if(i==2)
                i=0;
        }

        elapsedTime = new Time().getTimeFormat(timeElapsed);
        return elapsedTime;
    }
}