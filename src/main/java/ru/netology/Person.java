package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(PersonBuilder personBuilder) {
        if (personBuilder == null) {
            throw new IllegalArgumentException("Не удалось создать объект");
        }
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        if (personBuilder.hasAge()) {
            this.age = personBuilder.age;
        }
        if (personBuilder.hasAddress()) {
            this.address = personBuilder.address;
        }

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (this.age < 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return name + " " + surname + ": age = " + age + "; address = " + address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
