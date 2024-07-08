package com.plant;

import java.util.Arrays;
import java.util.List;

public class FruitPlant extends Plant implements Harvestable {
    private String fruitType;
    private static final List<String> VALID_FRUITS = Arrays.asList(
            "Apple", "Orange", "Banana", "Strawberry",
            "Grape", "Lemon", "Peach", "Pear", "Pineapple",
            "Watermelon", "Blueberry", "Blackberry"
    );

    public static final double HEIGHT_GROWTH_FACTOR = 1.8;
    public static final double WIDTH_GROWTH_FACTOR = 1.3;

    public FruitPlant() {
        super();
    }

    public FruitPlant(String commonName) {
        super(commonName);
    }

    public FruitPlant(String commonName, String fruitType) {
        this(commonName);
        setFruitType(fruitType);
    }

    public FruitPlant(String commonName, double heightInInches, double widthInInches) {
        super(commonName, heightInInches, widthInInches);
    }

    public FruitPlant(String commonName, WaterFrequency waterFrequency, double heightInInches, double widthInInches, String fruitType) {
        super(commonName, waterFrequency, heightInInches, widthInInches);
        setFruitType(fruitType);
    }

    @Override
    public String grow() {
        setWidthInInches(getWidthInInches() + Math.random() * WIDTH_GROWTH_FACTOR);
        setHeightInInches(getHeightInInches() + Math.random() * HEIGHT_GROWTH_FACTOR);
        System.out.println(getFruitType() + " plant is growing...");
        return "plant is growing";
    }

    public void harvest() {
        if (getHeightInInches() > 7.0 && 5.0 > getWidthInInches()) {
            System.out.println("This was a bountiful " + getFruitType() + " harvest");
        } else {
            System.out.println("This year's harvest was not great, try growing your plants more");
        }
    }

    public void setFruitType(String fruitType) {
        if (fruitType == null || fruitType.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit type cannot be null or empty");
        }
        if (VALID_FRUITS.contains(fruitType.trim())) {
            this.fruitType = fruitType.trim();
        } else {
            System.out.println("That is not a valid fruit plant. Only the following fruits are valid:");
            for (String fruit : VALID_FRUITS) {
                System.out.println(fruit);
            }
        }
    }

    public String getFruitType() {
        return fruitType;
    }

    @Override
    public String toString() {
        return super.toString() + ", FruitPlant=true" +
                ", fruitType=" + getFruitType();
    }
}