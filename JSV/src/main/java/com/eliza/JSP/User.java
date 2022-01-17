package com.eliza.JSP;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 11/2/21
 * @Software: IntelliJ IDEA
 */
public class User {
    public int id;
    public String name;
    public String gender;


    public User(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }


    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}


