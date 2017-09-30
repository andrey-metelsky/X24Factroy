package data;

public enum DefaultValues {

    QTY_OF_PRODUCTS_PER_PAGE("56"),
    FIRST_PAGE_PAGINATION_INFO("1   -   56"),
    SECOND_PAGE_PAGINATION_INFO("57   -   112");

    private String value;

    DefaultValues (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
