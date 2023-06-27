package util;

import models.User;

import java.util.concurrent.atomic.AtomicLong;

public class FoodKartUtil {

    private static AtomicLong idCounter = new AtomicLong();
    private static User loggedInUser = null;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        FoodKartUtil.loggedInUser = loggedInUser;
    }

    public static String generateNewId() {
        return String.valueOf(idCounter.getAndIncrement());
    }
}
