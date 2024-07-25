package com.unittest.codecoverage.service;

import com.unittest.codecoverage.models.StreetDirectionFlow;
import com.unittest.codecoverage.models.Traffic;
import com.unittest.codecoverage.models.TrafficLigth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrafficTest {

    private Traffic traffic;

    @BeforeEach
    void setUp() {
        traffic = new Traffic();
    }

    @Test
    void testGetSetCurrentTrafficLight() {
        TrafficLigth expectedLight = TrafficLigth.GREEN;
        traffic.setCurrentTrafficLight(expectedLight);
        assertEquals(expectedLight, traffic.getCurrentTrafficLight());
    }

    @Test
    void testGetSetIntenseCarTraffic() {
        traffic.setIntenseCarTraffic(true);
        assertTrue(traffic.intenseCarTraffic());

        traffic.setIntenseCarTraffic(false);
        assertFalse(traffic.intenseCarTraffic());
    }

    @Test
    void testGetSetMaxSpeedAllowed() {
        short expectedSpeed = 50;
        traffic.setMaxSpeedAllowed(expectedSpeed);
        assertEquals(expectedSpeed, traffic.getMaxSpeedAllowed());
    }

    @Test
    void testGetSetMinSpeedAllowed() {
        short expectedSpeed = 30;
        traffic.setMinSpeedAllowed(expectedSpeed);
        assertEquals(expectedSpeed, traffic.getMinSpeedAllowed());
    }

    @Test
    void testGetSetStreetDirectionFlow() {
        StreetDirectionFlow expectedFlow = StreetDirectionFlow.ONE_WAY;
        traffic.setStreetDirectionFlow(expectedFlow);
        assertEquals(expectedFlow, traffic.getStreetDirectionFlow());
    }
}
