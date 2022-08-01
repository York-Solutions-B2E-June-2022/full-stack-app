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
    public void create(@RequestBody Account requestBody) {
        accountService.create(requestBody.username, requestBody.password);
    }

    /*
    {
      "username": "admin",
      "password": "admin",
      "foo": "some data"
    }
 */
    @PostMapping("/login")
    public HashMap login(@RequestBody Account requestBody) {
        return accountService.login(requestBody.username, requestBody.password, requestBody.foo);
    }
}

class AccountAuthRequest {
    public String username;
    public String password;
    public String foo;
}
