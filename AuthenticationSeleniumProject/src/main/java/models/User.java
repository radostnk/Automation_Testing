package models;

import lombok.Data;

@Data
public class User {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String passwordConfirm;
    private Boolean shouldSubscribe;
    private Boolean agreedPrivacyPolicy;

}
