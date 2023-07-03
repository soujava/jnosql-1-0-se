package org.example;

import com.github.javafaker.Faker;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.UUID;

@Entity
public record Dog(@Id String id, @Column String name, @Column String breed) {

    public static Dog create(Faker faker) {
        var dog = faker.dog();
        return new Dog(UUID.randomUUID().toString(), dog.name(), dog.breed());
    }
}
