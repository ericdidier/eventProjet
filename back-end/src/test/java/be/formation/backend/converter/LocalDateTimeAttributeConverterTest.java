package be.formation.backend.converter;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class LocalDateTimeAttributeConverterTest {

    private LocalDateTimeAttributeConverter localDateTimeAttributeConverter;

    @Before
    public void setUp() {
        localDateTimeAttributeConverter = new LocalDateTimeAttributeConverter();
    }

    @Test
    public void convertToDatabaseColumnNull() throws Exception {
        LocalDateTime localDateTime = null;
        Timestamp result = localDateTimeAttributeConverter.convertToDatabaseColumn(localDateTime);
        assertEquals(null, result);
    }

    @Test
    public void convertToDatabaseColumnNotNull() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp expectedDate = Timestamp.valueOf(localDateTime);
        Timestamp result = localDateTimeAttributeConverter.convertToDatabaseColumn(localDateTime);
        assertEquals(expectedDate, result);
    }

    @Test
    public void convertToEntityAttributeNull() throws Exception {
        Timestamp date = null;
        LocalDateTime result = localDateTimeAttributeConverter.convertToEntityAttribute(date);
        assertEquals(null, result);
    }

    @Test
    public void convertToEntityAttributeNotNull() throws Exception {
        LocalDateTime expectedLocalDateTime = LocalDateTime.now();
        Timestamp date = Timestamp.valueOf(expectedLocalDateTime);
        LocalDateTime result = localDateTimeAttributeConverter.convertToEntityAttribute(date);
        assertEquals(expectedLocalDateTime, result);
    }

}