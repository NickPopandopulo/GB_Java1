package Lesson04.online;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 27.03.2021
 */

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Program start");
        Hero hero1 = new Hero(150, 50, "Mario");
//        Hero hero2 = new Hero();
//        Hero hero3 = new Hero(250, 650, "Hero3");
//
//        System.out.println(hero1.getName());
//
//        hero1.setHealth(100);
//        System.out.println(hero1.getHealth());

//        hero1.name = "TestHero1";
//        hero1.health = 222;
//        hero1.speed = 22;

//        hero1.weapon.attack = 111;
//        hero1.weapon.getDamage();
//
//        hero2.name = "Сантехник Иван";
//        hero2.health = 10;
//        hero2.speed = 5;

//        hero1.weapon.attack = 999;
//        hero1.weapon.getDamage();

//        System.out.println("Name our hero1 is " + hero1.name);
//        System.out.println("HP our hero1 is " + hero1.health);
//        System.out.println("Speed our hero1 is " + hero1.speed);
//        System.out.println("---------------------");
//        System.out.println("Name our hero2 is " + hero2.name);
//        System.out.println("HP our hero2 is " + hero2.health);
//        System.out.println("Speed our hero2 is " + hero2.speed);
//
//        hero2 = hero1;
//        hero2.health = 999;
//        hero1.name = "Barsik";
//        System.out.println("Change name " + hero2.name);
//        System.out.println("Before Change name " + hero1.health);
//        hero1.speak("Hello from Console");
//        hero1.speak();
//        hero1.jump();
//        hero1.run();
//
//        hero2.speak("Сантехника вызывали?");
//        hero2.jump();
//        hero2.run();

//        System.out.println(hero1.health);
//        System.out.println(hero2.health);
//        System.out.println("hp3 = " + hero3.health);
//        System.out.println("sp3 = " + hero3.speed);
//        System.out.println("name3 = " + hero3.name);
//        Hero.voice();
//        System.out.println(Hero.countLegs);
//        hero1.getWeapon().attack = 111;

        System.out.println("Program finish");

    }
}

/**
 * 1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
 * 2 Конструктор класса должен заполнять эти поля при создании объекта;
 * 3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
 * 4 Вывести при помощи методов из пункта 3 ФИО и должность.
 * 5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 * 6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
 * 7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
 */
