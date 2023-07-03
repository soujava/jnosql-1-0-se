package org.example;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;
import jakarta.enterprise.event.Event;

@Repository
public interface DogRepository extends PageableRepository<Dog, String>,
        AnimalQueries<Dog> {

    default Dog register(Dog dog, Event<Dog> event) {
        event.fire(dog);
        return this.save(dog);
    }
}
