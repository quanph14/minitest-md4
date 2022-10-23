package com.codegym.receipt.model;

import org.springframework.web.multipart.MultipartFile;

public class ReceiptForm {
    private Long id;
    private String name;
    private String cost;
    private String note;
    private String payList;
    private MultipartFile file;

    public ReceiptForm(Long id, String name, String cost, String note, String payList, MultipartFile file) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.note = note;
        this.payList = payList;
        this.file = file;
    }

    public ReceiptForm(String name, String cost, String note, String payList, MultipartFile file) {
        this.name = name;
        this.cost = cost;
        this.note = note;
        this.payList = payList;
        this.file = file;
    }

    public ReceiptForm() {
    }

    public ReceiptForm(Long id, String name, String cost, String note, String payList) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.note = note;
        this.payList = payList;
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

    public ReceiptForm(Long id) {
        this.id = id;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}