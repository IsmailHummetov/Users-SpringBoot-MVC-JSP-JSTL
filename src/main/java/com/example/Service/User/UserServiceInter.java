package com.example.Service.User;


import com.example.Entity.EmploymentHistory;
import com.example.Entity.User;
import com.example.Entity.UserSkill;

import java.util.List;

public interface UserServiceInter {

    List<User> getAll();

    List<User> getByNameSurname(String firstname, String lastname);

    User getbyId(int UserId);

    User getByEmail(String email);

    List<UserSkill> getAllSkillById(int userId);

    List<EmploymentHistory> getAllEmploymentHistoryById(int userId);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int UserId);
}
