package net.yorksoultions.backend;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void create(@RequestBody AccountAuthRequest requestBody) {
        accountService.create(requestBody.username, requestBody.password);
    }

    @PostMapping("/login")
    public HashMap login(@RequestBody AccountAuthRequest requestBody) {
        return accountService.login(requestBody.username, requestBody.password);
    }
}

class AccountAuthRequest {
    public String username;
    public String password;
}
