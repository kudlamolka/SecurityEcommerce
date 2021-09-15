package com.ecommerce.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();

        String pwd = "amal";
        String hash1 = encoder.encode(pwd);
        String hash2 = encoder1.encode(pwd);
        String hash3 = "$2a$10$1zvt.n2lAwQGpL8Rg1SGH.0YTkiLc9t3Nsgh.LI1.I2Ho1DFzO2k2";


        System.out.println(encoder.matches(pwd,hash1));
        System.out.println(encoder.matches("amal",hash2));
        System.out.println(encoder.matches("amal",hash3));
    }
}
