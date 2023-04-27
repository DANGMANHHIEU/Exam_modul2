package view;

import controller.Manage;
import model.Student;

import java.util.Scanner;

public class Client {
    public static Manage manage=new Manage();

    public static void Display(){
        manage.displayStudent();
    }
    public static void Add(){
        Check check=new Check();
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập mã sinh viên (SV000000):");
        String id = sc.nextLine();
        while (!check.checkId(id)){
            System.out.println("\u001B[31m"+"Mã sinh viên không đúng(SV000000)!!!"+"\u001B[0m");
            id=sc.nextLine();
        }

        System.out.println("Nhập họ và tên:");
        String name = sc.nextLine();
        while (!check.checkName(name)){
            System.out.println("\u001B[31m"+"Tên không đúng định dạng !!!"+"\u001B[0m");
            name=sc.nextLine();
        }

        System.out.println("Nhập tuổi: ");
        String age= sc.nextLine();

        System.out.println("Nhập giới tính: ");
        String gender=sc.nextLine();

        System.out.println("Nhập địa chỉ: ");
        String address=sc.nextLine();

        System.out.println("Nhập điểm: ");
         double averageScores=sc.nextDouble();

        Student student= new Student(id,name,age,gender,address,averageScores);
        manage.addStudent(student);
    }

    public static void Delete(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập mã sinh viên:");
        String id = sc.nextLine();
        manage.deleteStudent(id);
        System.out.println("\u001B[31m"+"Xóa sinh viên thành công !!!"+"\u001B[0m");
    }

    public static void Update(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\u001B[32m"+"Nhập mã sinh viên:"+"\u001B[0m");
        String id =sc.nextLine();
        manage.updateStudent(id);
    }

    public static void Sort(){
        manage.sort();
    }

    public static void Read(){
        String file= "student.csv";
        manage.readFile(file);
    }

    public static void Write(){
        String file="student.csv";
        manage.writeFile(file,manage.getStudentList());
    }
}
