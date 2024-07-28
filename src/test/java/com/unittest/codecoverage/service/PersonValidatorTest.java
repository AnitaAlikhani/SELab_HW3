package com.unittest.codecoverage.service;

import static org.junit.jupiter.api.Assertions.*;

import com.unittest.codecoverage.models.validators.PersonValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonValidatorTest {

    private PersonValidator personValidator;

    @BeforeEach
    public void setUp() {
        personValidator = new PersonValidator();
    }

    @Test
    public void testRequiredNameWithString() {
        assertTrue(personValidator.requiredName("John Doe"));
        assertFalse(personValidator.requiredName("   "));
        assertFalse(personValidator.requiredName((String) null));
        assertFalse(personValidator.requiredName(""));
    }
}
