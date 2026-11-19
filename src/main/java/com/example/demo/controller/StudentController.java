package com.example.demo.controller;

import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CONTROLLER LAYER (Presentation / API Layer)
 *
 * Role:
 * - Handles incoming HTTP requests from clients (browsers, Postman, mobile apps).
 * - Delegates the processing to the Service layer and returns the HTTP response.
 *
 * Annotations:
 * - @RestController: Combines @Controller and @ResponseBody. Tells Spring that the return
 *   values of handler methods should be serialized directly into HTTP response body (as JSON).
 * - @RequestMapping("/students"): Defines the base URL path for all endpoints in this controller.
 *
 * Dependency Injection Concept:
 * - StudentController depends on StudentService to perform business operations.
 * - We inject StudentService through the constructor, maintaining loose coupling and
 *   demonstrating Constructor-Based Dependency Injection.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    // Final reference ensuring immutability
    private final StudentService studentService;

    /**
     * Constructor-Based Dependency Injection:
     * Spring automatically injects the StudentService bean into this controller.
     *
     * @param studentService the service bean injected by Spring IoC container
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * GET Endpoint: http://localhost:8080/students
     *
     * Retrieves the list of student names from the service layer
     * and returns it as a JSON array.
     *
     * @return List of student names serialized into JSON: ["Prashant", "Rahul", "Amit"]
     */
    @GetMapping
    public List<String> getStudents() {
        return studentService.getAllStudents();
    }
}
