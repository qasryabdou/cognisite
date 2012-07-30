package com.cognicap.site.web.controllers.login;

public class LoginForm {
    private String j_username;
    private String j_password;
    private boolean _spring_security_remember_me;

    public void setJ_username(String j_username) {
        this.j_username = j_username;
    }

    public String getJ_username() {
        return j_username;
    }

    public void setJ_password(String j_password) {
        this.j_password = j_password;
    }

    public String getJ_password() {
        return j_password;
    }

    public void set_spring_security_remember_me(boolean _spring_security_remember_me) {
        this._spring_security_remember_me = _spring_security_remember_me;
    }

    public boolean get_spring_security_remember_me() {
        return _spring_security_remember_me;
    }
}