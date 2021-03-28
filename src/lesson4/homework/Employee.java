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

public class Employee {

    private String fullName;
    private String post;
    private String phoneNumber;
    private double salary;
    private int age;
    private int id;
    private static int lastId;

    public Employee(String fullName, String post, String phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        this.id = ++lastId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPost() {
        return post;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void raiseSalary() {
        if (this.age > 35) {
            this.salary += 10000;
        }
    }

}
