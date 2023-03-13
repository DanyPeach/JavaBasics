package com.by.lab3.chapter3A10;

import java.sql.Time;
import java.time.LocalTime;

public class Station {

    private static Station instance;
    private TrainGuideService trainGuideService;

    private Station(TrainGuideService trainGuideService) {
        this.trainGuideService = trainGuideService;
    }

    public static Station getInstance(TrainGuideService trainGuideService){
        if(instance == null){
            instance = new Station(trainGuideService);
        }
        return instance;
    }

    public void initializingTrains() {
        Train train1 = new Train(1, Time.valueOf(LocalTime.NOON), "Vilnus", 500, 200, 10, 20);
        Train train2 = new Train(2, Time.valueOf(LocalTime.of(9, 35)), "Moscow", 200, 100, 15, 30);
        Train train3 = new Train(3, Time.valueOf(LocalTime.MIDNIGHT), "Krakov", 800, 0, 0, 30);
        Train train4 = new Train(4, Time.valueOf(LocalTime.of(11, 0)), "Buda-Pesht", 400, 50, 20, 5);
        Train train5 = new Train(5, Time.valueOf(LocalTime.of(12, 50)), "Vilnus", 400, 50, 20, 4);
        Train train6 = new Train(6, Time.valueOf(LocalTime.of(7, 45)), "Vilnus", 400, 50, 20, 0);

        trainGuideService.addToArray(train1);
        trainGuideService.addToArray(train2);
        trainGuideService.addToArray(train3);
        trainGuideService.addToArray(train4);
        trainGuideService.addToArray(train5);
        trainGuideService.addToArray(train6);
    }

}
