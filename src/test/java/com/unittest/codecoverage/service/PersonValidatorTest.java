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
        // Branch 1: name != null and name.trim().length() > 0
        assertTrue(personValidator.requiredName("John Doe"));

        // Branch 2: name != null and name.trim().length() == 0
        assertFalse(personValidator.requiredName("   "));

        // Branch 3: name == null
        assertFalse(personValidator.requiredName((String) null));

        // Additional branch to ensure full coverage
        assertFalse(personValidator.requiredName(""));
    }
}
