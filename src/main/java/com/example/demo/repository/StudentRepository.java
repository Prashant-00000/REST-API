package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * REPOSITORY LAYER (Data Access Layer)
 *
 * Role:
 * - Responsible for data storage, retrieval, and access operations.
 * - In this assignment, it manages an in-memory list of student names (no external database needed).
 *
 * Dependency Injection Concept:
 * - The @Repository annotation marks this class as a Spring Bean (managed component).
 * - During application startup, Spring's Inversion of Control (IoC) container detects
 *   this class via component scanning and creates an instance (a singleton by default).
 * - This bean will then be injected into any dependent component (such as StudentService)
 *   via Constructor-Based Dependency Injection.
 */
@Repository
public class StudentRepository {

    // In-memory data store for student names
    private final List<String> studentList = Arrays.asList("Prashant", "Rahul", "Amit");

    /**
     * Retrieves all student names from the in-memory data store.
     *
     * @return List of student names
     */
    public List<String> findAllStudents() {
        return studentList;
    }
}
