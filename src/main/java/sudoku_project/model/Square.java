package sudoku_project.model;

public class Square {
    private Integer number;
    private Integer expected;
    private boolean editable;

    public Square(boolean editable, int expected) {
        this.editable = editable;
        this.expected = expected;
        if (!editable) {
            this.number = expected;
        } else {
            this.number = null;
        }
    }

    @Override
    public String toString() {
        if (number == null) return " ";
        return String.valueOf(number);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getExpected() {
        return expected;
    }

    public boolean isEditable() {
        return editable;
    }
}
