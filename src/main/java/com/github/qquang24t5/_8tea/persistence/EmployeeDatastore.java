package com.github.qquang24t5._8tea.persistence;

import com.github.qquang24t5._8tea.transference.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class EmployeeDatastore {

    private static EmployeeDatastore instance;
    private Database database;

    private EmployeeDatastore() {
        database = Database.getInstance();
    }

    public static EmployeeDatastore getInstance() {
        if (instance == null)
            instance = new EmployeeDatastore();
        return instance;
    }

    public static void autofill(Employee e) {
        throw new UnsupportedOperationException();
    }

    public void create(Employee e) {
        Session session = database.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(e);
        transaction.commit();
        session.close();
    }

    public Employee findByPhoneNumber(String mobile) {
        Session session = database.openSession();
        Query query = session.createQuery("FROM Employee where mobile = :mobile");
        query.setParameter("mobile", mobile);

        List<Employee> employeeList = query.getResultList();

        if (employeeList.isEmpty()) {
            return null;
        } else {
            return employeeList.get(0);
        }
    }
}
