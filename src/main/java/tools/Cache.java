package tools;

public class Cache {
    public Cache() {
        // should startup a hashtable here with some sane size
    }

    public static void cleanup() {
        // everytime a get is done, call cleanup - ugly, sure, but could also put it on a timer in a seperate thread
        // not sure how to do that yet tho..
    }

    public static boolean get(String key) {
        return false;
    }

    public static boolean set(String key, String value) {
        return false;
    }
}
