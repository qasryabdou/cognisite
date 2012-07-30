package com.cognicap.site.web.util;

import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

/**
 * The purpose of this utility is to throw exceptions in order to check that proper {@link HandlerExceptionResolver} are configured.
 */
public class ExceptionUtil {
    private static final Logger log = Logger.getLogger(ExceptionUtil.class);

    /**
     * Convert the passed exception name into the corresponding exception instance and throw it.
     */
    @SuppressWarnings("unchecked")
    public void throwException(String exceptionName) throws Exception {

        Class<Exception> exceptionClass = (Class<Exception>) Class.forName(exceptionName);
        Constructor<Exception> exceptionConstructor = null;

        try {
            exceptionConstructor = exceptionClass.getConstructor(String.class);
        } catch (Exception e) {
            // ignore
        }

        if (exceptionConstructor != null) {
            throw exceptionConstructor.newInstance(exceptionArg);
        }

        try {
            exceptionConstructor = exceptionClass.getConstructor(String.class, String.class);
        } catch (Exception e) {
            // ignore
        }

        if (exceptionConstructor != null) {
            throw exceptionConstructor.newInstance(exceptionArg, exceptionArg);
        }

        try {
            exceptionConstructor = exceptionClass.getConstructor(String.class, Throwable.class);
        } catch (Exception e) {
            // ignore
        }

        if (exceptionConstructor != null) {
            throw exceptionConstructor.newInstance(exceptionArg, new Exception());
        }

        log.warn("Could not instanciate the passed exception: " + exceptionName);
    }

    private String exceptionArg = "Sample exception thrown to check exception to view mapping";

    public void setExceptionArg(String exceptionArg) {
        this.exceptionArg = exceptionArg;
    }
}
