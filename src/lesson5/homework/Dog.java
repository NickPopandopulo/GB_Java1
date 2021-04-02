package lesson5.homework;

import java.util.Random;

public class Dog extends Animal {

    private String name;
    private static double limitRun;
    private static double limitJump;
    private static double limitSwim;

    Dog(String name) {
        this.name = name;
        limitRun = 500 + (new Random().nextInt(5) - 2) * 50;
        limitJump = 0.5 + (new Random().nextInt(5) - 2) * 0.1;
        limitSwim = 10 + (new Random().nextInt(5) - 2) * 2;
    }

    @Override
    protected void run(double distance) {
        if (distance <= limitRun) {
            System.out.println("Собака (" + name + ") пробежала!");
        } else {
            System.out.println("Собака (" + name + ") не пробежала " +
                    (distance - limitRun) + " м из " + distance + " м");
        }
    }

    @Override
    protected void swim(double distance) {
        if (distance <= limitSwim) {
            System.out.println("Собака (" + name + ") проплыла!");
        } else {
            System.out.println("Собака (" + name + ") не проплыла " +
                    (distance - limitSwim) + " м из " + distance + " м");
        }
    }

    @Override
    protected void jump(double distance) {
        if (distance <= limitJump) {
            System.out.println("Собака (" + name + ") проплыла!");
        } else {
            System.out.println("Собака (" + name + ") не проплыла " +
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

    public static double getLimitSwim() {
        return limitSwim;
    }
}
