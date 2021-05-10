package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
@CrossOrigin(origins ="http://localhost:4200/",maxAge=3600)
@RestController
@RequestMapping("/api/accounts")
@ComponentScan("com.example")
public class AccountController {
@Autowired
private AccountService accountService;

// crear usuario
@PostMapping
public ResponseEntity<?> create(@RequestBody Account account) {
return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(account));
}

// Leer usuario

@GetMapping("/{id}")
public ResponseEntity<?> read(@PathVariable(value = "id") Long accountId) {
Optional<Account> oAccount = accountService.findById(accountId);
if (!oAccount.isPresent()) {
return ResponseEntity.notFound().build();
}
return ResponseEntity.ok(oAccount);
}

// actualizar account
@PutMapping("/{id}")
public ResponseEntity<?> update(@RequestBody Account accountDetails, @PathVariable(value = "id") Long accountId) {
Optional<Account> account = accountService.findById(accountId);
if (!account.isPresent()) {
return ResponseEntity.notFound().build();
}
// BeanUtils.copyProperties(accountDetails, account.get());
account.get().setSaldo(accountDetails.getSaldo());
account.get().setUser(accountDetails.getUser());
return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(account.get()));
}

// Borrar usuario
@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value = "id") Long accountId) {
if (!accountService.findById(accountId).isPresent()) {
return ResponseEntity.notFound().build();
}
accountService.deleteById(accountId);
return ResponseEntity.ok().build();
}

// Leer todos los usuarios
@GetMapping
public List<Account> readAll() {
List<Account> accounts = StreamSupport.stream(accountService.findAll().spliterator(), false)
.collect(Collectors.toList());
return accounts;
}
}