package Lesson04.online;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 27.03.2021
 */

public class Hero {

    private int health;
    private int speed;
    private String name;
    private Weapon weapon;
    static int countLegs = 2;

    public Hero() {

    }

    public Hero(int health, int speed, String name) {
        this.health = health;
        this.speed = speed;
        this.name = name;
        this.weapon = new Weapon();
    }

    class Weapon {
        int attack;
        int weight;
        float atkSpeed;

        void getDamage() {
            System.out.println(name + " get damage " + attack + " points");
        }
    }

    void speak(String msg) {
        System.out.println(name + " says " + msg);
    }

    void speak() {
        System.out.println(name + " says Hello!!!");
    }

    void jump() {
        System.out.println(name + " jump");
    }

    void run() {
        System.out.println(name + " run with speed " + speed);
    }

    //Getter
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    //Setter
    public void setHealth(int health) {
        this.health = health;
    }

    public static void voice() {
        System.out.println("Something voice");
    }

}
