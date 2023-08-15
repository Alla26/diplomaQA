package ru.iteco.fmhandroid.ui.utils;


public class AuthorizationData {

    public class User {
        private final String login;
        private final String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public User getValidUser() {
        return new User("login2", "password2");
    }

    public User getNotValidUserWithWrongLogin() {
        return new User("log", "password2");
    }

    public User getNotValidUserWithWrongPassword() {
        return new User("login2", "pass");
    }

    public User getNotValidUserWithSpaseLogin() {
        return new User(" login2", "password2");
    }

    public User getNotValidUserWithSpasePassword() {
        return new User("login2", " password2");
    }

    public User getNotValidUserEmptyFields() {
        return new User("", "");
    }

    public User getNotValidUserWithCapitalLetterPassword() {
        return new User("login2", "Password2");
    }

    public User getNotValidUserWithCapitalLetterLogin() {
        return new User("Login2", "password2");
    }

}
