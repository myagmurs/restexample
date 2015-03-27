package com.t2.hackathon.service;

import com.t2.hackathon.model.Currency;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * User: sonic
 * Date: 25/03/15
 */
@Service
public class HelloWorldService {

    private Random random = new Random();

    public List<Currency> getRandomCurrencies() {
        List<Currency> currencies = new ArrayList<Currency>();
        for (int i = 0; i < 100; i++) {
            Currency currency = new Currency();
            currency.setDate(getRandomDate());
            currency.setName(getRandomString());
            currency.setRate(random.nextDouble());
            currency.setSymbol(getRandomString());
            currency.setId(i);

            currencies.add(currency);
        }

        return currencies;
    }

    private String getRandomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    private Date getRandomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.getTime();
    }

    private int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
