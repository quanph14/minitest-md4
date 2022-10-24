package com.codegym.receipt.model;

import org.springframework.web.multipart.MultipartFile;

public class ReceiptForm {
    private Long id;
    private String name;
    private String price;
    private String description;
    private String payList;
    private MultipartFile file;

    public ReceiptForm(Long id, String name, String price, String description, String payList, MultipartFile file) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.payList = payList;
        this.file = file;
    }

    public ReceiptForm(String name, String price, String description, String payList, MultipartFile file) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.payList = payList;
        this.file = file;
    }

    public ReceiptForm() {
    }

    public ReceiptForm(Long id, String name, String price, String description, String payList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
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

    public String getPrice() {
        return price;
    }

    public ReceiptForm(Long id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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