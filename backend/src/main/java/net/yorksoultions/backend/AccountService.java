package net.yorksoultions.backend;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void create(String username, String password) {
        if (username == null && password == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Optional<Account> existingAccount = accountRepository.findByUsername(username);
        if (existingAccount.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Account account = new Account(username, password);
        accountRepository.save(account);
    }

    public HashMap login(String username, String password) {
        if (username == null && password == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Optional<Account> foundAccount = accountRepository.findByUsernameAndPassword(username, password);
        if (foundAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        HashMap data = new HashMap();
        data.put("firstName", "adam");
        data.put("phoneNumber", "555-555-555");
        data.put("address", "123 main street");

        return data;
    }
}
