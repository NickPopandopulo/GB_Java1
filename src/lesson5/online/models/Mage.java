package lesson5.online.models;

import Lesson05.online.models.Hero;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 31.03.2021
 */

public class Mage extends Hero {

    public Mage(String name, int health, int power, int attack, int defense) {
        super(name, health, power, attack, defense);
//        System.out.println("This is constructor Mage");
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println(name + " do something");
    }

    @Override
    public void jump() {
        System.out.println("Jump mage");
    }
}
