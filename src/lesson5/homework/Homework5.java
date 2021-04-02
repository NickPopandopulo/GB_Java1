package lesson5.homework;

/*
1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия
(для бега и плавания), или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (
бег: кот 200 м., собака 500 м.,Лошадь 1500 м., Птица 5 м.,;
прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м.;
плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
(Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег
может быть 400 м., у другой 600 м.
*/

public class Homework5 {

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            Dog dog = new Dog("Dog_"+i);
            System.out.println(dog.getName() + " run limit: " + Dog.getLimitRun());
            System.out.println(dog.getName() + " jump limit: " + Dog.getLimitJump());
            System.out.println(dog.getName() + " swim limit: " + Dog.getLimitSwim());
            dog.run(500);
            dog.jump(0.5);
            dog.swim(500);
            System.out.println();

            Horse horse = new Horse("Horse_"+i);
            System.out.println(horse.getName() + " run limit: " + Horse.getLimitRun());
            System.out.println(horse.getName() + " jump limit: " + Horse.getLimitJump());
            System.out.println(horse.getName() + " swim limit: " + Horse.getLimitSwim());
            horse.run(1500);
            horse.jump(3);
            horse.swim(100);
            System.out.println();

            Bird bird = new Bird("Bird_"+i);
            System.out.println(bird.getName() + " run limit: " + Bird.getLimitRun());
            System.out.println(bird.getName() + " jump limit: " + Bird.getLimitJump());
            bird.run(5);
            bird.jump(0.2);
            bird.swim(100);
            System.out.println();

            Cat cat = new Cat("Cat_"+i);
            System.out.println(cat.getName() + " run limit: " + Cat.getLimitRun());
            System.out.println(cat.getName() + " jump limit: " + Cat.getLimitJump());
            cat.run(200);
            cat.jump(2);
            cat.swim(100);
            System.out.println();

            System.out.println("—————————————————————————————————————————————————\n");
        }

    }

}
