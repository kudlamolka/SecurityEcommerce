package com.ecommerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

    static PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {


        String pwd = "amal";
        String p2 = "amal";
        String hash = encoder.encode(pwd);


        System.out.println(encoder.matches(p2,hash));
    }
}
