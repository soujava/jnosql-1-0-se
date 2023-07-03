package org.example;

import java.util.List;

public interface AnimalQueries<T extends Animal> {

    List<T> findByName(String name);

    List<T> findByBreed(String breed);
}
