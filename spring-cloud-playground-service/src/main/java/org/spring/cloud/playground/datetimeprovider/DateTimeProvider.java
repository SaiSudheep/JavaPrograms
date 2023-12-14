package org.spring.cloud.playground.datetimeprovider;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface DateTimeProvider {

    LocalDateTime getCurrentDateTime();

    LocalDate getCurrentDate();

    LocalTime getCurrentTime();

}
