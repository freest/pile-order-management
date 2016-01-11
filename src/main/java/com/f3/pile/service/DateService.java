package com.f3.pile.service;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateService {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    public Date parse(String dateString) {
        Date result = null;
        try {
            result = simpleDateFormat.parse(dateString);
        } finally {
            return result;
        }
    }
}
