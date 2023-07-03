package util;

import model.User;

import java.util.concurrent.atomic.AtomicLong;

public class BnplUtil {

    private static AtomicLong idCounter = new AtomicLong();

    private static User loggedInUser = null;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        BnplUtil.loggedInUser = loggedInUser;
    }

    public static String generateNewId() {
        return String.valueOf(idCounter.getAndIncrement());
    }

}
