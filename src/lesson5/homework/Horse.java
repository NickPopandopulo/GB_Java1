package lesson5.homework;

import java.util.Random;

public class Horse extends Animal {

    private String name;
    private static double limitRun;
    private static double limitJump;
    private static double limitSwim;

    Horse(String name) {
        this.name = name;
        limitRun = 1500 + (new Random().nextInt(5) - 2) * 200;
        limitJump = 3 + (new Random().nextInt(5) - 2) * 0.5;
        limitSwim = 100 + (new Random().nextInt(5) - 2) * 10;
    }

    @Override
    protected void run(double distance) {
        if (distance <= limitRun) {
            System.out.println("Лошадь (" + name + ") пробежала!");
        } else {
            System.out.println("Лошадь (" + name + ") не пробежала " +
                    (distance - limitRun) + " м из " + distance + " м");
        }
    }

    @Override
    protected void swim(double distance) {
        if (distance <= limitSwim) {
            System.out.println("Лошадь (" + name + ") проплыла!");
        } else {
            System.out.println("Лошадь (" + name + ") не проплыла " +
                    (distance - limitSwim) + " м из " + distance + " м");
        }
    }

    @Override
    protected void jump(double distance) {
        if (distance <= limitJump) {
            System.out.println("Лошадь (" + name + ") прыгнула!");
        } else {
            System.out.println("Лошадь (" + name + ") недопрыгнула " +
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
