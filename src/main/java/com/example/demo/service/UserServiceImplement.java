package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.interfaces.UserInterface;

@Service
public class UserServiceImplement implements UserService {

	@Autowired
	private UserInterface userInterface;

	@Override
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		return userInterface.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		return userInterface.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return userInterface.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userInterface.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userInterface.deleteById(id);
	}

}
