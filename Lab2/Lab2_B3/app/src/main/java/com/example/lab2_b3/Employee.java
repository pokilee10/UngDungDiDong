package com.example.lab2_b3;

public abstract class Employee {
    private String Id;
    private String Name;
    public Employee(String id, String name) {
        Id = id;
        Name = name;
    }
    public Employee() {
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public abstract double tinhLuong();
    public String toString() {
        return Id + " - " + Name ;
    }
}
class Parttime extends Employee {
    public Parttime(String id, String name, int type) {
        super(id, name);
    }
    public Parttime() {
    }
    @Override
    public double tinhLuong() {return 150;};
    @Override
    public String toString() {return super.toString() + " -->PartTime = 150.0";}
}
class Fulltime extends Employee {
    public Fulltime(String id, String name, int type) {
        super(id, name);
    }
    public Fulltime() {
        super();
    }
    @Override
    public double tinhLuong() {
        return 500;
    }
    @Override
    public String toString() {
        return super.toString()+ " -->FullTime = 500.0";
    }
}
