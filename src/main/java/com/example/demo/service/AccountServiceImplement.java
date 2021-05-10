package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Account;
import com.example.demo.interfaces.AccountInterface;

@Service
public class AccountServiceImplement implements AccountService {

	@Autowired
	private AccountInterface accountInterface;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Account> findAll() {
		return accountInterface.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Account> findAll(Pageable pageable) {
		return accountInterface.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Account> findById(Long id) {
		return accountInterface.findById(id);
	}

	@Override
	@Transactional
	public Account save(Account account) {
		return accountInterface.save(account);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		accountInterface.deleteById(id);
	}

}
