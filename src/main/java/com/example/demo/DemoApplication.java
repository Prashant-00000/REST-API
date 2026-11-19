package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MAIN ENTRY POINT OF THE SPRING BOOT APPLICATION
 *
 * Annotations:
 * - @SpringBootApplication: A convenience annotation that combines:
 *   1. @Configuration: Tags the class as a source of bean definitions for the application context.
 *   2. @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings.
 *   3. @ComponentScan: Tells Spring to scan for components (@Component, @Service, @Repository, @RestController)
 *      in the current package ("com.example.demo") and all sub-packages.
 *
 * Flow of Execution:
 * 1. SpringApplication.run() starts the embedded Apache Tomcat web server (port 8080).
 * 2. Component Scanning finds:
 *      - StudentRepository (@Repository) -> Creates repository bean
 *      - StudentService (@Service)       -> Injects StudentRepository into StudentService constructor
 *      - StudentController (@RestController) -> Injects StudentService into StudentController constructor
 * 3. The three-layer architecture is wired together automatically via Dependency Injection!
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
