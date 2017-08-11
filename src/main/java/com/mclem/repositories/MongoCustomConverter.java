package com.mclem.repositories;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public final class MongoCustomConverter {

    public static final class LocalDateToStringConverter implements Converter<LocalDate, String> {

        @Override
        public String convert(LocalDate localDate) {
            return localDate.toString();
        }

    }

    public static final class StringToLocalDateConverter implements Converter<String, LocalDate> {

        @Override
        public LocalDate convert(String source) {
            return LocalDate.parse(source);
        }

    }

}
