package com.codegym.receipt.service.receipt;

import com.codegym.receipt.model.Receipt;
import com.codegym.receipt.repository.receipt.IReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
public class ReceiptService implements IReceiptService {

    @Autowired
    private IReceiptRepository receiptRepository;
    @Override
    public List<Receipt> findAll() {
        return  receiptRepository.findAll();
    }

    @Override
    public Receipt findById(Long id) {
        return receiptRepository.findById(id);
    }

    @Override
    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    public void remove(Long id) {
        receiptRepository.remove(id);
    }
}