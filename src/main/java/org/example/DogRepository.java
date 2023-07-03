package org.example;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;
import jakarta.enterprise.event.Event;

@Repository
public interface DogRepository extends PageableRepository<Dog, String>,
        PetQueries<Dog> {

    default Dog register(Dog dog, Event<Pet> event) {
        event.fire(dog);
        return this.save(dog);
    }
}
