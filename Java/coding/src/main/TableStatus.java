package main;

public enum TableStatus {
    YES("1", true),
    NO("0", false);

    private String table1Value;
    private boolean table2Value;

    private TableStatus(String table1Value, boolean table2Value) {
        this.table1Value = table1Value;
        this.table2Value = table2Value;
    }

    public String getTable1Value() {
        return table1Value;
    }

    public boolean isTable2Value() {
        return table2Value;
    }
}
