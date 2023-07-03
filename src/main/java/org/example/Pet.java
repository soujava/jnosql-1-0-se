package org.example;

public sealed interface Pet permits Cat, Dog {

    String name();
    String breed();
}
