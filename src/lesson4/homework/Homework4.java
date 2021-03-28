package lesson4.homework;

/*
1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
2 Конструктор класса должен заполнять эти поля при создании объекта;
3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
4 Вывести при помощи методов из пункта 3 ФИО и должность.
5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
*/

public class Homework4 {

    public static void main(String[] args) {
        Employee[] staff = new Employee[5];

        staff[0] = new Employee("Иванов А.В.", "директор", "+73822654731", 200000, 55);
        staff[1] = new Employee("Петров Б.А.", "заместитель директора", "+73822473168", 100000, 45);
        staff[2] = new Employee("Краснова Г.С.", "секретарь", "+73822716924", 75000, 30);
        staff[3] = new Employee("Большов Н.В.", "менеджер", "+73822321789", 70000, 34);
        staff[4] = new Employee("Голунова Т.А.", "менеджер", "+73822147369", 70000, 37);

        // --- Задание № 4, 5 ---
        System.out.println("Список сотрудников старше 40 лет:");
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 40) {
                System.out.println("ID: " + staff[i].getId() + ", " + staff[i].getFullName() + ", " +
                        staff[i].getPost() + ", " + staff[i].getAge() + " лет");
            }
        }
        System.out.println();

        // --- Задание № 6 ---
        System.out.println("Список сотрудников (зарплата повышена у тех, кому больше 35 лет):");
        raiseSalary(staff);
        for (int i = 0; i < staff.length; i++) {
            System.out.println("ID: " + staff[i].getId() + ", " + staff[i].getFullName() + ", " +
                    staff[i].getPost() + ", " + staff[i].getAge() + " лет, " + staff[i].getSalary() + " руб.");
        }
        System.out.println();

        // --- Задание № 7 ---
        staff[2] = new Employee("Зеленина В.П.", "временный секретарь", "+73822159753", 70000, 38);
        System.out.println("Появился сотрудник, временно замещающий секретаря. Список сотрудников:");
        for (int i = 0; i < staff.length; i++) {
            System.out.println("ID: " + staff[i].getId() + ", " + staff[i].getFullName() + ", " +
                    staff[i].getPost() + ", " + staff[i].getAge() + " лет, " + staff[i].getSalary() + " руб.");
        }
        System.out.println();
    }

    public static void raiseSalary(Employee[] staff) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 35) {
                staff[i].setSalary(staff[i].getSalary() + 10000);
            }
        }
    }

}
