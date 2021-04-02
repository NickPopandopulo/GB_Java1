package lesson5.online.models;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 31.03.2021
 */

public class Titan extends Paladin {

    public Titan(String name, int health, int power, int attack, int defense, int countExp) {
        super(name, health, power, attack, defense, countExp);
    }

    @Override
    public void healSelf() {
        System.out.println(name + " don't heal");
    }

    @Override
    public void stableBlock(int damage) {
        System.out.println(name + " don't block");
    }

    @Override
    public void jump() {
        System.out.println("Jump Titan");
    }

}
