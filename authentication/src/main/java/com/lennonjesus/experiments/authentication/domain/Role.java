package com.lennonjesus.experiments.authentication.domain;

/**
 * @author Lennon Jesus
 */
public enum Role {

    USER("USER"), ADMIN("ADMIN");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}