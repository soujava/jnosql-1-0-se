package org.example;

import jakarta.data.repository.PageableRepository;

public interface CatRepository extends PageableRepository<Cat, String>,
        AnimalQueries<Cat> {
}
