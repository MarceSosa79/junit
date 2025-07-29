package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import static org.junit.jupiter.api.Assertions.*;

public class OnSiteCourseTest {

    private OnSiteCourse course;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Iniciando pruebas para OnSiteCourse...");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Finalizando pruebas para OnSiteCourse.");
    }

    @BeforeEach
    void initEach() {
        System.out.println("Test OnSiteCourse...");
        course = null;
    }

    @AfterEach
    void cleanupEach() {
        System.out.println("Limpieza OnSiteCourse.");
        course = null;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/onSiteCourses.csv", numLinesToSkip = 1)
    @DisplayName("Room y Quota asignados desde CSV")
    void testRoomAndQuotaCsv(String title, int duration, String professor, String room, int quota) {
        course = new OnSiteCourse(title, duration, professor, room, quota);
        assertEquals(room, course.getRoom());
        assertEquals(quota, course.getMaxQuota());
    }

    @Test
    @DisplayName("showInformation() incluye sala y cupo")
    void testShowInformationIncludesRoomAndQuota() {
        course = new OnSiteCourse("Redes", 60, "Maria Julia", "402", 30);
        String info = course.showInformation();

        assertNotNull(info);
        assertTrue(info.contains("402"));
        assertTrue(info.contains("30"));
        assertTrue(info.contains("Redes"));
    }
}
