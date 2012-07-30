package com.cognicap.site.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Service;

/**
 * ResourcesUtil allows you to retrieve localized resources for the locale present in the current thread of execution.
 * It can be used from both Spring beans (simple dependency injection) and from non spring beans. In the later case,
 * you obtain the reference thanks to the static method ResourcesUtil.getInstance()
 */
@Service
@Lazy(false)
public class ResourcesUtil {
    private static final Logger log = Logger.getLogger(ResourcesUtil.class);
    public static final String DATE_FORMAT_KEY = "dateformat_default";

    /**
     * Default date pattern used in @DateTimeFormat annotation.
     */
    public final static String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    private static ResourcesUtil instance;
    private static MessageSource messageSource;

    private Map<Locale, ResourceBundle> cache = new HashMap<Locale, ResourceBundle>();

    @Autowired
    public ResourcesUtil(MessageSource ms) {
        messageSource = ms;
        instance = this;
    }

    /**
     * Call it from non spring aware code to obtain a reference to the ResourcesUtil singleton instance.
     */
    public static ResourcesUtil getInstance() {
        return instance;
    }

    /**
     * Return the MessageSource that backs this ResourcesUtil.
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * Return the underlying spring MessageSource as a ResourceBundle.
     */
    public ResourceBundle getAsResourceBundle() {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle rb = cache.get(locale);

        if (rb == null) {
            rb = new MessageSourceResourceBundle(messageSource, locale);
            cache.put(locale, rb);
        }

        return rb;
    }

    /**
     * Return the property value for the contextual locale.
     * If no value is found, the passed key is returned.
     */
    public String getProperty(String key) {
        return getProperty(key, null);
    }

    /**
     * Return the property value for the contextual locale.
     * If no value is found, the passed key is returned.
     */
    public String getProperty(String key, Object[] args) {
        if (key == null) {
            return "";
        }

        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }

    /**
     * Return the date as a localized string using the contextual locale.
     */
    public String getFormattedDate(Date date) {
        if (date == null) {
            return "";
        }

        String format = getProperty(DATE_FORMAT_KEY);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, LocaleContextHolder.getLocale());
        return dateFormat.format(date);
    }

    /**
     * Return the local date as a localized string using the contextual locale.
     */
    public String getFormattedDate(LocalDate localDate) {
        if (localDate == null) {
            return "";
        }

        String format = getProperty(DATE_FORMAT_KEY);
        return localDate.toString(format, LocaleContextHolder.getLocale());
    }

    /**
     * Return the local date time as a localized string using the contextual locale.
     */
    public String getFormattedDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return "";
        }

        String format = getProperty(DATE_FORMAT_KEY);
        return localDateTime.toString(format, LocaleContextHolder.getLocale());
    }

    /**
     * Some facility such as Spring resources loader uses as default the file encoding used by the OS.
     * To simplify the configuration you can enforce the default file encoding to UTF-8.
     */
    public void forceFileEncodingToUTF8() {
        if (!"UTF-8".equals(System.getProperty("file.encoding"))) {
            try {
                log.warn("Forcing file.encoding system property to UTF-8 instead of "
                        + System.getProperty("file.encoding"));
                System.setProperty("file.encoding", "UTF-8");
            } catch (Exception e) {
                log.warn("Could not set file.encoding programmatically to UTF-8, please configure the JVM manually", e);
            }
        }
    }
}