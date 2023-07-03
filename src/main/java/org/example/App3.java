package org.example;

import com.github.javafaker.Faker;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.util.TypeLiteral;
import jakarta.nosql.Template;

public class App3
{
    public static void main( String[] args )
    {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()){
            var faker = new Faker();

            DogRepository repository = container.select(DogRepository.class).get();
            Event<Animal> event = container.select(new TypeLiteral<Event<Animal>>() {
            }).get();
            var dog = Dog.create(faker);
            System.out.println("The register result: " +   repository.register(dog, event));

            var optional = repository.findByBreed(dog.breed());
            System.out.println("The result: " + optional);

        }
    }
}
