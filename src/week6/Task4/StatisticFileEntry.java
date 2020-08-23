package week6.Task4;

import java.sql.Timestamp;
import java.time.DayOfWeek;

public class StatisticFileEntry {
    private String IP;//, time;
    private DayOfWeek dayOfWeek;
    public String time;

    public StatisticFileEntry(String IP, String time, DayOfWeek dayOfWeek){
        this.IP = IP;
        this.time = time;
        this.dayOfWeek = dayOfWeek;
    }

    public StatisticFileEntry(String data){
        String[] temp = data.split(" ");
        this.IP = temp[0];
        this.time = temp[1];
        this.dayOfWeek = (DayOfWeek)Enum.valueOf(DayOfWeek.class, temp[2]);
    }

    public String getIP(){
        return IP;
    }

    public String getTime(){
        return time;
    }

    public DayOfWeek getDayOfWeek(){
        return dayOfWeek;
    }
}
