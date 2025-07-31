package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

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

    //Nueva version con MethodSource
    @ParameterizedTest
    @MethodSource("courseDataFromCsv")
    @DisplayName("Verificar valores del constructor con datos del CSV con MethodSource")
    void testConstructorWithMethodSource(String title, int duration, String professor) {
        course = new Course(title, duration, professor);
        assertEquals(title, course.getTitle());
        assertEquals(duration, course.getDuration());
        assertEquals(professor, course.getProfessor());
    }

    static Stream<Arguments> courseDataFromCsv() {
        return Stream.of(
            Arguments.of("Testing", 60, "Carlos Gutierrez"),
            Arguments.of("Java", 140, "Hernesto Gonzalez"),
            Arguments.of("Automation", 90, "Giuli")
        );
    }
    @Order(1)
    @Tag("smoke")
    @ParameterizedTest
    @CsvFileSource(resources = "/courses.csv", numLinesToSkip = 1)
    @DisplayName("Verificar profesor 'Unassigned' si no se pasa nombre")
    void testConstructorWithoutProfessorCsv(String title, int duration, String professor) {
        if (professor == null || "null".equalsIgnoreCase(professor) || professor.isEmpty()) {
            course = new Course(title, duration);
            assertEquals("Unassigned", course.getProfessor());
    }
}
    @Order(2)
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
    @Order(3)
    @Tag("regression")
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("setTitle deberia lanzar excepcion si el titulo es nulo o vacio")
    void testSetTitleWithNullOrEmpty(String invalidTitle) {
        course = new Course("Inicial", 60, "Carlos Gutierrez");

        assertThrows(IllegalArgumentException.class, () -> {
            course.setTitle(invalidTitle);
        });
    }
}
