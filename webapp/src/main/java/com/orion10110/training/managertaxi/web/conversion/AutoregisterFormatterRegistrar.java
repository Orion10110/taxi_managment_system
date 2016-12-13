package com.orion10110.training.managertaxi.web.conversion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;

public class AutoregisterFormatterRegistrar implements FormatterRegistrar {

    /**
     * All {@link Converter} Beans with {@link AutoRegistered} annotation.
     * If spring does not find any matching bean, then the List is {@code null}!.
     */
    @Autowired(required = false)
    @AutoRegistered
    private List<TwoWayConverter<?, ?>> autoRegisteredConverters;


    @Override
    public void registerFormatters(final FormatterRegistry registry) {
        if (this.autoRegisteredConverters != null) {
            for (TwoWayConverter<?, ?> converter : this.autoRegisteredConverters) {
                registry.addConverter(converter);
            }
        }
    }
}