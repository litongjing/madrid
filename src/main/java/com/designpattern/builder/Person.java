package com.designpattern.builder;

import com.util.SerializeUtil;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午10:20 2018/1/13
 */
public class Person implements Serializable {
    private String name;
    private String phone;
    private Integer age;
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person() {

    }

    public Person(Builder builder) {
        this.name = builder.name;
        this.phone = builder.phone;
        this.age = builder.age;
        this.sex = builder.sex;

    }

    public static class Builder {
        private String name;
        private String phone;
        private Integer age;
        private String sex;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setAge(10)
                .setName("ltj")
                .setPhone("1888888888")
                .setSex("male")
                .build();
        System.out.println(person);
    }
}
