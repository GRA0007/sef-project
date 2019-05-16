package model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SimpleMailAuthenticator extends Authenticator {
    String userName;
    String password;
    PasswordAuthentication authentication;

    public SimpleMailAuthenticator(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
        this.authentication = new PasswordAuthentication(userName, password);
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return authentication;
    }
}
