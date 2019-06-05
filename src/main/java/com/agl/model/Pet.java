package com.agl.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

public class Pet {

    @JsonSerialize
    private String name;
    @JsonSerialize
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) &&
                Objects.equals(type, pet.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
