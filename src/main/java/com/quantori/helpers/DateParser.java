package com.quantori.helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {

    public String getDate(String requirements) {

        boolean sum = requirements.contains("+");

        int offset = parseNumber(requirements);

        UnitsOfTime unit = parseUnitOfTime(requirements);

        return calculateDate(sum, offset, unit);
    }

    private int parseNumber(String req) {
        Pattern digitRegex = Pattern.compile("\\d");
        Matcher matcher = digitRegex.matcher(req);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        return Integer.parseInt(integerList.get(0));
    }

    private UnitsOfTime parseUnitOfTime(String req) {
        Pattern digitRegex = Pattern.compile("[a-zA-Z]*$");
        Matcher matcher = digitRegex.matcher(req);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        return UnitsOfTime.valueOf(integerList.get(0));
    }

    private String calculateDate(boolean sum, int offset, UnitsOfTime unit) {

        LocalDateTime currentDate = LocalDateTime.now();

        String datePattern = "dd/MM/yyyy";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);

        LocalDate reqDate;
        switch (unit) {
            case day:
            case days:
                if (sum) currentDate = currentDate.plusDays(offset);
                else currentDate = currentDate.minusDays(offset);
                break;
            case month:
            case months:
                if (sum) currentDate = currentDate.plusMonths(offset);
                else currentDate = currentDate.minusMonths(offset);
                break;
            case year:
            case years:
                if (sum) currentDate = currentDate.plusYears(offset);
                else currentDate = currentDate.minusYears(offset);
                break;
        }
        return dateTimeFormatter.format(currentDate);
    }

    enum UnitsOfTime {
        day, days,
        month, months,
        year, years
    }
}
