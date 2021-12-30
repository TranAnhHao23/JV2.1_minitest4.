package manage;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
    public static final String PATH_NAME = "src/saveFile.csv";
    ArrayList<Student> students = readCSV();
    Scanner sc = new Scanner(System.in);

    public StudentManager() {
    }

    public Student creatStudent() {
        System.out.println("Input Student Info: ");
        System.out.print("ID: ");
        int id = sc.nextInt();
        for (Student student : students) {
            if (student.getId() == id) {
                return null;
            }
        }
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Math Point: ");
        double mathPoint = sc.nextDouble();
        System.out.print("Physics Point: ");
        double physicsPoint = sc.nextDouble();
        System.out.print("Chemistry Point: ");
        double chemisPoint = sc.nextDouble();

        return new Student(id, name, age, mathPoint, physicsPoint, chemisPoint);
    }

    public void addStudent() {
        Student student = creatStudent();
        if (student != null) {
            students.add(student);
            writeCSV(displayStudent());
        } else {
            System.out.println("ID matched. Fail!!!");
        }

    }

    public Student updateStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, creatStudent());
                writeCSV(displayStudent());
                return students.get(i);
            }
        }
        return null;

    }

    public void deleteStudent(int id) {
        boolean check = false;
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);
                students.remove(student);
                writeCSV(displayStudent());
                check = true;
            }
        }
        if (!check){
            System.out.println("Student ID doesn't exist!");
        }
    }

    public ArrayList<Student> displayStudent() {
        return students;
    }

    public void arrangePointIncreasing() {

        students.sort((Comparator.comparing(Student::getAveragePoint)));

//        for (int i = 0; i < students.size(); i++) {
//            for (int j = 0; j < students.size(); j++) {
//                if (students.get(i).getAveragePoint() > students.get(j).getAveragePoint()){
//                    Student temp = students.get(i);
//                    students.set(i,students.get(j));
//                    students.set(j,temp);
//                }
//            }
//        }
    }

    public void arrangePointDecreasing() {
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (students.get(i).getAveragePoint() < students.get(j).getAveragePoint()) {
                    Student temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
    }

    public void writeCSV(ArrayList<Student> studentList) {
        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_NAME));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_NAME));
            for (Student student : studentList) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getMathPoint() + "," + student.getPhysicsPoint() + "," + student.getChemisPoint() + "," + student.getAveragePoint());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            System.out.println("Write Success");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Write Fail");
        }
    }

    public ArrayList<Student> readCSV() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_NAME));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentInfo = line.split(",");
                studentArrayList.add(new Student(Integer.parseInt(studentInfo[0]), studentInfo[1], Integer.parseInt(studentInfo[2]), Double.parseDouble(studentInfo[3]), Double.parseDouble(studentInfo[4]), Double.parseDouble(studentInfo[5])));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return studentArrayList;
    }


}
