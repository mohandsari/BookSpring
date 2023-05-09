package com.cgi.livres.batch;

import com.cgi.livres.entity.Coffee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CoffeeItemProcessor implements ItemProcessor<Coffee, Coffee> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeItemProcessor.class);

    @Override
    public Coffee process(final Coffee coffee) throws Exception {
        int coffe_id = coffee.getCoffee_id();
        String brand = coffee.getBrand().toUpperCase();
        String origin = coffee.getOrigin().toUpperCase();
        String chracteristics = coffee.getCharacteristics().toUpperCase();

        Coffee transformedCoffee = new Coffee(coffe_id, brand, origin, chracteristics);
        LOGGER.info("Converting ( {} ) into ( {} )", coffee, transformedCoffee);

        return transformedCoffee;

    }

}
