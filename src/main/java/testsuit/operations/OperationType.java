package testsuit.operations;

public enum OperationType {

    BIND("Bind Operasyonu"),
    SEARCH("Seach Operasyonu");

    private String name;

    OperationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
