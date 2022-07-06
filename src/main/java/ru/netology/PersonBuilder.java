package ru.netology;

public class PersonBuilder implements IPersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;


    public PersonBuilder setName(String name) {
        if (name == null) {
            throw new IllegalStateException("Ошибка. Имя должно быть заполнено!");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalStateException("Ошибка. Фамилия должна быть заполнена!");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        if (age > 120) {
            throw new IllegalArgumentException("Кажется, в опечатались. Столько не живут!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Ошибка. Имя и фамилия должны быть заполнены!");
        }
        return new Person(name, surname, age, address);
    }

}
