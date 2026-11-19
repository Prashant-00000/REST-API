package com.example.demo.service;

import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SERVICE LAYER (Business Logic Layer)
 *
 * Role:
 * - Sits between the Controller and the Repository.
 * - Encapsulates business logic, rules, calculations, and data validations.
 *
 * Dependency Injection Concept:
 * - The @Service annotation marks this class as a Spring Bean within the IoC container.
 * - This class depends on StudentRepository to fetch student data.
 * - Instead of manually creating an instance using 'new StudentRepository()', we use
 *   CONSTRUCTOR-BASED DEPENDENCY INJECTION.
 * - Spring's IoC container automatically provides (injects) the StudentRepository instance
 *   when it creates the StudentService bean.
 *
 * Why Constructor Injection over Field Injection?
 * 1. Immutability: Dependencies can be declared 'final', ensuring they cannot be modified after construction.
 * 2. Testability: Easy to mock or inject dependencies in unit tests without reflection or starting Spring.
 * 3. Null Safety: Prevents NullPointerExceptions because the object cannot be created without required dependencies.
 * 4. Detection of Code Smells: Having too many constructor parameters warns us that the class has too many responsibilities.
 */
@Service
public class StudentService {

    // Final dependency reference ensures immutability and thread safety
    private final StudentRepository studentRepository;

    /**
     * Constructor-Based Dependency Injection:
     * In Spring 4.3+, if a class has a single constructor, the @Autowired annotation
     * is optional; Spring automatically injects the required beans.
     *
     * @param studentRepository the repository bean injected by Spring IoC container
     */
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Business method to retrieve the list of all students.
     *
     * @return List of student names
     */
    public List<String> getAllStudents() {
        return studentRepository.findAllStudents();
    }
}
