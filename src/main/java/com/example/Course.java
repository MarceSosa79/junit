package com.example;

public class Course {
    private String title;
    private int duration;
    private String professor;

    // Constructor con toda la data
    public Course(String title, int duration, String professor) {
        setTitle(title); 
        this.duration = (duration < 0) ? 0 : duration;
        this.professor = (professor == null || professor.isEmpty()) ? "Unassigned" : professor;
    }

    // Constructor solo con titulo y duracion
    public Course(String title, int duration) {
        setTitle(title); 
        this.duration = (duration < 0) ? 0 : duration;
        this.professor = "Unassigned";
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getProfessor() {
        return professor;
    }

    // Setters
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede ser nulo o vacio");
        }
        this.title = title;
    }

    public void setProfessor(String professor) {
        this.professor = (professor == null || professor.isEmpty()) ? "Unassigned" : professor;
    }

    public String showInformation() {
        return title + " (" + duration + " hs) - Professor: " + professor;
    }
}