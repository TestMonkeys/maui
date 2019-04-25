package org.testmonkeys.maui.driverfactory;

public class BrowserStackAuth {
    private String server;
    private String user;
    private String userEnvVar;
    private String key;
    private String keyEnvVar;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUserEnvVar() {
        return userEnvVar;
    }

    public void setUserEnvVar(String userEnvVar) {
        this.userEnvVar = userEnvVar;
    }

    public String getKeyEnvVar() {
        return keyEnvVar;
    }

    public void setKeyEnvVar(String keyEnvVar) {
        this.keyEnvVar = keyEnvVar;
    }
}
