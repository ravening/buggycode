package com.example.reflection.models.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Annotation are available at 3 stages
// 1. compile 2. class loading time 3. Runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {
}
