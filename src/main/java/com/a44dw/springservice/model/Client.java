package com.a44dw.springservice.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {

    @Column(name = "name")
    @NotEmpty(message = "Не должно быть пустым!")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Не должно быть пустым!")
    private String surname;

    @Column(name = "telephone")
    @NotEmpty(message = "Не должно быть пустым!")
    @Digits(fraction = 0, integer = 10, message = "Телефон должен состоять из 10 цифр!")
    private String telephone;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
