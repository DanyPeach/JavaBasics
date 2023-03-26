package com.by.lab4;

import java.util.Objects;

public class Dog extends Animal{
    private String breed;
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void voiceUp(String gavLang){
        System.out.println("Dog with name:" + getName() + " said \""+ gavLang + "\"");
    }


    public void bite(){
        System.out.println("Dog with name:" + getName() + " bite so hard i screamed");
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return breed.equals(dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed);
    }

    @Override
    public String toString() {
        return "Dog{ name= " + getName() + " age " + getAge() +
                "breed='" + breed + '\'' +
                '}';
    }
}
