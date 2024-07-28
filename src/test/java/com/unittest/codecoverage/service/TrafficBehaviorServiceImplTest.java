package com.unittest.codecoverage.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.unittest.codecoverage.services.impl.TrafficBehaviorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.unittest.codecoverage.exceptions.BehaviorException;
import com.unittest.codecoverage.models.Footpassenger;
import com.unittest.codecoverage.models.Traffic;
import com.unittest.codecoverage.models.TrafficLigth;

public class TrafficBehaviorServiceImplTest {

    @InjectMocks
    private TrafficBehaviorServiceImpl trafficBehaviorService;

    @Mock
    private Traffic currentTraffic;

    @Mock
    private Footpassenger currentFootpassengerBehavior;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFootpassengerCrossTheStreet_RedLightAndIntenseTraffic() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.RED);
        when(currentFootpassengerBehavior.crossedTheRoad()).thenReturn(true);
        when(currentTraffic.intenseCarTraffic()).thenReturn(true);

        assertThrows(BehaviorException.class, () -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_RedLightAndNotIntenseTraffic() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.RED);
        when(currentFootpassengerBehavior.crossedTheRoad()).thenReturn(true);
        when(currentTraffic.intenseCarTraffic()).thenReturn(false);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_GreenLightAndIntenseTrafficNoLook() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.GREEN);
        when(currentTraffic.intenseCarTraffic()).thenReturn(true);
        when(currentFootpassengerBehavior.lookedToTheLeft()).thenReturn(false);
        when(currentFootpassengerBehavior.lookedToTheRight()).thenReturn(false);

        assertThrows(BehaviorException.class, () -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_GreenLightAndIntenseTrafficLookedBothWays() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.GREEN);
        when(currentTraffic.intenseCarTraffic()).thenReturn(true);
        when(currentFootpassengerBehavior.lookedToTheLeft()).thenReturn(true);
        when(currentFootpassengerBehavior.lookedToTheRight()).thenReturn(true);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_GreenLightAndNotIntenseTrafficNoLook() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.GREEN);
        when(currentTraffic.intenseCarTraffic()).thenReturn(false);
        when(currentFootpassengerBehavior.lookedToTheLeft()).thenReturn(false);
        when(currentFootpassengerBehavior.lookedToTheRight()).thenReturn(false);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_GreenLightAndNotIntenseTrafficLookedBothWays() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.GREEN);
        when(currentTraffic.intenseCarTraffic()).thenReturn(false);
        when(currentFootpassengerBehavior.lookedToTheLeft()).thenReturn(true);
        when(currentFootpassengerBehavior.lookedToTheRight()).thenReturn(true);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_NonRedNonGreenLight() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.YELLOW);
        when(currentFootpassengerBehavior.crossedTheRoad()).thenReturn(false);
        when(currentTraffic.intenseCarTraffic()).thenReturn(false);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }
    @Test
    public void testFootpassengerCrossTheStreet_RedLightNotCrossedRoad() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.RED);
        when(currentFootpassengerBehavior.crossedTheRoad()).thenReturn(false);
        when(currentTraffic.intenseCarTraffic()).thenReturn(true);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_RedLightIntenseTrafficNotCrossedRoad() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.RED);
        when(currentFootpassengerBehavior.crossedTheRoad()).thenReturn(true);
        when(currentTraffic.intenseCarTraffic()).thenReturn(false);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_GreenLightIntenseTrafficLookedLeft() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.GREEN);
        when(currentTraffic.intenseCarTraffic()).thenReturn(true);
        when(currentFootpassengerBehavior.lookedToTheLeft()).thenReturn(true);
        when(currentFootpassengerBehavior.lookedToTheRight()).thenReturn(false);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

    @Test
    public void testFootpassengerCrossTheStreet_GreenLightIntenseTrafficLookedRight() {
        when(currentFootpassengerBehavior.getCrossedTrafficLigth()).thenReturn(TrafficLigth.GREEN);
        when(currentTraffic.intenseCarTraffic()).thenReturn(true);
        when(currentFootpassengerBehavior.lookedToTheLeft()).thenReturn(false);
        when(currentFootpassengerBehavior.lookedToTheRight()).thenReturn(true);

        assertDoesNotThrow(() -> {
            trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior);
        });
    }

}
