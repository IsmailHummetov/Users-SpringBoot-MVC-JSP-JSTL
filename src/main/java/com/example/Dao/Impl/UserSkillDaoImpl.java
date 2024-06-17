package com.example.Dao.Impl;

import com.example.Dao.Inter.*;
import com.example.Entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSkillDaoImpl implements UserSkillDaoInter {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserSkill> getAllUserSkill() {
        Query query = em.createQuery("SELECT us from UserSkill us");
        List<UserSkill> userSkills = query.getResultList();
        return userSkills;
    }

    @Override
    public UserSkill getById(int id) {
        UserSkill userSkill = em.find(UserSkill.class, id);
        return userSkill;
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        em.persist(us);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        em.merge(us);
        return true;
    }

    @Override
    public boolean deleteUserSkill(int id) {
        UserSkill userSkill = em.find(UserSkill.class, id);
        em.remove(userSkill);
        return true;
    }
}
