package com.by.lab4;

public class Puppy extends Dog{
    public Puppy(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    public void run() {
        System.out.println("Little puppy " + getName() + " start to run");
    }


    @Override
    public void voiceUp(String gavLang) {
        super.voiceUp(gavLang);
    }

    @Override
    public void bite() {
        System.out.println("Its a puppy, its dont have teeth yet");
    }

    @Override
    public void jump() {
        super.jump();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
