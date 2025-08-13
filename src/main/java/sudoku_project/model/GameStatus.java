package sudoku_project.model;

public enum GameStatus {
    NOT_STARTED("não iniciado"),
    INCOMPLET("incompleto"),
    COMPLET("completo");

    private String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }
}
