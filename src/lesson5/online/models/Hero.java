package Lesson05.online.models;

import Lesson05.online.Lesson05;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 31.03.2021
 */

public abstract class Hero {

    protected String name;
    protected int health;
    protected int power;
    protected int attack;
    protected int defense;

    public Hero() {

    }

    public Hero(String name, int health, int power, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.attack = attack;
        this.defense = defense;
//        System.out.println("This is constructor Hero");
    }

    public void damage() {
        System.out.println(name + " get damage " + (attack + power) + " points");
    }

    public void speak() {
        System.out.println(name + " says something");
    }

    public void healSelf() {
        int dif = power * 2;
        System.out.println(name + " heal self " + dif);
        this.health += dif;
    }

    protected abstract void jump();

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
