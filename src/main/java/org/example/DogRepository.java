package org.example;

import jakarta.data.repository.PageableRepository;

public interface DogRepository extends PageableRepository<Dog, String>,
        AnimalQueries<Dog> {
}
