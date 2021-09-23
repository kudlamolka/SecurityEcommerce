package com.ecommerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Base64;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class Test {

    public static void main(String[] args) throws Exception {
        byte[] iv = AES.getIV();
        SecretKey key = AES.getAESKey();

        String ptext = "amal";

        byte enc[] = AES.encrypt(ptext.getBytes(StandardCharsets.UTF_8),key,iv);

        String s64 = Base64.getEncoder().encodeToString(enc);

        System.out.println(enc.toString());

        byte arr[] = Base64.getDecoder().decode(s64);

        String dec = AES.decrypt(arr,key,iv);

        System.out.println(dec);
    }
}
