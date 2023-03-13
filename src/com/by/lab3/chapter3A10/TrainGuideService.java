package com.by.lab3.chapter3A10;

import java.sql.Time;
import java.util.Arrays;

public class TrainGuideService {
    private int currentSize = 0;
    private int capacity = 0;
    private Train[] trains = new Train[capacity];

    public TrainGuideService() {
    }

    public void addToArray(Train train){
        if (currentSize == capacity) {
            capacity++;
            Train[] newArray = new Train[capacity];
            for (int i = 0; i < currentSize; i++) {
                newArray[i] = trains[i];
            }
            trains = newArray;
        }
        trains[currentSize++] = train;
    }

    public Train[] sortTrains(String location, Train[] trains){
        int size = 0;
        int capacityOfSortedArray = 0;
        Train[] sortedTrains = new Train[capacityOfSortedArray];
        for(int i = 0; i < trains.length; i++){
            if(capacityOfSortedArray == size){
                capacityOfSortedArray++;
                Train[] prom = Arrays.copyOf(sortedTrains, capacityOfSortedArray);
                sortedTrains = Arrays.copyOf(prom, prom.length);
            }
            if(trains[i].getLocationOfArrival().equals(location)) {
                sortedTrains[size] = trains[i];
                size++;
            }
        }
        return sortedTrains;
    }

    public Train[] sortTrains(String location, Time time, Train[] trains){
        int size = 0;
        int capacityOfSortedArray = 0;
        Train[] sortedTrains = new Train[capacityOfSortedArray];
        for(int i = 0; i < trains.length; i++){
            if(capacityOfSortedArray == size){
                capacityOfSortedArray++;
                Train[] prom = Arrays.copyOf(sortedTrains, capacityOfSortedArray);
                sortedTrains = Arrays.copyOf(prom, prom.length);
            }
            if(trains[i].getLocationOfArrival().equals(location) && time.after(trains[i].getTimeOfGoing())) {
                sortedTrains[size] = trains[i];
                size++;
            }
        }
        return sortedTrains;
    }

    public Train[] sortTrainsWithSits(String location, Train[] trains){
        int size = 0;
        int capacityOfSortedArray = 0;
        Train[] sortedTrains = new Train[capacityOfSortedArray];
        for(int i = 0; i < trains.length; i++){
            if(capacityOfSortedArray == size){
                capacityOfSortedArray++;
                Train[] prom = Arrays.copyOf(sortedTrains, capacityOfSortedArray);
                sortedTrains = Arrays.copyOf(prom, prom.length);
            }
            if(trains[i].getLocationOfArrival().equals(location) && trains[i].getAmountOfGenSits()>0) {
                sortedTrains[size] = trains[i];
                size++;
            }
        }
        return sortedTrains;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Train[] getTrains() {
        return trains;
    }
}
