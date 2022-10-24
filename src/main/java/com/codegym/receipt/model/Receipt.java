package com.codegym.receipt.model;

import javax.persistence.*;

@Entity
@Table(name = "com/codegym/receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String description;
    private String payList;
    private String pictureName;

    public Receipt(Long id, String name, String price, String description, String payList, String pictureName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.payList = payList;
        this.pictureName = pictureName;
    }

    public Receipt(String name, String price, String description, String payList, String pictureName) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.payList = payList;
        this.pictureName = pictureName;
    }

    public Receipt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String cost) {
        this.price = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String note) {
        this.description = note;
    }

    public String getPayList() {
        return payList;
    }

    public void setPayList(String payList) {
        this.payList = payList;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
}