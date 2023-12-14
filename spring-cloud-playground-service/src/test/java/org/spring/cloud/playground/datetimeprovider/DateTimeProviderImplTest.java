package org.spring.cloud.playground.datetimeprovider;

import org.assertj.core.data.TemporalOffset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = DateTimeProviderImpl.class)
class DateTimeProviderImplTest {

    @Autowired
    DateTimeProviderImpl dateTimeProvider;

    @Test
    void getCurrentDateTime() {
        assertThat(dateTimeProvider.getCurrentDateTime()).isCloseTo(LocalDateTime.now(), getDateTimeApproximation());
    }

    @Test
    void getCurrentDate() {
        assertThat(dateTimeProvider.getCurrentDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void getCurrentTime() {
        assertThat(dateTimeProvider.getCurrentTime()).isCloseTo(LocalTime.now(), getTimeApproximation());
    }

    private TemporalOffset<LocalDateTime> getDateTimeApproximation() {
        return new TemporalOffset<LocalDateTime>() {
            @Override
            public boolean isBeyondOffset(LocalDateTime localDateTime, LocalDateTime t1) {
                return localDateTime.toEpochSecond(ZoneOffset.UTC) - t1.toEpochSecond(ZoneOffset.UTC) >= 1;
            }

            @Override
            public String getBeyondOffsetDifferenceDescription(LocalDateTime localDateTime, LocalDateTime t1) {
                return null;
            }
        };
    }

    private TemporalOffset<LocalTime> getTimeApproximation() {
        return new TemporalOffset<LocalTime>() {
            @Override
            public boolean isBeyondOffset(LocalTime localTime, LocalTime t1) {
                return localTime.toSecondOfDay() - t1.toSecondOfDay() >= 1;
            }

            @Override
            public String getBeyondOffsetDifferenceDescription(LocalTime localTime, LocalTime t1) {
                return null;
            }
        };
    }

}