package com.baebin.SchoolMeal.entity;

import java.util.ArrayList;
import java.util.List;

public class Food {
    // 기장밥<br/>돈육김치국5.6.9.10.13.18.<br/>도라지진미채무침p85.6.13.17.18.<br/>크리미양파닭p1.2.5.6.13.15.<br/>총각김치9.13.
    static public List<String> getFoods(Object object) {
        String food = object.toString();

        List<String> foods = new ArrayList<>();

        for (String value : food.split("<br/>")) {
            foods.add(value);
        }
        return foods;
    }
}
