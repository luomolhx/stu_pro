package com.lhx.stu_pro.bean;

/**
 * @author luomo
 * @create 2022-07-16 9:34
 */
/*
 * 封装列表查询的参数
 *
 */

public class FormBean {
    private String sname;
    private String age;

    @Override
    public String toString() {
        return "FormBean{" +
                "sname='" + sname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
