package com.example.customersvl;

public class Customer {

    int id;
    String name;
    String address;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Customer(int id, String name,String email, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email=email;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + address +
                '}';
    }

    public Customer() {
    }
}
