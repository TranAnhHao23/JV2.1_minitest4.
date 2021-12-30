package main;

import manage.StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();
        int choice;
        do {
            System.out.println("------------------------Menu------------------------");
            System.out.println("1. Add new Student");
            System.out.println("2. Update Student via ID");
            System.out.println("3. Delete Student via ID");
            System.out.println("4. Display all Student");
            System.out.println("5. Display Student list by Increasing Average Point");
            System.out.println("6. Display Student list by Decreasing Average Point");
            System.out.println("7. Write to CSV file");
            System.out.println("8. Read from CSV file");
            System.out.println("0. Exit");
            System.out.println("----------------------------------------------------");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    System.out.print("Input Student ID: ");
                    int idUpdate = sc.nextInt();
                    if (manager.updateStudent(idUpdate) != null){
                        System.out.println(manager.updateStudent(idUpdate));
                        System.out.println("Update success!");
                    } else {
                        System.out.println("Student ID doesn't exist!");
                    }
                    break;
                case 3:
                    System.out.print("Input Student ID: ");
                    int idDelete = sc.nextInt();
                    if (manager.deleteStudent(idDelete) != null){
                        System.out.println(manager.deleteStudent(idDelete));
                        System.out.println("Delete success!");
                    } else {
                        System.out.println("Student ID doesn't exist!");
                    }
                    break;
                case 4:
                    if (!manager.displayStudent().isEmpty()){
                        manager.displayStudent().forEach((System.out::println));
                    } else {
                        System.out.println("List have no Student!");
                    }
                    break;
                case 5:
                    manager.arrangePointIncreasing();
                    manager.displayStudent().forEach((System.out::println));
                    break;
                case 6:
                    manager.arrangePointDecreasing();
                    manager.displayStudent().forEach((System.out::println));
                    break;
                case 7:
                    manager.writeCSV(manager.displayStudent());
                    break;
                case 8:
                    manager.readCSV().forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("See ya!");
                    break;
                default:
                    System.out.println("Wrong choice!!!");
                    break;
            }
        } while (choice != 0);

    }


}
