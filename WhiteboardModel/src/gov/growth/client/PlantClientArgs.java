package gov.growth.client;

import gov.growth.CommonPlant;
import gov.growth.WaterFrequency;

import java.util.Arrays;

public class PlantClientArgs {
    public static void main(String[] args) {
        if(args.length < 4) {
            String usage = "USAGE: We are going to build the Common Plant for this example which takes 4 arguments \n";
            String note = "NOTE: The Common Plant must take: \n Common Name \n Water Frequency \n Height In Inches (double) \n Width In Inches (double) \n";
            String note2 = "NOTE: Water Frequency is constrained to: " + Arrays.asList(WaterFrequency.values());
            String example = "Example: Fern DAILY 12.5  10.5 \n";
            System.out.println(usage + "\n" + example + "\n" + note + "\n" + note2);
        }

        CommonPlant c1 = new CommonPlant(
                args[0],
                WaterFrequency.valueOf(args[1].toUpperCase()),
                Double.parseDouble(args[2]),
                Double.parseDouble(args[3])
        );

        System.out.println(c1);
    }
}
