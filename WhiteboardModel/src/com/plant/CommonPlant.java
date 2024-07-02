package com.plant;

public class CommonPlant extends Plant {
    public static final double HEIGHT_GROWTH_FACTOR = 1.2;
    public static final double WIDTH_GROWTH_FACTOR = 1.0;

    public CommonPlant() {
        super();
    }

    public CommonPlant(String commonName) {
        super(commonName);
    }

    public CommonPlant(String commonName, double heightInInches, double widthInInches) {
        super(commonName, heightInInches, widthInInches);
    }

    public CommonPlant(String commonName, WaterFrequency waterFrequency, double heightInInches, double widthInInches) {
        super(commonName, waterFrequency, heightInInches, widthInInches);
    }

    @Override
    public String grow() {
        setWidthInInches(getWidthInInches() + Math.random() * WIDTH_GROWTH_FACTOR);
        setHeightInInches(getHeightInInches() + Math.random() * HEIGHT_GROWTH_FACTOR);
        System.out.println(getCommonName() + " plant is growing...");
        return "plant is growing";
    }

    @Override
    public String toString() {
        return super.toString() + ", CommonPlant=true";
    }
}