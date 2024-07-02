package com.plant.client;

import com.plant.*;

import static com.plant.WaterFrequency.Daily;

public class PlantClient {
    public static void main(String[] args) {
        VegetablePlant p1 = new VegetablePlant("Carolina Reaper", "Pepper");
        p1.water();
        p1.grow();
        p1.harvest();
        System.out.println(p1 + "\n");

        FruitPlant p2 = new FruitPlant("Blueberry", 7.5, 6.5);
        p2.setFruitType("Blueberry");
        p2.grow();
        p2.water();
        p2.grow();
        p2.harvest();
        System.out.println(p2 + "\n");


        CommonPlant p3 = new CommonPlant("Fern", Daily, 4.2, 3.8);
        p3.water();
        p3.grow();
        p3.die();
        System.out.println(p3);
    }
}