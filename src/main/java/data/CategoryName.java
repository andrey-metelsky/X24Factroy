package data;

public enum CategoryName {
    HOCKER("Hocker"),
    SESSEL("Sessel"),
    REGALE("Regale");

    private String value;

    CategoryName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
