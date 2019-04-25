package org.testmonkeys.maui.driverfactory;

import java.util.List;

public class ChromeOptionsConfig {

    private List<String> arguments;
    private List<String> encodedExtensions;
    private String binary;

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public List<String> getEncodedExtensions() {
        return encodedExtensions;
    }

    public void setEncodedExtensions(List<String> encodedExtensions) {
        this.encodedExtensions = encodedExtensions;
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }
}
