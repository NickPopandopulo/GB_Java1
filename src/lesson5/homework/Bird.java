package lesson5.homework;

import java.util.Random;

public class Bird extends Animal {

    private String name;
    private static double limitRun;
    private static double limitJump;

    Bird(String name) {
        this.name = name;
        limitRun = 5 + (new Random().nextInt(5) - 2) * 0.5;
        limitJump = 0.2 + (new Random().nextInt(5) - 2) * 0.05;
    }

    @Override
    protected void run(double distance) {
        if (distance <= limitRun) {
            System.out.println("Птица (" + name + ") пробежала!");
        } else {
            System.out.println("Птица (" + name + ") не пробежала " +
                    (distance - limitRun) + " м из " + distance + " м");
        }
    }

    @Override
    protected void swim(double distance) {
        System.out.println("Птица " + name + " не умеет плавать.");
    }

    @Override
    protected void jump(double distance) {
        if (distance <= limitJump) {
            System.out.println("Птица (" + name + ") прыгнула!");
        } else {
            System.out.println("Птица (" + name + ") недопрыгнула " +
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
