package com.example.Suites;

import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({
    com.example.CourseTest.class,
    com.example.OnlineCourseTest.class,
    com.example.OnSiteCourseTest.class
})
public class AllTestsSuite {
}