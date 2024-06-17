package com.example.Dao.Impl;

import com.example.Dao.Inter.*;
import com.example.Entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillDaoImpl implements SkillDaoInter {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getAll() {
        List<Skill> skill;
        Query query = em.createQuery("SELECT s from Skill s");
        skill = query.getResultList();
        return skill;
    }

    @Override
    public Skill getById(int skillId) {
        Skill skill = em.find(Skill.class,skillId);
        return skill;
    }

    @Override
    public boolean addSkill(Skill skill) {
        em.persist(skill);
        return true;
    }

    @Override
    public boolean deleteSkill(int SkillId) {
        Skill skill = em.find(Skill.class,SkillId);
        em.remove(skill);
        return true;
    }

    @Override
    public boolean update(Skill skill) {
        em.merge(skill);
        return true;
    }
}
