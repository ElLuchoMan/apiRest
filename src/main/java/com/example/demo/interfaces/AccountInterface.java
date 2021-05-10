package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Account;

public interface  AccountInterface extends JpaRepository<Account, Long>{

}
