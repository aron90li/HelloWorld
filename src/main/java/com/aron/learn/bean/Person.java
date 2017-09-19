package com.aron.learn.bean;

import java.util.List;

/**
 * Created by Aron on 2017/7/27.
 */
public class Person {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    private List<String> names;
    private int age;

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    private List<String> alias;

}
