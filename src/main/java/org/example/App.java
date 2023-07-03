package org.example;

import com.github.javafaker.Faker;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;

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

        }
    }
}
