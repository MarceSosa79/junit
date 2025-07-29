package com.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de cursos a registrar: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        Course[] cursos = new Course[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Curso #" + (i + 1));
            cursos[i] = registerCourse(sc);
        }

        showCourses(cursos);

        sc.close();
    }

    public static Course registerCourse(Scanner sc) {
        System.out.print("Tipo (Online/OnSite): ");
        String tipo = sc.nextLine().trim();

        System.out.print("Título del curso: ");
        String titulo = sc.nextLine().trim();

        int duracion = requestDuration(sc);

        System.out.print("Profesor : ");
        String profesor = sc.nextLine();
        if (profesor.isEmpty()) {
            profesor = "Unassigned";
        }

        if (tipo.equalsIgnoreCase("Online")) {
            System.out.print("Plataforma: ");
            String plataforma = sc.nextLine().trim();
            return new OnlineCourse(titulo, duracion, profesor, plataforma);

        } else if (tipo.equalsIgnoreCase("OnSite")) {
            System.out.print("Aula: ");
            String aula = sc.nextLine().trim();
            int cupo = requestQuota(sc);
            return new OnSiteCourse(titulo, duracion, profesor, aula, cupo);

        } else {
            System.out.println("Tipo de curso inválido. Se salta este curso.");
            return null;
        }
    }

    public static int requestDuration(Scanner sc) {
        int duracion;
        do {
            System.out.print("Duración (hs): ");
            duracion = sc.nextInt();
            sc.nextLine();
            if (duracion < 0) {
                System.out.println("La duración no puede ser negativa.");
            }
        } while (duracion < 0);
        return duracion;
    }

    public static int requestQuota(Scanner sc) {
        int cupo;
        do {
            System.out.print("Cupo máximo: ");
            cupo = sc.nextInt();
            sc.nextLine();
            if (cupo < 0) {
                System.out.println("El cupo no puede ser negativo.");
            }
        } while (cupo < 0);
        return cupo;
    }

    public static void showCourses(Course[] cursos) {
        System.out.println("\n=== Información de cursos registrados ===");
        for (Course c : cursos) {
            System.out.println(c.showInformation());
        }
    }
}