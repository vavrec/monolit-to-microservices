package cz.vavrecka.shared.exception.handler.controller;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(basePackages = {"cz.vavrecka.shared.exception.handler.controller"})
public @interface ControllerExceptionHandler {
}
