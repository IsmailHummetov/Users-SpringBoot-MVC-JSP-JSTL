package com.example.Dao.Impl;

import com.example.Dao.Inter.*;
import com.example.Dao.Inter.EmpHistoryDaoInter;
import com.example.Entity.EmploymentHistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpHistoryDaoImpl  implements EmpHistoryDaoInter {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<EmploymentHistory> getAllEmploymentHistory() {
        Query query = em.createQuery("SELECT eh from EmploymentHistory eh");
        List<EmploymentHistory> employmentHistories = query.getResultList();
        return employmentHistories;
    }

    @Override
    public EmploymentHistory getById(int id) {
        EmploymentHistory employmentHistory = em.find(EmploymentHistory.class,id);
        return employmentHistory;
    }

    @Override
    public boolean addEmpHistory(EmploymentHistory emp) {
        em.persist(emp);
        return true;
    }

    @Override
    public boolean updateEmpHistory(EmploymentHistory emp) {
        em.merge(emp);
        return true;
    }

    @Override
    public boolean deleteEmpHistory(int id) {
        EmploymentHistory employmentHistory = em.find(EmploymentHistory.class,id);
        em.remove(employmentHistory);
        return true;
    }
}
