package com.example.Service.User;

import com.example.Entity.EmploymentHistory;
import com.example.Entity.User;
import com.example.Entity.UserSkill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {
    @Autowired
    UserRepositoryCustom userDao;
    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> getByNameSurname(String firstname, String lastname) {
        return userDao.getByNameSurname(firstname, lastname);
    }

    @Override
    public User getbyId(int UserId) {
        return userDao.getbyId(UserId);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public List<UserSkill> getAllSkillById(int userId) {
        return userDao.getAllSkillById(userId);
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryById(int userId) {
        return userDao.getAllEmploymentHistoryById(userId);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int UserId) {
        return userDao.deleteUser(UserId);
    }
}
