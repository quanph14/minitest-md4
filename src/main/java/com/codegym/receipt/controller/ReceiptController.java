package com.codegym.receipt.controller;

import com.codegym.receipt.model.Picture;
import com.codegym.receipt.model.Receipt;
import com.codegym.receipt.model.ReceiptForm;
import com.codegym.receipt.service.receipt.IReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.multi.MultiListUI;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ReceiptController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    IReceiptService receiptService;

    @GetMapping("/create-receipt")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/receipt/create");
        modelAndView.addObject("receiptForm", new ReceiptForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveReceipt(@ModelAttribute("receiptForm") ReceiptForm receiptForm) {
        MultipartFile multipartFile = receiptForm.getFile();
        String pictureName = multipartFile.getOriginalFilename();
        ModelAndView modelAndView;
        if (Picture.checkFile(pictureName)){
            try {
                FileCopyUtils.copy(receiptForm.getFile().getBytes(), new File(fileUpload + pictureName));
            }catch (IOException ex){
                ex.printStackTrace();
            }
            Receipt receipt = new Receipt(receiptForm.getName(),receiptForm.getCost(),receiptForm.getNote(),receiptForm.getPayList(),pictureName);
            receiptService.save(receipt);
            modelAndView = new ModelAndView("/receipt/create");
            modelAndView.addObject("receiptForm", new ReceiptForm());
            modelAndView.addObject("message", "New receipt created successfully");
        }else{
            modelAndView = new ModelAndView("/receipt/create");
            modelAndView.addObject("receipt", new Receipt());
            modelAndView.addObject("message", "file upload is not a picture");
        }
        return modelAndView;
    }

    @GetMapping("/receipts")
    public ModelAndView listReceipts() {
        List<Receipt> receipts = receiptService.findAll();
        ModelAndView modelAndView = new ModelAndView("/receipt/list");
        modelAndView.addObject("receipts", receipts);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Receipt receipt = receiptService.findById(id);
        if (receipt != null) {
            ReceiptForm receiptForm = new ReceiptForm(receipt.getId(),receipt.getName(),receipt.getCost(),receipt.getNote(),receipt.getPayList());
            ModelAndView modelAndView = new ModelAndView("/receipt/edit");
            modelAndView.addObject("receiptForm", receiptForm);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-receipt")
    public ModelAndView updateReceipt(@ModelAttribute ReceiptForm receiptForm) {
        MultipartFile multipartFile = receiptForm.getFile();
        String pictureName = multipartFile.getOriginalFilename();
        ModelAndView modelAndView;
        if (Picture.checkFile(pictureName)){
            try {
                FileCopyUtils.copy(receiptForm.getFile().getBytes(), new File(fileUpload + pictureName));
            }catch (IOException ex){
                ex.printStackTrace();
            }
            Receipt receipt = new Receipt(receiptForm.getId(),receiptForm.getName(),receiptForm.getCost(),receiptForm.getNote(),receiptForm.getPayList(),pictureName);
            receiptService.save(receipt);
            modelAndView = new ModelAndView("/receipt/edit");
            modelAndView.addObject("receiptForm", new ReceiptForm());
            modelAndView.addObject("message", "New receipt created successfully");
        }else{
            modelAndView = new ModelAndView("/receipt/edit");
            modelAndView.addObject("receiptForm", new ReceiptForm());
            modelAndView.addObject("message", "file upload is not a picture");
        }
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Receipt receipt = receiptService.findById(id);
        if (receipt != null) {
            ModelAndView modelAndView = new ModelAndView("/receipt/delete");
            modelAndView.addObject("receipt", receipt);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-receipt")
    public String deleteReceipt(@ModelAttribute("receipt") Receipt receipt) {
        receiptService.remove(receipt.getId());
        return "redirect:receipts";
    }
}