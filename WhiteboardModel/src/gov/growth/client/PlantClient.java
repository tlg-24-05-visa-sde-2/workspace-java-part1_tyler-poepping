package gov.growth.client;

import gov.growth.*;
import gov.growth.CommonPlant;
import gov.growth.FruitPlant;
import gov.growth.VegetablePlant;
import gov.growth.WaterFrequency;


public class PlantClient {
    public static void main(String[] args) {

        // Vegetable Plant Instance
        VegetablePlant p1 = new VegetablePlant("Carolina Reaper", "Pepper");
        p1.water();
        p1.grow();
        p1.harvest();
        System.out.println(p1 + "\n");

        // Fruit Plant Instance
        FruitPlant p2 = new FruitPlant("Blueberry", 7.5, 6.5);
        p2.setFruitType("Blueberry");
        p2.grow();
        p2.water();
        p2.grow();
        p2.harvest();
        System.out.println(p2 + "\n");

        // Common Plant Instance
        CommonPlant p3 = new CommonPlant("Fern", WaterFrequency.DAILY, 4.2, 3.8);
        p3.water();
        p3.grow();
        p3.die();
        System.out.println(p3);
    }
}