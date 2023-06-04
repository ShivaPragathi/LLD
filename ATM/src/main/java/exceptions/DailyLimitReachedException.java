package exceptions;

public class DailyLimitReachedException extends Exception {

    public DailyLimitReachedException() {
        super();
    }

    public DailyLimitReachedException(String msg) {
        super(msg);
    }
}
