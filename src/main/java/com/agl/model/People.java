package com.agl.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class People {

    @JsonSerialize
    private Long age;
    @JsonSerialize
    private String gender;
    @JsonSerialize
    private String name;
    @JsonSerialize
    private List<Pet> Pets = new ArrayList<>();

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return Pets;
    }

    public void setPets(List<Pet> pets) {
        Pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(age, people.age) &&
                Objects.equals(gender, people.gender) &&
                Objects.equals(name, people.name) &&
                Objects.equals(Pets, people.Pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, gender, name, Pets);
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", Pets=" + Pets +
                '}';
    }
}
