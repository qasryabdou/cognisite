package com.cognicap.site.web.controllers.admin;

public class AdminForm {

    private String exceptionName;
    private String[] exceptionsList = new String[] { "java.lang.Exception", "java.lang.RuntimeException",
            "org.hibernate.HibernateException", "org.hibernate.ObjectNotFoundException",
            "org.springframework.dao.ConcurrencyFailureException",
            "org.springframework.dao.DataAccessResourceFailureException",
            "org.springframework.dao.DataRetrievalFailureException",
            "org.springframework.dao.DeadlockLoserDataAccessException",
            "org.springframework.dao.PermissionDeniedDataAccessException" };

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public String[] getExceptionsList() {
        return exceptionsList;
    }
}