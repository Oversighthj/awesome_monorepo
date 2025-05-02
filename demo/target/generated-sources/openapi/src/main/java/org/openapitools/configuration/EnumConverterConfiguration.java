package org.openapitools.configuration;

import com.example.demo.model.BookingStatus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.bookingStatusConverter")
    Converter<String, BookingStatus> bookingStatusConverter() {
        return new Converter<String, BookingStatus>() {
            @Override
            public BookingStatus convert(String source) {
                return BookingStatus.fromValue(source);
            }
        };
    }

}
