package com.plant;

import java.util.Arrays;
import java.util.List;

public class VegetablePlant extends Plant implements Harvestable {
    private String vegetableType;
    private boolean wasHarvested;
    private static final List<String> validVegetables = Arrays.asList(
            "Squash", "Pepper", "Zucchini", "Cucumber",
            "Corn", "Lettuce", "Spinach", "Potato", "Onion",
            "Broccoli"
    );

    public static final double HEIGHT_GROWTH_FACTOR = 1.5;
    public static final double WIDTH_GROWTH_FACTOR = 1.1;

    public VegetablePlant() {
        super();
    }

    public VegetablePlant(String commonName) {
        super(commonName);
    }

    public VegetablePlant(String commonName, String vegetableType) {
        this(commonName);
        setVegetableType(vegetableType);
    }

    public VegetablePlant(String commonName, double heightInInches, double widthInInches) {
        super(commonName, heightInInches, widthInInches);
    }

    public VegetablePlant(String commonName, WaterFrequency waterFrequency, double heightInInches, double widthInInches, String vegetableType) {
        super(commonName, waterFrequency, heightInInches, widthInInches);
        setVegetableType(vegetableType);
    }


    @Override
    public String grow() {
        setWidthInInches(getWidthInInches() + Math.random() * WIDTH_GROWTH_FACTOR);
        setHeightInInches(getHeightInInches() + Math.random() * HEIGHT_GROWTH_FACTOR);
        System.out.println(getVegetableType() + " is growing...");
        return "plant is growing";
    }

    @Override
    public void harvest() {
        if (getHeightInInches() > 8.5 && getWidthInInches() > 4.5) {
            System.out.println("This was a bountiful " + getVegetableType() + " harvest");
            setWasHarvested(true); // Set the plant to harvested
        } else {
            System.out.println("This years harvest was not great, try growing your plants more");
            setWasHarvested(true); // Set the plant to harvested
        }
    }

    public void setVegetableType(String vegetableType) {
        if (vegetableType == null || vegetableType.trim().isEmpty()) {
            throw new IllegalArgumentException("Vegetable type cannot be null or empty");
        }
        if (validVegetables.contains(vegetableType.trim())) {
            this.vegetableType = vegetableType.trim();
        } else {
            System.out.println("That is not a valid vegetable plant. Only the following vegetables are valid:");
            for (String vegie : validVegetables) {
                System.out.println(vegie);
            }
            throw new IllegalArgumentException(vegetableType + " was not in the list above");
        }
    }

    public String getVegetableType() {
        return vegetableType;
    }

    public boolean wasHarvested() {
        return wasHarvested;
    }

    public void setWasHarvested(boolean wasHarvested) {
        this.wasHarvested = wasHarvested;
    }

    @Override
    public String toString() {
        return super.toString() + ", VegetablePlant=true" +
                ", vegetableType=" + getVegetableType();
    }
}
