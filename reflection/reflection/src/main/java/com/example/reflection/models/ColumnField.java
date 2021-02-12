package com.example.reflection.models;

import java.lang.reflect.Field;

public class ColumnField {
    private Field field;

    ColumnField(Field field) {
        this.field = field;
    }

    public String getName() {
        return this.field.getName();
    }

    public Class<?> getType() {
        return this.field.getType();
    }
}
