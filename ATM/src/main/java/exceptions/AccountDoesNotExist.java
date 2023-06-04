package exceptions;

public class AccountDoesNotExist extends Exception {

    public AccountDoesNotExist() {
        super();
    }

    public AccountDoesNotExist(String msg) {
        super(msg);
    }
}
