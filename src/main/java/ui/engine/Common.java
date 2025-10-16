package ui.engine;

import java.util.Random;
import java.util.UUID;

public class Common {

    public static String random() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public static String generateRandomPanNumber() {
        Random random = new Random();
        StringBuilder pan = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            pan.append((char) (65 + random.nextInt(10)));
        }
        for (int i = 0; i < 4; i++) {
            pan.append(random.nextInt(10));
        }
        pan.append((char) ('A' + random.nextInt(26)));
        return pan.toString().toUpperCase();
    }

    public static String generateRandomAdharNumber() {
        Random random = new Random();
        StringBuilder aadhaar = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            aadhaar.append(random.nextInt(10));

            if ((i + 1) % 4 == 0) {
                aadhaar.append(" ");
            }
        }

        return aadhaar.toString();
    }

    public static String generateMobileNumber() {
        Random random = new Random();
        StringBuilder mobile = new StringBuilder();
        mobile.append(9);
        for (int i = 0; i < 9; i++) {
            mobile.append(random.nextInt(10));
        }
        return mobile.toString();
    }
}
