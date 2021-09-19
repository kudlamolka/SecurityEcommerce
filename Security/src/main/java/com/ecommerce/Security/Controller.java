package com.ecommerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@RestController
@Component
public class Controller{

    byte[] iv;
    SecretKey key;

    Controller() throws NoSuchAlgorithmException {
        iv = AES.getIV();
        key = AES.getAESKey();
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @PostMapping("/encode")
    public String encode(@RequestBody String password) throws Exception {
        return AES.encrypt(password.getBytes(StandardCharsets.UTF_8),key,iv).toString();
    }

    @PostMapping("/decode")
    public String decode(@RequestBody Holder data) throws Exception {
        byte[] enc = data.hash.getBytes(StandardCharsets.UTF_8);
        return AES.decrypt(enc,key,iv);
    }
}
