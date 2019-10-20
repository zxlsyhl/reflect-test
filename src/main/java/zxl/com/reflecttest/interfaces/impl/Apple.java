package zxl.com.reflecttest.interfaces.impl;

import zxl.com.reflecttest.interfaces.Fruit;

public class Apple implements Fruit {
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
