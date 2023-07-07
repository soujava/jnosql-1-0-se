package org.example;

import com.github.javafaker.Faker;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;

import java.util.List;
import java.util.Optional;

public class App
{
    public static void main( String[] args )
    {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()){
            var faker = new Faker();

            Template template = container.select(Template.class).get();
            var cat = Cat.create(faker);
            template.insert(cat);

            Optional<Cat> optional = template.find(Cat.class, cat.id());
            System.out.println("The result: " + optional);

            for (int index = 0; index < 100; index++) {
                template.insert(Cat.create(faker));
            }
            List<Cat> result = template.select(Cat.class).where("breed").eq(cat.breed()).result();
            System.out.println("The query by breed: " + result);
            template.delete(Cat.class, cat.id());
        }
    }
}
