/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asset;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Qzheng
 */
public class Schedule {
    public String startLocation;
    public String destination;
    public Calendar dateTime;
    private ArrayList <Schedule> scheduleList;

    public Schedule(String startLocation, String destination, Calendar dateTime) {
        this.startLocation = startLocation;
        this.destination = destination;
        this.dateTime = dateTime;
    }
    
    public void addSchedule(Schedule schedule){
        scheduleList.add(schedule);
    }
    
    public void deleteSchedule(Schedule schedule){
        scheduleList.remove(schedule);
    }
    
    public void editSchedule(Schedule oldSchedule, Schedule newSchedule){
        int oldScheduleIndex = scheduleList.indexOf(oldSchedule);
        scheduleList.set(oldScheduleIndex ,newSchedule);
    }
    
    public void viewSchedule(){
        System.out.println(scheduleList);
    }

   @Override
    public String toString() {
        return "Start location :" + startLocation + 
               "Destination    :" + destination + 
               "Date time      :" + dateTime;
    }
    
    
}
