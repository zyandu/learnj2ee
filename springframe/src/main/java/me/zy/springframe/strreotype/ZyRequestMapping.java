package me.zy.springframe.strreotype;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZyRequestMapping {
    String value() default "";
}
