package controller;

import model.Student;
import view.Check;

import java.awt.*;
import java.util.*;
import java.util.List;
import model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage {
    Scanner sc = new Scanner(System.in);
    private List<Student> studentList;

    public Manage() {
        this.studentList = new ArrayList<>();
    }

    public Manage(List<Student> studentList) {
        this.studentList = studentList;
    }

    // check id
    public boolean checkId(Student student) {
        boolean check = false;
        for (Student e : studentList) {
            if (e.getId().equals(student.getId())) {
                check = true;
            }
        }
        return check;
    }

    // xem danh sách sinh viên
    public void displayStudent() {
        System.out.println("Danh sách sinh viên !!!");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("STT " + (i + 1) + " " + studentList.get(i));
        }
    }

    // thêm mới
    public void addStudent(Student student) {
        if (checkId(student)) {
            System.out.println("\u001B[31m" + "Mã sinh viên này đã tồn tại !!!" + "\u001B[0m");
            int index = -1;
            for (Student student1 : studentList) {
                if (student.getId().equals(student1.getId())) {
                    index = studentList.indexOf(student1);
                    break;
                }
            }
            byte confirm;
            do {
                System.out.println("\u001B[31m" + "Bạn có muốn sửa lại mã sinh viên này??? (OK [1]/ HUY[2]) !!!" + "\u001B[0m");
                confirm = sc.nextByte();
                switch (confirm) {
                    case 1:
                        studentList.set(index, student);
                        System.out.println("\u001B[31m" + "Sửa thành công !!!" + "\u001B[0m");
                        break;
                    case 2:
                        System.out.println("\u001B[31m" + "Hủy thành công !!!" + "\u001B[0m");
                        break;
                }
            } while (confirm != 1 && confirm != 2);

        } else {
            studentList.add(student);
            System.out.println("\u001B[31m" + "Thêm sinh viên thành công !!!" + "\u001B[0m");
        }
    }

    //cập nhập
    public void updateStudent(String id) {
        Check check = new Check();
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                System.out.println(studentList.get(i));
                index = i;
            }
        }
        if (index != -1) {
            int choice;
            do {
                System.out.println("""
                           0.Thoát.
                           1.Sửa mã sinh viên.
                           2.Sửa tên.
                           3.Sửa giới tính.
                           4.Sửa tuổi.
                           5.Sửa địa chỉ.
                           6.Sửa điểm.
                        """);
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập mã sinh viên:");
                        String Id = sc.nextLine();
                        while (!check.checkId(Id)) {
                            System.out.println("\u001B[31m" + "Mã sinh viên không đúng:" + "\u001B[0m");
                            Id = sc.nextLine();
                        }
                        studentList.get(index).setId(Id);
                        System.out.println("\u001B[31m" + "Cập nhập mã sinh viên thành công!!!" + "\u001B[0m");
                        break;
                    case 2:
                        System.out.println("\u001B[32m" + "Nhập họ và tên:" + "\u001B[0m");
                        String name = sc.nextLine();
                        while (!check.checkName(name)) {
                            System.out.println("\u001B[31m" + "Tên không đúng định dạng !!!" + "\u001B[0m");
                            name = sc.nextLine();
                        }
                        studentList.get(index).setName(name);
                        System.out.println("\u001B[31m" + "Cập nhập tên thành công !!!" + "\u001B[0m");
                        break;
                    case 3:
                        System.out.println("Nhập giới tính:");
                        String gender = sc.nextLine();
                        studentList.get(index).setGender(gender);
                        System.out.println("\u001B[31m" + "Cập nhập giới tính thành công !!!" + "\u001B[0m");
                        break;
                    case 4:
                        System.out.println("Nhập Tuổi:");
                        String age = sc.nextLine();
                        studentList.get(index).setAge(age);
                        System.out.println("\u001B[31m" + "Cập nhập tuổi thành công !!!" + "\u001B[0m");
                        break;

                    case 5:
                        System.out.println("Nhập địa chỉ:");
                        String address = sc.nextLine();
                        studentList.get(index).setAddress(address);
                        System.out.println("\u001B[31m" + "Cập nhập địa chỉ thành công !!!" + "\u001B[0m");
                        break;
                    case 6:
                        System.out.println("Nhập điểm:");
                        double averageScores = sc.nextDouble();
                        studentList.get(index).setAverageScores(averageScores);
                        System.out.println("\u001B[31m" + "Cập nhập điểm thành công !!!" + "\u001B[0m");
                        break;
                }
            } while (choice != 0);
        } else {
            System.out.println("\u001B[31m" + "Không tồn tại mã sinh viên này !!!" + "\u001B[0m");
        }
    }

    //xóa
    public void deleteStudent(String id) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                index = i;
            }
        }
        if (index != -1) {
            byte confirm;
            do {
                System.out.println("\u001B[31m" + "Bạn có chắc chắn muốn xóa (OK [1]/ HUY[2]) !!!" + "\u001B[0m");
                confirm = sc.nextByte();
                switch (confirm) {
                    case 1:
                        studentList.remove(studentList.get(index));
                        break;
                    case 2:
                        System.out.println("\u001B[31m" + "Hủy thành công !!!" + "\u001B[0m");
                        break;
                }
            } while (confirm != 1 && confirm != 2);
        } else {
            System.out.println("\u001B[31m" + "Không tồn tại mã sinh viên này !!!" + "\u001B[0m");
        }
    }

    //sắp xếp
    public void sort() {
        int choice;
        do {
            System.out.println("""
                       -----Sắp xếp sinh viên theo điểm trung bình------
                       0.Thoát
                       1.Sắp xếp điểm tăng dần.
                       2.Sắp xếp điểm giảm dần.
                    """);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                           return Double.compare(o1.getAverageScores(), o2.getAverageScores());
                        }
                    });
                    displayStudent();
                    break;
                case 2:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return Double.compare(o2.getAverageScores(), o1.getAverageScores());
                        }
                    });
                    displayStudent();
                    break;
            }
        }while (choice!=0);

    }
    public void readFile(String filePath) {
        String delimiter = ",";
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Chú ý: Tất cả dữ liệu sinh viên hiện có trong bộ nhớ sẽ bị xóa nếu bạn tiếp tục!");
            System.out.print("Bạn có chắc chắn muốn tiếp tục (y/n)? ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y")) {
                System.out.println("Hủy thao tác đọc file.");
                return;
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                Student student = new Student(data[0], data[1], data[2],
                        data[3], data[4], Double.parseDouble(data[5]));
                students.add(student);
            }
            System.out.println("Đã đọc danh sách sinh viên từ file CSV!");
            System.out.println("Đang cập nhật lại bộ nhớ...");
            this.studentList.clear();
            this.studentList.addAll(students);
            String outputFile = "F:\\modul2\\Exam_modul2\\student.csv";
            FileWriter writer = new FileWriter(outputFile);
            for (Student student : studentList) {
                String[] data = {
                        student.getId(), student.getName(),
                        student.getAge(), student.getGender(),
                        student.getAddress(), Double.toString(student.getAverageScores()) };
                writer.write(String.join(",", data));
                writer.write("\n");
            }
            writer.close();
            System.out.println("Đã cập nhật lại danh sách sinh viên và ghi ra file CSV!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String filePath, List<Student> studentList) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Student student : studentList) {
                String[] data = { student.getId(), student.getName(), student.getAge(), student.getGender(), student.getAddress(), Double.toString(student.getAverageScores()) };
                writer.write(String.join(",", data));
                writer.write("\n");
            }
            System.out.println("Đã ghi danh sách sinh viên vào file " + filePath + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Student> getStudentList(){
        return studentList;
    }


}