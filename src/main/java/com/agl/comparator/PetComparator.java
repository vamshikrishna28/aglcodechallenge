package com.agl.comparator;

import com.agl.model.Pet;

import java.util.Comparator;

public class PetComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet o1, Pet o2) {
        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    }
}

