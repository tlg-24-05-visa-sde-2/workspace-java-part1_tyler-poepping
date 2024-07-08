package gov.growth;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VegetablePlantTest {

    public VegetablePlant v1;

    // Initialize a new VegetablePlant object before each test
    @Before
    public void setUp() {
        v1 = new VegetablePlant("Pepper",  10.5, 8.7);
        v1.setVegetableType("Pepper");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVegetableType_shouldThrowIllegalArgumentException_ifInvalidVegetableType() {
        v1.setVegetableType("Banana");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVegetableType_shouldThrowIllegalArgumentException_withNullInput() {
        v1.setVegetableType(null);
    }

    @Test
    public void harvestMethod_shouldSetPlantHarvestedToTrue() {
        v1.harvest();
        assertTrue(v1.wasHarvested());
    }

    @Test
    public void growMethodShouldReturnMessage_plantIsGrowing() {
        String expectedMessage = "plant is growing";
        assertEquals(expectedMessage, v1.grow());
    }
}