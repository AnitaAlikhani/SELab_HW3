package com.unittest.codecoverage.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonExceptionTest {

    @Test
    void testConstructorWithSingleMessage() {
        String errorMessage = "Error message";
        PersonException exception = new PersonException(errorMessage);
        assertNotNull(exception.getMessage());
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testConstructorWithNullList() {
        PersonException exception = new PersonException((List<String>) null);
        assertNull(exception.getMessage(), "Message should be null when error list is null");
    }

    @Test
    void testConstructorWithEmptyList() {
        PersonException exception = new PersonException(Collections.emptyList());
        assertNull(exception.getMessage(), "Message should be null when error list is empty");
    }

    @Test
    void testConstructorWithNonEmptyList() {
        List<String> errors = Arrays.asList("Error 1", "Error 2");
        PersonException exception = new PersonException(errors);
        assertEquals("Error 1;Error 2", exception.getMessage(), "Message should be the concatenation of error list");
    }

}
