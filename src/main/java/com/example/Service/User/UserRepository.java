package com.example.Service.User;

import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
    User findByFirstname(@Param("firstname") String name);

    User findByFirstnameAndLastname(String name, String surname);

}
