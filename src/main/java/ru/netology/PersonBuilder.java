package ru.netology;

public class PersonBuilder implements IPersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String address;


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

    public boolean hasAge() {
        return this.age != -1;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    @Override
    public Person build() {
        if (this.name == null || name.trim().isEmpty() || this.surname == null || surname.trim().isEmpty()) {
            throw new IllegalStateException("Ошибка. Имя и фамилия должны быть заполнены!");
        }
        return new Person(this);
    }
}
