package com.by.lab3.chapter3A10;

import java.sql.Time;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        TrainGuideService trainGuideService = new TrainGuideService();
        Station.getInstance(trainGuideService).initializingTrains();

        Train[] sortedByLocationArray = trainGuideService.sortTrains("Vilnus", trainGuideService.getTrains());

        System.out.println("Количество поездов в необходимый город: " + sortedByLocationArray.length);
        for(var i : sortedByLocationArray){
            System.out.println("Поезд под номером \"" + i.getTrainNumber() + "\" в " + i.getLocationOfArrival()
                    + " отпраляется в " + i.getTimeOfGoing());
        }

        System.out.println("----------------------------------------------------------");

        Train[] sortedByLocationAndTimeArray = trainGuideService.sortTrains("Vilnus", Time.valueOf(LocalTime.of(12,40)) ,trainGuideService.getTrains());

        System.out.println("Количество поездов в необходимый город до указанного времени: " + sortedByLocationAndTimeArray.length);
        for(var i : sortedByLocationAndTimeArray){
            System.out.println("Поезд под номером \"" + i.getTrainNumber() + "\" в " + i.getLocationOfArrival()
                    + " отпраляется в " + i.getTimeOfGoing());
        }

        System.out.println("----------------------------------------------------------");

        Train[] sortedByLocationAndSits = trainGuideService.sortTrainsWithSits("Vilnus" ,trainGuideService.getTrains());

        System.out.println("Количество поездов в необходимый город с наличием свободных мест: " + sortedByLocationAndSits.length);
        for(var i : sortedByLocationAndSits){
            System.out.println("Поезд под номером \"" + i.getTrainNumber() + "\" в " + i.getLocationOfArrival()
                    + " отпраляется в " + i.getTimeOfGoing());
        }
    }
}
