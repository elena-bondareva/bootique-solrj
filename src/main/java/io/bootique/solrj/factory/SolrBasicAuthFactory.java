package io.bootique.solrj.factory;

import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;

@BQConfig
public class SolrBasicAuthFactory {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    @BQConfigProperty
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @BQConfigProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
