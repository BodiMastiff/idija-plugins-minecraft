package ru.bodi.mineworld.core;

import java.lang.annotation.*;

@Inherited
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandName {
    String value();
}
