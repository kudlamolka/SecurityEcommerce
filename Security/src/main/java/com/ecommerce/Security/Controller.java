package com.ecommerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;

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
    public String encode(@RequestBody Password password) throws Exception {
        byte res[] = AES.encrypt(password.getPassword().getBytes(StandardCharsets.UTF_8),key,iv);
        return Base64.getEncoder().encodeToString(res);
    }

    @PostMapping("/decode")
    public String decode(@RequestBody Hash hash) throws Exception {
        byte[] enc = Base64.getDecoder().decode(hash.getHash());
        return AES.decrypt(enc,key,iv);
    }
}
