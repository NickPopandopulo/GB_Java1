package lesson5.homework;

import java.util.Random;

public class Cat extends Animal {

    private String name;
    private static double limitRun;
    private static double limitJump;

    Cat(String name) {
        this.name = name;
        limitRun = 200 + (new Random().nextInt(5) - 2) * 20;
        limitJump = 2 + (new Random().nextInt(5) - 2) * 0.2;
    }

    @Override
    protected void run(double distance) {
        if (distance <= limitRun) {
            System.out.println("Кот (" + name + ") пробежал!");
        } else {
            System.out.println("Кот (" + name + ") не пробежал " +
                    (distance - limitRun) + " м из " + distance + " м");
        }
    }

    @Override
    protected void swim(double distance) {
        System.out.println("Кот " + name + " не умеет плавать.");
    }

    @Override
    protected void jump(double distance) {
        if (distance <= limitJump) {
            System.out.println("Кот (" + name + ") прыгнул!");
        } else {
            System.out.println("Кот (" + name + ") недопрыгнул " +
                    (distance - limitJump) + " м из " + distance + " м");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getLimitRun() {
        return limitRun;
    }

    public static double getLimitJump() {
        return limitJump;
    }

}
