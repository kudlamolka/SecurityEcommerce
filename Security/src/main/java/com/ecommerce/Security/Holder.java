package com.ecommerce.Security;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan
public class Holder {
    public String password;
    public String hash;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
