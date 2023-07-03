package org.example;

import com.github.javafaker.Faker;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.UUID;

@Entity
public record Cat(@Id String id, @Column String name, @Column String breed) implements Animal {

    public static Cat create(Faker faker) {
        var cat = faker.cat();
        return new Cat(UUID.randomUUID().toString(), cat.name(), cat.breed());
    }
}
