package com.unittest.codecoverage.service;

import static org.junit.jupiter.api.Assertions.*;

import com.unittest.codecoverage.models.Footpassenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FootpassengerTest {

    private Footpassenger footpassenger;

    @BeforeEach
    public void setUp() {
        footpassenger = new Footpassenger();
    }

    @Test
    public void testSetAndGetCrossedTheCrosswalk() {
        assertFalse(footpassenger.crossedTheCrosswalk());
        footpassenger.setCrossedTheCrosswalk(true);
        assertTrue(footpassenger.crossedTheCrosswalk());
        footpassenger.setCrossedTheCrosswalk(false);
        assertFalse(footpassenger.crossedTheCrosswalk());
    }
}
