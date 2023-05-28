/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The {@code CommonUtil} enum provides common utility methods for date operations.
 * It includes methods for converting dates to strings and strings to dates using a specific date format.
 *
 * <p>The enum follows the singleton pattern to ensure a single instance of {@code CommonUtil} is available.</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * ZonedDateTime date = ZonedDateTime.now();
 *
 * // Convert date to string
 * String dateString = CommonUtil.INSTANCE.getDateAsString(date);
 * System.out.println("Date as String: " + dateString);
 *
 * // Convert string to date
 * ZonedDateTime parsedDate = CommonUtil.INSTANCE.getDateFromString(dateString);
 * System.out.println("Parsed Date: " + parsedDate);
 * }</pre>
 *
 * <p>This enum uses the {@code ZonedDateTime} class and {@code DateTimeFormatter} for date manipulation and formatting.</p>
 *
 * @since 1.0
 * @see ZonedDateTime
 * @see DateTimeFormatter
 * @author Abhideep Chakravarty
 */
public enum CommonUtil {

    INSTANCE;

    

    /**
     * Converts the given {@code ZonedDateTime} object to a string representation using the specified date format.
     *
     * @param date the {@code ZonedDateTime} object to convert
     * @return the string representation of the date
     */
    public String getDateAsString(ZonedDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(date);
    }

    /**
     * Converts the given string representation of a date to a {@code ZonedDateTime} object using the 
     * specified date format.
     *
     * @param dateString the string representation of the date
     * @return the parsed {@code ZonedDateTime} object
     */
    public ZonedDateTime getDateFromString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return ZonedDateTime.parse(dateString, formatter);
    }
    
    
}
