package be.nicholasmeyers.skodaconnector.util;

public class UserUtils {
    private UserUtils() {
    }

    public static String getEmail() {
        return System.getProperty("VWGROUP_USERNAME");
    }

    public static String getPassword() {
        return System.getProperty("VWGROUP_PASSWORD");
    }
}
