package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import static org.junit.jupiter.api.Assertions.*;


public class OnlineCourseTest {

    private OnlineCourse course;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Iniciando pruebas para OnlineCourse...");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Finalizando pruebas para OnlineCourse.");
    }

    @BeforeEach
    void initEach() {
        System.out.println("Test OnlineCourse...");
        course = null;
    }

    @AfterEach
    void cleanupEach() {
        System.out.println("Limpieza OnlineCourse.");
        course = null;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/onlineCourses.csv", numLinesToSkip = 1)
    @DisplayName("Platforma asignada correctamente desde CSV")
    void testPlatformAssignedFromCsv(String title, int duration, String professor, String platform) {
        course = new OnlineCourse(title, duration, professor, platform);
        assertEquals(platform, course.getPlatform());
        assertEquals(professor, course.getProfessor());
    }

    @Test
    @DisplayName("showInformation() contiene la plataforma")
    void testShowInformationIncludesPlatform() {
        course = new OnlineCourse("Java", 140, "Giuli", "Bios");
        String info = course.showInformation();

        assertNotNull(info);
        assertTrue(info.contains("Bios"));
        assertTrue(info.contains("Java"));
        assertTrue(info.contains("Giuli"));
    }
}
