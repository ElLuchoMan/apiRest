package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Account;

public interface AccountService {
	public Iterable<Account> findAll();

	public Page<Account> findAll(Pageable pageable);

	public Optional<Account> findById(Long id);

	public Account save(Account account);

	public void deleteById(Long id);
}
