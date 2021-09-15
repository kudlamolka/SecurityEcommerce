package com.ecommerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class Controller {

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/encode/")
    public String encode(@RequestBody String password){
        String hash = encoder.encode(password);
        return hash;
    }

    @PostMapping("/validate/")
    public boolean validate(@RequestBody Holder data){

        return encoder.matches(data.getPassword(),data.getHash());
    }
}
