package com.cognicap.site.formatter;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.cognicap.codemy.core.persistence.domain.Course;
import com.cognicap.codemy.core.repository.CourseRepository;
import com.cognicap.site.formatter.support.CustomFormattingConversionServiceFactory;
import com.cognicap.site.formatter.support.DiscoverableFormatter;

/**
 * {@link Formatter} for {@link Url} that is picked by automatically by {@link CustomFormattingConversionServiceFactory}
 *
 * @see Formatter
 * @see CustomFormattingConversionServiceFactory
 */
@Component
public class CourseFormatter implements DiscoverableFormatter<Course> {

	@Autowired
	CourseRepository courseRepository;

    @Override
    public Class<Course> getTarget() {
        return Course.class;
    }

    @Override
    public String print(Course course, Locale locale) {
        if (course == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // make a nice display string here...


        if (sb.length() > 0) {
            return sb.toString();
        } else {
            return course.getId().toString();
        } 
    }

    @Override
    public Course parse(String text, Locale locale) throws ParseException {
        if (isBlank(text)) {
            return new Course();
        }
        Course course = courseRepository.getCourse(new Long(text));
        return course != null ? course : new Course();
    }
}
