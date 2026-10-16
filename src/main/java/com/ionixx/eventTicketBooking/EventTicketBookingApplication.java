package com.ionixx.eventTicketBooking;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventTicketBookingApplication {

    public static void main(String[] args) {
        // Prevent the JDBC driver from sending the legacy "Asia/Calcutta" timezone
        // to PostgreSQL. Use the current IANA timezone identifier for India.
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));

        SpringApplication.run(EventTicketBookingApplication.class, args);
    }
}
// for first pull request