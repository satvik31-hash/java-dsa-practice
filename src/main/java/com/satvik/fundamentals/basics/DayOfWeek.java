package com.satvik.fundamentals.basics;

import java.util.Set;

/** Validates a day name, as a worked example of switch expressions over strings. */
public final class DayOfWeek {

    private static final Set<String> WEEKEND = Set.of("SATURDAY", "SUNDAY");

    private DayOfWeek() {
    }

    /**
     * @return the canonical capitalised day name
     * @throws IllegalArgumentException if the input is not a day of the week
     */
    public static String normalise(String day) {
        if (day == null) {
            throw new IllegalArgumentException("Day must not be null");
        }
        return switch (day.trim().toUpperCase()) {
            case "MONDAY" -> "Monday";
            case "TUESDAY" -> "Tuesday";
            case "WEDNESDAY" -> "Wednesday";
            case "THURSDAY" -> "Thursday";
            case "FRIDAY" -> "Friday";
            case "SATURDAY" -> "Saturday";
            case "SUNDAY" -> "Sunday";
            default -> throw new IllegalArgumentException("Not a day of the week: " + day);
        };
    }

    public static boolean isWeekend(String day) {
        return WEEKEND.contains(normalise(day).toUpperCase());
    }
}
