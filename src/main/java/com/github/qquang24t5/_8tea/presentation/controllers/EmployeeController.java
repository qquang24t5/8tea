/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea.presentation.controllers;

import com.github.qquang24t5._8tea.persistence.EmployeeDatastore;
import com.github.qquang24t5._8tea.transference.Employee;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MINH TUAN
 */
public class EmployeeController {

    private final EmployeeDatastore employeeDatastore = new EmployeeDatastore();

    public EmployeeController() {
    }

    public List<String> createEmployee(Employee e) {
        ArrayList<String> errors = new ArrayList<>();
        String name = e.getName();
        String gender = String.valueOf(e.getGender());
        LocalDate dob = e.getDateOfBirth();
        String mobile = e.getMobile();
        String pass = e.getPassword();

//        if (name.isEmpty()) {
//            error.add("Ten khong duoc de trong");
//        }
//        if (name.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ"
//                + "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ"
//                + "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$") == false) {
//            error.add("Ten khong duoc chua ky tu dac biet");
//        }
        if (mobile.isEmpty()) {
            errors.add("SDT khong duoc de trong");
        } else if (!mobile.matches("0[0-9]{9}")) {
            errors.add("SDT ko dung dinh dang");
        }

        // TODO: Check password
        if(!pass.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\"")){
            errors.add("Mat khau it nhat 8 ky tu, bao gom chu thuong,chu hoa va ky tu dac biet");
        }
        // TODO: Check date of birth
        LocalDate curr = LocalDate.now();
        if(curr.getYear()-dob.getYear()<16)
        {
            errors.add("Nhan vien can du 16 tuoi tro len");
        }
        if (errors.isEmpty()) {

            try {
                // TODO: Băm (hash) mật khẩu, lưu vào Employee.passwordHash
                e.setPassword(hash(e.getPassword()));
                employeeDatastore.create(e);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return errors;
    }

    public static String hash(String raw) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(raw.getBytes());
        byte[] digest = md.digest();
        return new String(digest);

    }
    public List<String> checkLogin(Employee e)
    {
        ArrayList<String> errors = new ArrayList<>();
        if(e.getMobile().isEmpty())
        {
            errors.add("Hay nhap so dien thoai");
        }
        if(e.getPassword().isEmpty())
        {
            errors.add("Hay nhap mat khau");
        }
        Employee ep = employeeDatastore.findByPhoneNumber(e.getMobile());
        try {
            if(ep.getMobile().equals(e.getMobile())&&ep.getPassword().equals(hash(e.getPassword())))
            {
                //setWindow........
            }
            else
            {
                errors.add("Sai tai khoan hoac mat khau");
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return errors;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        System.out.println(hash("StrongPassword!123"));
        
        
//        Employee e = Employee.builder().build();
//        e.setName("@@Tuan");
//        e.setMobile("0902778d11");
//        e.setPassword("");
//
//        List<String> er = new EmployeeController().createEmployee(e);
//        er.forEach((ar) -> {
//            System.out.println(ar);
//        });
    }
}
