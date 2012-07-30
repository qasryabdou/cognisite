package com.cognicap.site.converter;

import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class DateConverters {

    @Component
    public static class DateToStringConverter implements Converter<String, Date> {
        @Override
        public Date convert(String text) {
            return valueOf(text);
        }

        @Override
        public String toString() {
            return DateToStringConverter.class.getName();
        }
    }

    @Component
    public static class LocalDateToStringConverter implements Converter<String, LocalDate> {
        @Override
        public LocalDate convert(String text) {
            Date date = valueOf(text);
            return date == null ? null : new LocalDate(date.getTime());
        }

        @Override
        public String toString() {
            return LocalDateToStringConverter.class.getName();
        }
    }

    @Component
    public static class LocalDateTimeToStringConverter implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(String text) {
            Date date = valueOf(text);
            return date == null ? null : new LocalDateTime(date.getTime());
        }

        @Override
        public String toString() {
            return LocalDateTimeToStringConverter.class.getName();
        }
    }

    private static DateTimeFormatter parser1 = DateTimeFormat.forPattern("dd-MMM-yyyy");

    private static DateTimeFormatter parser2 = DateTimeFormat.forPattern("yyyy-MM-dd");

    private static Date getDate(DateTimeFormatter parser, String text) {
        try {
            return parser.parseDateTime(text).toDate();
        } catch (Exception e) {
            return null;
        }
    }

    public static Date valueOf(String text) {
        Date date = getDate(parser1, text);
        if (date != null) {
            return date;
        }
        return getDate(parser2, text);
    }
}