package com.example.demo.persist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persist.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
