package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Course course;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Iniciando pruebas para Course...");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Finalizando pruebas para Course.");
    }

    @BeforeEach
    void initEach() {
        System.out.println("Ejecutando nuevo test...");
        course = null;
    }

    @AfterEach
    void cleanupEach() {
        System.out.println("Limpiando instancia de Course.");
        course = null;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/courses.csv", numLinesToSkip = 1)
    @DisplayName("Verificar valores del constructor con CSV")
    void testConstructorWithCsv(String title, int duration, String professor) {
        course = new Course(title, duration, professor);
        assertEquals(title, course.getTitle());
        assertEquals(duration, course.getDuration());
        assertEquals(professor, course.getProfessor());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/courses.csv", numLinesToSkip = 1)
    @DisplayName("Verificar profesor 'Unassigned' si no se pasa nombre")
    void testConstructorWithoutProfessorCsv(String title, int duration, String professor) {
        if (professor == null || "null".equalsIgnoreCase(professor) || professor.isEmpty()) {
            course = new Course(title, duration);
            assertEquals("Unassigned", course.getProfessor());
    }
}
    @Test
    @DisplayName("Método showInformation() contiene los datos esperados")
    void testShowInformationManual() {
        course = new Course("Testing", 60, "Carlos Gutierrez");
        String info = course.showInformation();
        assertNotNull(info);
        assertTrue(info.contains("Testing"));
        assertTrue(info.contains("60"));
        assertTrue(info.contains("Ca"));
    }
}
