/*
 * This plant class is abstracted as we can have many different types of plants.
 *
 * We use a couple different forms of data validation, in here we use a 'method' to validate our data and in our abstract classes we use the setter to validate our data. (Jay I did this for fun, in my experience, especially with spring, these are both viable solutions and comes down to the needs of each class and data being handled. I.E. I would validate at the class level with setters but also have validator methods for my service level to stop it before it even reaches the class. If im wrong on that let me know, but I've seen it both ways)
 *
 * Some plants are harvestable and some not, the harvestable plant class types implement the harvestable interface with signs the contract with the "harvest()" method.
 *
 * Every plant can be watered and die, so we keep that here, however, we delegate the growth to each class that IS A plant because they will have their own growth factor/rate of growth.
 *
 * For ease of use and instantiation, I made multiple constructors for all the classes, while this is overkill and necessary it just made it easier for me to test and play with.
 *
 */

package com.plant;

public abstract class Plant {
    public static final double MIN_HEIGHT = 0.0;
    public static final double MIN_WIDTH = 0.0;
    public static final String DEFAULT_COMMON_NAME = "Unknown";
    private String commonName;
    private WaterFrequency waterFrequency;
    private boolean isWilted;
    private double heightInInches;
    private double widthInInches;

    // Constructors
    public Plant() {
        this(DEFAULT_COMMON_NAME); // This delegates the Default commonName to the next constructor if one is not provided
    }

    public Plant(String commonName) {
        setCommonName(commonName);
    }

    public Plant(String commonName, double heightInInches, double widthInInches) {
        this(commonName);
        setHeightInInches(heightInInches);
        setWidthInInches(widthInInches);
    }

    public Plant(String commonName, WaterFrequency waterFrequency, double heightInInches, double widthInInches) {
        this(commonName, heightInInches, widthInInches);
        this.waterFrequency = waterFrequency;
    }

    // Business Methods
    public void water() {
        setWilted(false);
        System.out.println("You watered your plant, it will start to grow soon...");
    }

    public void die() {
        setWilted(true);
        setHeightInInches(0.0);
        setWidthInInches(0.0);
        System.out.println("Your plant has died...");
    }

    public abstract String grow(); // We are returning a String for testing purposes, while this can be void we couldn't test it and ensure its called properly. With Mockito we could void this during testing, however we are not implementing Maven yet

    // Getters and Setters
    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = validateCommonName(commonName);
    }

    public WaterFrequency getWaterFrequency() {
        return waterFrequency;
    }

    public void setWaterFrequency(WaterFrequency waterFrequency) {
        this.waterFrequency = waterFrequency;
    }

    public boolean isWilted() {
        return isWilted;
    }

    public void setWilted(boolean wilted) {
        isWilted = wilted;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = validateDimension(heightInInches, MIN_HEIGHT);
    }

    public double getWidthInInches() {
        return widthInInches;
    }

    public void setWidthInInches(double widthInInches) {
        this.widthInInches = validateDimension(widthInInches, MIN_WIDTH);
    }

    // Data Validation
    private String validateCommonName(String commonName) {
        if (commonName == null || commonName.trim().isEmpty()) {
            return DEFAULT_COMMON_NAME;
        }
        return commonName;
    }

    private double validateDimension(double dimension, double minDimension) {
        if (dimension < minDimension) {
            throw new IllegalArgumentException("Dimension cannot be less than " + minDimension);
        }
        return dimension;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Plant: " +
                " commonName='" + getCommonName() + '\'' +
                ", waterFrequency=" + getWaterFrequency() +
                ", isWilted=" + isWilted() +
                ", heightInInches=" + getHeightInInches() +
                ", widthInInches=" + getWidthInInches();
    }
}