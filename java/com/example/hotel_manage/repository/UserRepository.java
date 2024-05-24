package com.example.hotel_manage.repository;

import com.example.hotel_manage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    User getReferenceById(Class<? extends Long> aClass);
}
