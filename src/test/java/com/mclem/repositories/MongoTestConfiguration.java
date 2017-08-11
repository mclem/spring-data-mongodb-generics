package com.mclem.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoTestConfiguration {

    @Bean
    public CustomConversions customConversions() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
        converterList.add(new MongoCustomConverter.LocalDateToStringConverter());
        converterList.add(new MongoCustomConverter.StringToLocalDateConverter());
        return new CustomConversions(converterList);
    }

    @Bean
    public LoggingEventListener mappingEventsListener() {
        return new LoggingEventListener();
    }

}
