package model;

public class Student {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String address;
    private double averageScores;

    public Student() {
    }

    public Student(String id, String name, String age, String gender, String address, double averageScores) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageScores = averageScores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageScores() {
        return averageScores;
    }

    public void setAverageScores(double averageScores) {
        this.averageScores = averageScores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Mã sinh viên: " + id +
                " Họ và tên: " + name +
                " Tuổi: " + age +
                ", Giới tính: " + gender +
                ", Địa chỉ: " + address +
                ", Điểm trung bình: " + averageScores +
                '}';
    }
}
