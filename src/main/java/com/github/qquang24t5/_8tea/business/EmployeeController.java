/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea.business;

import com.github.qquang24t5._8tea.persistence.EmployeeRepo;
import com.github.qquang24t5._8tea.transference.Employee;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author MINH TUAN
 */
public class EmployeeController {

    private final EmployeeRepo employeeRepo = new EmployeeRepo();
    private static Employee currentEmployee = null;

    public List<String> createEmployee(Employee e) {
        ArrayList<String> errors = new ArrayList<>();

        if (e.getMobile().isEmpty()) {
            errors.add("Số điện thoại không được để trống");
        } else if (!e.getMobile().matches("[0-9]{10}")) {
            errors.add("Số điện thoại không đúng định dạng (10 chữ số)");
        }

        Pattern containsUppercaseLetter = Pattern.compile("^.*[A-Z]+.*$");
        Pattern containsLowercaseLetter = Pattern.compile("^.*[a-z]+.*$");
        Pattern containsDigit = Pattern.compile("^.*[0-9]+.*$");
        Pattern containsSymbol = Pattern.compile("^.*[ -/:-@\\[-`{-~].*$"); // Các ký tự đặc biệt

        if (e.getPassword().length() < 8)
            errors.add("Mật khẩu quá ngắn (ít nhất 8 ký tự)");
        if (!e.getPassword().matches(containsUppercaseLetter.pattern()))
            errors.add("Mật khẩu phải chứa ít nhất 1 ký tự hoa");
        if (!e.getPassword().matches(containsLowercaseLetter.pattern()))
            errors.add("Mật khẩu phải chứa ít nhất 1 ký tự thường");
        if (!e.getPassword().matches(containsDigit.pattern()))
            errors.add("Mật khẩu phải chứa ít nhất 1 chữ số");
        if (!e.getPassword().matches(containsSymbol.pattern()))
            errors.add("Mật khẩu phải chứa ít nhất 1 ký tự đặc biệt");

        if (Period.between(LocalDate.now(), e.getDateOfBirth()).getYears() < 16)
            errors.add("Nhân viên phải trên 16 tuổi");


        if (errors.isEmpty()) {
            e.setPasswordHash(hash(e.getPassword()));
            employeeRepo.create(e);
        }

        return errors;
    }

    public List<String> logIn(Employee e) {
        List<String> errors = new ArrayList<>();
        Employee savedEmployee = null;

        if (e.getMobile().isEmpty())
            errors.add("Số điện thoại không được trống");
        if (e.getPassword().isEmpty())
            errors.add("Mật khẩu không được trống");

        if (errors.isEmpty()) {

            savedEmployee = employeeRepo.findByPhoneNumber(e.getMobile());

            if (savedEmployee == null || savedEmployee.getPasswordHash().equals(hash(e.getPassword())))
                errors.add("Số điện thoại hoặc mật khẩu không hợp lệ");
        }

        if (errors.isEmpty()) {
            currentEmployee = savedEmployee;
        }
            
        return errors;
    }

    public static Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public static String hash(String raw) {

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {}

        Objects.requireNonNull(md).update(raw.getBytes());
        byte[] digest = md.digest();
        return new String(digest);

    }
}
