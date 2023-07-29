package com.shvayko.crud.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    @NotNull(message="Имя должно быть заполнено!")
    @Pattern(regexp = "^[A-ZА-Я][a-zа-я]*$", message = "Вы ввели неккоретное значение!")
    private String name;

    @Column(name= "last_name")
    @NotNull(message="Фамилия должна быть заполнена!")
    @Pattern(regexp = "^[A-ZА-Я][a-zа-я]*$", message = "Вы ввели неккоретное значение!")
    private String surname;

    public User(){

    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return id + "       " + name + "  " + surname;
    }
}
