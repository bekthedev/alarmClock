package edu.bekthedev;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //JAVA ALARM CLOCK

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "dogs.wav";


        while(alarmTime == null) {
            try {
                System.out.println("Enter in alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine();
    
                alarmTime =  LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);
            } catch(DateTimeParseException e) {
                System.out.println("Invaild format. Please use HH:MM:SS!!");
            }
    
        }
        

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();



        
    }
}