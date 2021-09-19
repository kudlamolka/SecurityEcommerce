package com.ecommerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class Test {

    public static void main(String[] args) throws Exception {
        byte[] iv = AES.getIV();
        SecretKey key = AES.getAESKey();

        String ptext = "amal";

        byte enc[] = AES.encrypt(ptext.getBytes(StandardCharsets.UTF_8),key,iv);

        System.out.println(enc.toString());

        String dec = AES.decrypt(enc,key,iv);

        System.out.println(dec);
    }
}
