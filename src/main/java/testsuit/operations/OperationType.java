package testsuit.operations;

public enum OperationType {

    BIND("Bind Operation"),
    SEARCH("Seach Operation"),
    MODIFY("Modify Operation");

    private String name;

    OperationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
