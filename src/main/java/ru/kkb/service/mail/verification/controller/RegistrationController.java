package ru.kkb.service.mail.verification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kkb.service.mail.verification.domain.User;
import ru.kkb.service.mail.verification.service.UserSevice;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserSevice userSevice;

    @PostMapping("/registration")
    public ResponseEntity<String>  addUser(User user) {
        userSevice.addUser(user);
        return ResponseEntity.ok("registration ok") ;
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<String> activate(@PathVariable String code) {
        userSevice.activateUser(code);
        return ResponseEntity.ok("activate");
    }
}
