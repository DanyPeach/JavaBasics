package com.by.lab4;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Puppy("Sharik", 1, "Shitzu");
        dog1.run();
        dog1.voiceUp("gav bitch");
        dog1.jump();

        Animal dog2 = new Puppy("Sharik", 1, "Shitzu");

        System.out.println(dog2.equals(dog1));
        dog1.getClassName();
        dog2.getClassName();

    }


}
