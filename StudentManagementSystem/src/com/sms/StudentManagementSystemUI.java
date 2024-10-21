package com.sms;

import java.util.Scanner;

public class StudentManagementSystemUI {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("");

            System.out.println("************************************************************************************");
            System.out.println("**************************   Student Management System   ***************************");
            System.out.println("************************************************************************************");
            System.out.println("*************************        1. Add Student           **************************");
            System.out.println("************************       2. Remove Student           *************************");
            System.out.println("*************************    3. Search for Student        **************************");
            System.out.println("**************************   4. Display All Students     ***************************");
            System.out.println("***************************         5. Exit             ****************************");
            System.out.println("************************************************************************************");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentUI(sms, scanner);
                    break;
                case 2:
                    removeStudentUI(sms, scanner);
                    break;
                case 3:
                    searchStudentUI(sms, scanner);
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addStudentUI(StudentManagementSystem sms, Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        sms.addStudent(new Student(name, rollNumber, grade, email, phoneNumber));
        System.out.println("Student added successfully!");
    }

    private static void removeStudentUI(StudentManagementSystem sms, Scanner scanner) {
        System.out.print("Enter Roll Number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        if (sms.removeStudent(rollNumber)) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudentUI(StudentManagementSystem sms, Scanner scanner) {
        System.out.print("Enter Roll Number of the student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }
}
