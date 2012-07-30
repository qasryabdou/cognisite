package com.cognicap.site.formatter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Example of {@link Formatter} using annotation, implementation is done in {@link FileSizeFormatAnnotationFactory}
 * @see Formatter
 * @see FileSizeFormatAnnotationFactory
 * @see CustomFormattingConversionServiceFactory
 */
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileSizeFormatter {
}