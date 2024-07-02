package src;

public class Television {
    public static int nextId = 1;
    private static int instanceCount = 0;
    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 0;

    private int id;
    private String brand;
    private Integer volume;
    private boolean muted;
    private int savedVolume;
    private DisplayType display = DisplayType.LED;


    // Constructors
    public Television() {
    }

    public Television(String brand, Integer volume, boolean muted, int savedVolume, DisplayType display) {
        instanceCount++;
        this.id = nextId++;
        this.brand = brand;
        this.volume = volume;
        this.muted = muted;
        this.savedVolume = savedVolume;
        this.display = display;
    }

    // METHODS
    /*
     * Static methods are called from the class itself
     * Non-static methods are called and rely on instances of the class
     *
     * Static methods are created at compile time
     * Non-static methods are created at run time, ergo, they cannot be called within each other
     */
    public static int getInstanceCount(Television tv) {
        boolean isTv1Connected = tv.verifyInternetConnection();
        if (isTv1Connected) {
            System.out.println("Turning on your " + tv.brand + " TV to volume " + tv.volume);
            System.out.println();
        } else {
            System.out.println("Your TV is not connected to the internet, try again later... loooosssseerrrr");
        }
        return instanceCount;
    }

    private boolean verifyInternetConnection() {
        return true;
    }

    public void turnOn() {
        boolean isConnected = verifyInternetConnection();
        String connection = isConnected ? "TV is connected. " : "TV is not Connected";
        System.out.println("Turning on your " + brand + " TV to volume " + volume + ". " + "Your TV is " + connection);
    }

    void turnOff() {
        System.out.println("Shutting Down...goodbye");
    }

    /*
     * Single use case for mute
     * Every call we just set the opposite of what muted is
     */
    public void mute() {
        setSavedVolume(isMuted() ? getSavedVolume() : getVolume()); // Save current volume only if not muted
        setMuted(!isMuted()); // Toggle the muted state
        setVolume(isMuted() ? MIN_VOLUME : getSavedVolume()); // Set volume to MIN_VOLUME if muted, otherwise restore saved volume

        // Print the appropriate message
        System.out.println(
                isMuted() ?
                        "TV is muted and the volume is " + getVolume() // If muted is true
                        :
                        "TV is un-muted and the volume is " + getVolume() // If it's not muted
        );
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        // Alternative
        if (
                        "Samsung".equalsIgnoreCase(brand) ||
                        "Sony".equalsIgnoreCase(brand) ||
                        "LG".equalsIgnoreCase(brand) ||
                        "Toshiba".equalsIgnoreCase(brand)
        ) {
            this.brand = brand;
        } else {
            System.err.println("Brand is invalid, Valid brands include 'Toshiba', 'Samsung', 'LG', or 'Toshiba'");
        }

        // Alternative 2
        switch (brand.toLowerCase()) {
            case "samsung", "lg", "sony", "toshiba" -> this.brand = brand;
            default -> System.err.println("We don't do those TV's here sir");
        }

        // Alternative 3
//        String[] validBrands = new String[]{"Samsung", "Toshiba", "LG", "Sony"};
//        boolean isValidBrand = false;
//
//        for (String b : validBrands) {
//            if (brand.equalsIgnoreCase(b)) {
//                this.brand = b;
//                isValidBrand = true;
//                break;
//            }
//        }
//
//        if (!isValidBrand) {
//            System.err.println("We don't do those TV's here sir");
//        }
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        if (volume > MAX_VOLUME || volume < MIN_VOLUME) {
            System.out.println("TV Cannot do that!");
        } else {
            this.volume = volume;
            setMuted(false);
        }
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public int getSavedVolume() {
        return savedVolume;
    }

    public void setSavedVolume(int savedVolume) {
        this.savedVolume = savedVolume;
    }


    public DisplayType getDisplay() {
        return display;
    }

    public void setDisplay(DisplayType display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Television: " +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", volume=" + (isMuted() ? "<muted>" : String.valueOf(getVolume())) +
                ", muted=" + muted +
                ", savedVolume=" + savedVolume +
                ", display=" + display;
    }
}