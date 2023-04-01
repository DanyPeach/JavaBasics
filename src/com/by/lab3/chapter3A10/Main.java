package com.by.lab3.chapter3A10;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrainGuideService trainGuideService = new TrainGuideService();
        Station.getInstance(trainGuideService).initializingTrains();

        Train[] sortedByLocationArray = trainGuideService.sortTrains("Vilnus", trainGuideService.getTrains());

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter time with such pattern \"00:00:00\": ");
        Time time = Time.valueOf(scanner.next());
        System.out.println(time);


    }
}
