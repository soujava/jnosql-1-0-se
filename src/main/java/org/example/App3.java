package org.example;

import com.github.javafaker.Faker;
import jakarta.data.repository.Page;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.Sort;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.util.TypeLiteral;

public class App3
{
    public static void main( String[] args )
    {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()){
            var faker = new Faker();

            DogRepository repository = container.select(DogRepository.class).get();
            Event<Pet> event = container.select(new TypeLiteral<Event<Pet>>() {
            }).get();
            var dog = Dog.create(faker);
            System.out.println("The register result: " +   repository.register(dog, event));

            var optional = repository.findByBreed(dog.breed());
            System.out.println("The result: " + optional);

            for (int index = 0; index < 100; index++) {
                repository.save(Dog.create(faker));
            }

            Pageable pageable = Pageable.ofSize(10).sortBy(Sort.asc("name"),
                    Sort.asc("breed"));

            Page<Dog> dogs = repository.findAll(pageable);
            while (dogs.hasContent()) {
                System.out.println("The page number: " + pageable.page());
                System.out.println("The dogs: " + dogs.stream().count());
                System.out.println("\n\n");
                pageable = pageable.next();
                dogs = repository.findAll(pageable.next());
            }
            repository.deleteAll();

        }
    }
}
