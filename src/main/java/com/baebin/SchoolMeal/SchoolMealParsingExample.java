package com.baebin.SchoolMeal;

import com.baebin.SchoolMeal.url.ParsingURL;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SchoolMealParsingExample {
    public static void main(String[] args) {
        ParsingURL url = new ParsingURL(
                "202203",
                "20220321",
                "20220326");

        try {
            Map<Integer, List<String>> meal = url.getResult();

            if (meal.isEmpty()) {
                p("파싱에 실패하였습니다.");
                return;
            }

            String[] days = { "월", "화", "수", "목", "금" };

            for (int i = 0; i < 5; i++) {
                if (!meal.containsKey(i)) continue;

                List<String> foods = meal.get(i);
                p((i+1) + ". "
                        + days[i] + "요일: ");

                pFoods(foods);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void p(Object o) {
        System.out.println(o);
    }

    private static void pFoods(List<String> foods) {
        int i = 0;
        for (String food : foods) {
            System.out.printf("  - %d. %s\n", (++i), food);
        }
    }
}
