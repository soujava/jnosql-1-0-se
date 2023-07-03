package org.example;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

@Repository
public interface CatRepository extends PageableRepository<Cat, String>,
        AnimalQueries<Cat> {
}
