package com.example.Service.User;

import com.example.Entity.*;
import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll() {
        Query query = em.createQuery("SELECT u from User u");
        List<User> userList = query.getResultList();
        return userList;
    }

    public List<User> getByNameSurname(String firstname, String lastname) {
        String jpql = "SELECT u from User u where 1=1";

        if (firstname != null && !firstname.trim().isEmpty())
            jpql += " and u.firstname=:firstname";
        if (lastname != null && !lastname.trim().isEmpty())
            jpql += " and u.lastname=:lastname";

        Query query = em.createQuery(jpql, User.class);

        if (firstname != null && !firstname.trim().isEmpty())
            query.setParameter("firstname", firstname);
        if (lastname != null && !lastname.trim().isEmpty())
            query.setParameter("lastname", lastname);
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    public User getbyId(int UserId) {
        User u = em.find(User.class, UserId);
        return u;
    }

    //    @Override
//    public User getByEmail(String email) {
//        EntityManager em = em();
//        Query query  = em.createQuery("SELECT u from User u where u.email=:email");
//        query.setParameter("email",email);
//        List<User> user =query.getResultList();
//        em.close();
//        if (user.size()==1)
//            return user.get(0);
//        return null;
//    }
    @Override
    public User getByEmail(String email) {
        Query query = em.createNamedQuery("User.findByEmail");
        query.setParameter("email", email);
        List<User> user = query.getResultList();
        if (user.size() == 1)
            return user.get(0);
        return null;
    }

    @Override
    public List<UserSkill> getAllSkillById(int userId) {
        Query query = em.createQuery("SELECT us from UserSkill us WHERE us.user.id=:userId");
        query.setParameter("userId", userId);
        List<UserSkill> userSkills = null;
        userSkills = query.getResultList();
        return userSkills;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryById(int userId) {
        Query query = em.createQuery("SELECT eh from EmploymentHistory eh WHERE eh.user.id=:userId");
        query.setParameter("userId", userId);
        List<EmploymentHistory> employmentHistories = query.getResultList();
        return employmentHistories;
    }


    @Override
    public boolean addUser(User user) {
        BCrypt.Hasher crypt = BCrypt.withDefaults();
        user.setPassword(crypt.hashToString(4, user.getPassword().toCharArray()));
        em.persist(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        em.merge(user);
        return true;
    }

    @Override
    public boolean deleteUser(int UserId) {
        User user = em.find(User.class, UserId);
        em.remove(user);
        return true;
    }
}
