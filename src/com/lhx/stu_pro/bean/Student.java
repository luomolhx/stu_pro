package com.lhx.stu_pro.bean;

/**
 * @author luomo
 * @create 2022-07-16 9:03
 *
 * 学生实体类
 *
 */
public class Student {
    private String sid;
    private String sname;
    private String gender;
    private String age;
    private String grade;
    private String address;
    private String mPhone;
    private String email;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", grade='" + grade + '\'' +
                ", address='" + address + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
