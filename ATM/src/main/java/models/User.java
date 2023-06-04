package models;

public class User {

    private final String userId;
    private final String userName;
    private final String emailId;
    private final String imageUrl;
    private final String address;
    private final String phoneNo;

    public User(String userId, String userName, String emailId, String imageUrl, String address, String phoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.imageUrl = imageUrl;
        this.address = address;
        this.phoneNo = phoneNo;
    }
}
