/*
 *
 * Axis Saksham Java Client SDK
 * This is the java SDK to consume Axis Sakham APIs. This reduces the boiler plate coding required to make API calls
 * and hence speeds up the developers to integrate with Saksham API in faster and productive way.
 *
 * 2023 Eclatian Technologies Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
