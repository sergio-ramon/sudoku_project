package sudoku_project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Objects.nonNull;

public class Board {
    private List<List<Square>> squares = new ArrayList<>();

    public Board(List<List<Square>> squares) {
        this.squares = squares;
    }

    public String addNumber(int col, int row, int number) {
        Square square = squares.get(col).get(row);

        if (square.isEditable()) {
            if (square.getNumber() == null) {
                square.setNumber(number);
            } else {
                return "Considere excluir o número existente antes de adicionar um novo!";
            }
        } else {
            return "Quadrado com número fixo. Edição impossível!";
        }

        return "Número adicionado";
    }

    public String removeNumber(int col, int row) {
        Square square = squares.get(col).get(row);

        if (square.isEditable()) {
            if (square.getNumber() != null) {
                square.setNumber(null);
            } else {
                return "Não existe número na posição selecionada!";
            }
        } else {
            return "Quadrado com número fixo. Edição impossível!";
        }

        return "Número removido";
    }

    public String reset() {
        squares.stream().flatMap(Collection::stream).forEach(sqr -> {
            if (sqr.isEditable()) {
                sqr.setNumber(null);
            }
        });

        return "Jogo reiniciado";
    }

    public String getGameStatus() {
        if (squares.stream().
                flatMap(Collection::stream).
                noneMatch(s -> s.isEditable() && nonNull(s.getNumber()))) {
            return GameStatus.NOT_STARTED.getValue();
        }

        return squares.stream().
                flatMap(Collection::stream).
                anyMatch(s -> s.getNumber() == null) ? GameStatus.INCOMPLET.getValue() : GameStatus.COMPLET.getValue();
    }

    public boolean containsError() {
        if (getGameStatus().equals(GameStatus.NOT_STARTED.getValue())) {
            return false;
        }

        return squares.stream().flatMap(Collection::stream).
                anyMatch(s -> s.getNumber() != null && !s.getNumber().equals(s.getExpected()));
    }

    public boolean gameOver() {
        return !containsError() && getGameStatus().equals(GameStatus.COMPLET.getValue());
    }

    public List<List<Square>> getSquares() {
        return squares;
    }

    public void setSquares(List<List<Square>> squares) {
        this.squares = squares;
    }
}
