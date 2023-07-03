package org.example;

import java.util.List;

public interface PetQueries<T extends Pet> {

    List<T> findByName(String name);

    List<T> findByBreed(String breed);
}
