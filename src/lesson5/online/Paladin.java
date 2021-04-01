package Lesson05.online;

import Lesson05.online.models.Hero;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 31.03.2021
 */

public class Paladin extends Hero {

    int countExp;

    public Paladin(String name, int health, int power, int attack, int defense) {
        super(name, health, power, attack, defense);
        this.countExp = -1;
//        System.out.println("This is constructor Paladin");
    }

    public Paladin(String name, int health, int power, int attack, int defense, int countExp) {
        super(name, health, power, attack, defense);
        this.countExp = countExp;
    }

    void stableBlock(int damage) {
        System.out.println(name + " has block damage " + defense);
        this.health -= damage - defense;
    }

    @Override
    public void jump() {
        System.out.println("Jump Paladin");
    }



}
