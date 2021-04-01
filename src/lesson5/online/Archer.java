package Lesson05.online;

import Lesson05.online.models.Hero;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 31.03.2021
 */

public class Archer extends Hero {

    public Archer(String name, int health, int power, int attack, int defense) {
        super(name, health, power, attack, defense);
//        System.out.println("This is constructor Archer");
    }

    @Override
    public void jump(){
        System.out.println("Jump Archer");
    }
}
