package com.example.reflection.models;

import java.lang.reflect.Field;

public class PrimaryKeyField {
    private Field field;

    PrimaryKeyField(Field field) {
        this.field = field;
    }

    public String getName() {
        return this.field.getName();
    }

    public Class<?> getType() {
        return this.field.getType();
    }
}
