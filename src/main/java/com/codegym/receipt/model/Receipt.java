package com.codegym.receipt.model;

import javax.persistence.*;

@Entity
@Table(name = "com/codegym/receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cost;
    private String note;
    private String payList;
    private String pictureName;

    public Receipt(Long id, String name, String cost, String note, String payList, String pictureName) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.note = note;
        this.payList = payList;
        this.pictureName = pictureName;
    }

    public Receipt(String name, String cost, String note, String payList, String pictureName) {
        this.name = name;
        this.cost = cost;
        this.note = note;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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