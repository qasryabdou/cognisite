package com.cognicap.site.formatter.support;

import org.springframework.format.Formatter;

/**
 * This is a marker interface so the {@link CustomFormattingConversionServiceFactory} so your {@link Formatter} gather all the implementation using Spring.
 *
 * @see CustomFormattingConversionServiceFactory
 * @see Formatter
 */
public interface DiscoverableFormatter<T> extends Formatter<T> {
    Class<T> getTarget();
}