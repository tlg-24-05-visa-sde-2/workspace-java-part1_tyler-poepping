/*
 * For this test you can use any of the plant types. We just want to ensure we get errors when trying to create negative sized plants
 */

package com.plant;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlantTest {
    CommonPlant c1;

    @Before
    public void setUp() {
        c1 = new CommonPlant();
    }

    @Test
    public void commonNameShouldDefaultToGivenValueOfUnknown() {
        assertEquals("Unknown", c1.getCommonName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHeightShouldThrowException_ifNegativeValueIsGiven() {
        c1.setHeightInInches(-5.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setWidthShouldThrowException_ifNegativeValueIsGiven() {
        c1.setWidthInInches(-5.5);
    }
}