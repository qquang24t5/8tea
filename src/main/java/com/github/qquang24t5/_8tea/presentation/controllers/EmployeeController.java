package com.github.qquang24t5._8tea.presentation.controllers;

import com.github.qquang24t5._8tea.persistence.EmployeeRepo;
import com.github.qquang24t5._8tea.transference.Employee;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController {
    private Employee currentEmployee;
    private final EmployeeRepo employeeRepo = new EmployeeRepo();

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    private static String hashPassword(String pass) throws NoSuchAlgorithmException {
        String hashedPass;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(pass.getBytes(StandardCharsets.UTF_8));
        hashedPass = new String(messageDigest.digest());
        return hashedPass;
    }

    public List<String> createEmployee(Employee employee) {
        List<String> errors = new ArrayList<>();

        LocalDate dateOfBirth = employee.getDateOfBirth();
        String phoneNumber = employee.getMobile();
        String password = employee.getPassword();

        //serializable
        if (phoneNumber.isEmpty()) {
            errors.add("SDT khong duoc de trong");
        } else if (!phoneNumber.matches("0[0-9]{9}")) {
            errors.add("SDT ko dung dinh dang");
        }

        if (password.isEmpty()) {
            errors.add("Mat khau khong duoc de trong");
        } else if (!password.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\"")) {
            errors.add("Mat khau it nhat 8 ky tu, bao gom chu thuong,chu hoa va ky tu dac biet");
        }

        LocalDate currentDate = LocalDate.now();
        if (currentDate.getYear() - dateOfBirth.getYear() < 16) {
            errors.add("Nhan vien can du 16 tuoi tro len");
        }

        //save to database
        if (errors.isEmpty()) {
            try {

                employee.setPasswordHash(hashPassword(employee.getPassword()));
                errors.add("Khong co loi");
                employeeRepo.create(employee);
                return errors;

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return errors;
    }

    public List<String> checkLogin(Employee employee) {
        List<String> errors = new ArrayList<>();

        if (employee.getMobile().isEmpty()) {
            errors.add("Nhap so dien thoai!");
        }

        if (employee.getPassword().isEmpty()) {
            errors.add("Nhap mat khau!");
        }

        Employee checkEmployee = employeeRepo.findByPhoneNumber(employee.getMobile());

        try {
            if (checkEmployee == null) {
                errors.add("So dien thoai khong ton tai");
            } else if (checkEmployee.getPasswordHash().equals(hashPassword(employee.getPassword()))) {
                setCurrentEmployee(employee);
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return errors;
    }

}
