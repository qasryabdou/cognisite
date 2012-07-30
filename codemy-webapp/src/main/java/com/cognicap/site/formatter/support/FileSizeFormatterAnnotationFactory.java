package com.cognicap.site.formatter.support;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.util.NumberUtils.parseNumber;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Locale;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import com.cognicap.site.formatter.FileSizeFormatter;

/**
 * Use the {@link AnnotationFormatterFactory} to build a generic {@link Formatter} for all properties that have the {@link FileSizeFormatter} annotation
 *
 * @see FileSizeFormatter
 * @see AnnotationFormatterFactory
 * @see http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/validation.html#format-CustomFormatAnnotations
 */
@Component
public class FileSizeFormatterAnnotationFactory implements AnnotationFormatterFactory<FileSizeFormatter> {
    private static final Pattern pattern = Pattern
            .compile("^\\p{Space}*(\\p{Digit}*)\\p{Space}*(\\p{Alpha}*)\\p{Space}*$");

    @Override
    @SuppressWarnings("unchecked")
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<Class<?>>(newArrayList(Short.class, Integer.class, Long.class, Float.class, Double.class,
                BigDecimal.class, BigInteger.class));
    }

    @Override
    public Parser<?> getParser(FileSizeFormatter annotation, Class<?> fieldType) {
        return new FileSizeFormatterImpl(fieldType);
    }

    @Override
    public Printer<?> getPrinter(FileSizeFormatter annotation, Class<?> fieldType) {
        return new FileSizeFormatterImpl(fieldType);
    }

    public class FileSizeFormatterImpl implements Formatter<Number> {
        Class<? extends Number> fieldType;

        @SuppressWarnings("unchecked")
        public FileSizeFormatterImpl(Class<?> fieldType) {
            this.fieldType = (Class<? extends Number>) fieldType;
        }

        @Override
        public String print(Number object, Locale locale) {
            return FileUtils.byteCountToDisplaySize(new Long("" + object));
        }

        @Override
        public Number parse(String text, Locale locale) throws ParseException {
            if (text == null || text.trim().isEmpty()) {
                return null;
            }

            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String numericValue = matcher.group(1);
                String type = matcher.group(2);
                if (fieldType == Short.class) {
                    return (Short) parseNumber(numericValue, fieldType) * getMultiple(type);
                } else if (fieldType == Short.class) {
                    return (Short) parseNumber(numericValue, fieldType) * getMultiple(type);
                } else if (fieldType == Integer.class) {
                    return (Integer) parseNumber(numericValue, fieldType) * getMultiple(type);
                } else if (fieldType == Long.class) {
                    return (Long) parseNumber(numericValue, fieldType) * getMultiple(type);
                } else if (fieldType == Float.class) {
                    return (Float) parseNumber(numericValue, fieldType) * getMultiple(type);
                } else if (fieldType == Double.class) {
                    return (Double) parseNumber(numericValue, fieldType) * getMultiple(type);
                } else if (fieldType == BigDecimal.class) {
                    return ((BigDecimal) parseNumber(numericValue, fieldType)).multiply(BigDecimal
                            .valueOf(getMultiple(type)));
                } else if (fieldType == BigInteger.class) {
                    return ((BigInteger) parseNumber(numericValue, fieldType)).multiply(BigInteger
                            .valueOf(getMultiple(type)));
                } else {
                    throw new IllegalStateException(fieldType + " is not supported");
                }
            }
            throw new ParseException("", 0);
        }

        private long getMultiple(String type) throws ParseException {
            type = type.toLowerCase();
            if ("gb".equals(type)) {
                return FileUtils.ONE_GB;
            } else if ("mb".equals(type)) {
                return FileUtils.ONE_MB;
            } else if ("kb".equals(type)) {
                return FileUtils.ONE_KB;
            } else if ("bytes".equals(type) || "byte".equals(type) || "b".equals(type)) {
                return 1;
            } else if ("".equals(type)) {
                return 1;
            } else {
                throw new ParseException(type + " is unknown", 0);
            }
        }
    }
}