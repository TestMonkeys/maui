package org.testmonkeys.webpages.tests.entitymapping;

public class UserEntity {

    private String phone;
    private String username;
    private boolean readingHobby;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isReadingHobby() {
        return readingHobby;
    }

    public void setReadingHobby(boolean readingHobby) {
        this.readingHobby = readingHobby;
    }
}
