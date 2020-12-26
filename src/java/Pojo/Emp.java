/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Dilip J Sarvaiya
 */
public class Emp {  
private int id,age;  
private String email,pass,conf_pass,branch,msg,gender,hobby ; 

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getConf_pass() {
        return conf_pass;
    }

    public String getBranch() {
        return branch;
    }

    public String getMsg() {
        return msg;
    }

    public String getGender() {
        return gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setConf_pass(String conf_pass) {
        this.conf_pass = conf_pass;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
  
}