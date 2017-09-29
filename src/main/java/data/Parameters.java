package data;

public enum Parameters {

    SITEURL("https://www.moebel24.de/"),
    BROWSER("chrome");

    private String value;

    Parameters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
