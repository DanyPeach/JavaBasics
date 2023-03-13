package com.by.lab3.chapter3A10;

import java.sql.Time;

public class Train {
    private int trainNumber;
    private Time timeOfGoing;
    private String locationOfArrival;
    private int amountOfGenSits;
    private int amountOfCoupe;
    private int amountOfPlanchet;
    private int amountOfLuxSits;

    public Train() {
    }

    public Train(int trainNumber, Time timeOfGoing, String locationOfArrival, int amountOfGenSits,
                 int amountOfCoupe, int amountOfPlanchet, int amountOfLuxSits) {
        this.trainNumber = trainNumber;
        this.timeOfGoing = timeOfGoing;
        this.locationOfArrival = locationOfArrival;
        this.amountOfGenSits = amountOfGenSits;
        this.amountOfCoupe = amountOfCoupe;
        this.amountOfPlanchet = amountOfPlanchet;
        this.amountOfLuxSits = amountOfLuxSits;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Time getTimeOfGoing() {
        return timeOfGoing;
    }

    public void setTimeOfGoing(Time timeOfGoing) {
        this.timeOfGoing = timeOfGoing;
    }

    public String getLocationOfArrival() {
        return locationOfArrival;
    }

    public void setLocationOfArrival(String locationOfArrival) {
        this.locationOfArrival = locationOfArrival;
    }

    public int getAmountOfGenSits() {
        return amountOfGenSits;
    }

    public void setAmountOfGenSits(int amountOfGenSits) {
        this.amountOfGenSits = amountOfGenSits;
    }

    public int getAmountOfCoupe() {
        return amountOfCoupe;
    }

    public void setAmountOfCoupe(int amountOfCoupe) {
        this.amountOfCoupe = amountOfCoupe;
    }

    public int getAmountOfPlanchet() {
        return amountOfPlanchet;
    }

    public void setAmountOfPlanchet(int amountOfPlanchet) {
        this.amountOfPlanchet = amountOfPlanchet;
    }

    public int getAmountOfLuxSits() {
        return amountOfLuxSits;
    }

    public void setAmountOfLuxSits(int amountOfLuxSits) {
        this.amountOfLuxSits = amountOfLuxSits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;

        Train train = (Train) o;

        if (getTrainNumber() != train.getTrainNumber()) return false;
        if (getAmountOfGenSits() != train.getAmountOfGenSits()) return false;
        if (getAmountOfCoupe() != train.getAmountOfCoupe()) return false;
        if (getAmountOfPlanchet() != train.getAmountOfPlanchet()) return false;
        if (getAmountOfLuxSits() != train.getAmountOfLuxSits()) return false;
        if (getTimeOfGoing() != null ? !getTimeOfGoing().equals(train.getTimeOfGoing()) : train.getTimeOfGoing() != null)
            return false;
        return getLocationOfArrival() != null ? getLocationOfArrival().equals(train.getLocationOfArrival()) : train.getLocationOfArrival() == null;
    }

    @Override
    public int hashCode() {
        int result = getTrainNumber();
        result = 31 * result + (getTimeOfGoing() != null ? getTimeOfGoing().hashCode() : 0);
        result = 31 * result + (getLocationOfArrival() != null ? getLocationOfArrival().hashCode() : 0);
        result = 31 * result + getAmountOfGenSits();
        result = 31 * result + getAmountOfCoupe();
        result = 31 * result + getAmountOfPlanchet();
        result = 31 * result + getAmountOfLuxSits();
        return result;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", timeOfGoing=" + timeOfGoing +
                ", locationOfArrival='" + locationOfArrival + '\'' +
                ", amountOfGenSits=" + amountOfGenSits +
                ", amountOfCoupe=" + amountOfCoupe +
                ", amountOfPlanchet=" + amountOfPlanchet +
                ", amountOfLuxSits=" + amountOfLuxSits +
                '}';
    }
}
