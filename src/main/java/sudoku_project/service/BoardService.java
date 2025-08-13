package sudoku_project.service;

import sudoku_project.model.Board;
import sudoku_project.model.Square;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BoardService {
    private Board board;
    Scanner input = new Scanner(System.in);

    private static final int MIN = 1;
    private static final int MAX = 9;

    public BoardService(String[] args) {
        board = generateBoard(args);
    }

    public void showBoard() {
        String middleLines = "╠" + "=" + "=====╪=====╪=====" + "║" + "=====╪=====╪=====" + "║" + "=====╪=====╪======" + "╣";
        System.out.println("╔===1==╤==2==╤==3==╦==4==╤==5==╤==6==╦==7==╤==8==╤==9===╗");
        System.out.printf("1|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n" + "║" + "├-----┼-----┼-----" + "╫-----┼-----┼-----" + "╫-----┼-----┼-----" + "┤║\n",
                board.getSquares().get(0).get(0), board.getSquares().get(1).get(0), board.getSquares().get(2).get(0),
                board.getSquares().get(3).get(0), board.getSquares().get(4).get(0), board.getSquares().get(5).get(0),
                board.getSquares().get(6).get(0), board.getSquares().get(7).get(0), board.getSquares().get(8).get(0));
        System.out.printf("2|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n" + "║" + "├-----┼-----┼-----" + "╫-----┼-----┼-----" + "╫-----┼-----┼-----" + "┤║\n",
                board.getSquares().get(0).get(1), board.getSquares().get(1).get(1), board.getSquares().get(2).get(1),
                board.getSquares().get(3).get(1), board.getSquares().get(4).get(1), board.getSquares().get(5).get(1),
                board.getSquares().get(6).get(1), board.getSquares().get(7).get(1), board.getSquares().get(8).get(1));
        System.out.printf("3|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n",
                board.getSquares().get(0).get(2), board.getSquares().get(1).get(2), board.getSquares().get(2).get(2),
                board.getSquares().get(3).get(2), board.getSquares().get(4).get(2), board.getSquares().get(5).get(2),
                board.getSquares().get(6).get(2), board.getSquares().get(7).get(2), board.getSquares().get(8).get(2));
        System.out.println(middleLines);
        System.out.printf("4|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n" + "║" + "├-----┼-----┼-----" + "╫-----┼-----┼-----" + "╫-----┼-----┼-----" + "┤║\n",
                board.getSquares().get(0).get(3), board.getSquares().get(1).get(3), board.getSquares().get(2).get(3),
                board.getSquares().get(3).get(3), board.getSquares().get(4).get(3), board.getSquares().get(5).get(3),
                board.getSquares().get(6).get(3), board.getSquares().get(7).get(3), board.getSquares().get(8).get(3));
        System.out.printf("5|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n" + "║" + "├-----┼-----┼-----" + "╫-----┼-----┼-----" + "╫-----┼-----┼-----" + "┤║\n",
                board.getSquares().get(0).get(4), board.getSquares().get(1).get(4), board.getSquares().get(2).get(4),
                board.getSquares().get(3).get(4), board.getSquares().get(4).get(4), board.getSquares().get(5).get(4),
                board.getSquares().get(6).get(4), board.getSquares().get(7).get(4), board.getSquares().get(8).get(4));
        System.out.printf("6|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n",
                board.getSquares().get(0).get(5), board.getSquares().get(1).get(5), board.getSquares().get(2).get(5),
                board.getSquares().get(3).get(5), board.getSquares().get(4).get(5), board.getSquares().get(5).get(5),
                board.getSquares().get(6).get(5), board.getSquares().get(7).get(5), board.getSquares().get(8).get(5));
        System.out.println(middleLines);
        System.out.printf("7|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n" + "║" + "├-----┼-----┼-----" + "╫-----┼-----┼-----" + "╫-----┼-----┼-----" + "┤║\n",
                board.getSquares().get(0).get(6), board.getSquares().get(1).get(6), board.getSquares().get(2).get(6),
                board.getSquares().get(3).get(6), board.getSquares().get(4).get(6), board.getSquares().get(5).get(6),
                board.getSquares().get(6).get(6), board.getSquares().get(7).get(6), board.getSquares().get(8).get(6));
        System.out.printf("8|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n" + "║" + "├-----┼-----┼-----" + "╫-----┼-----┼-----" + "╫-----┼-----┼-----" + "┤║\n",
                board.getSquares().get(0).get(7), board.getSquares().get(1).get(7), board.getSquares().get(2).get(7),
                board.getSquares().get(3).get(7), board.getSquares().get(4).get(7), board.getSquares().get(5).get(7),
                board.getSquares().get(6).get(7), board.getSquares().get(7).get(7), board.getSquares().get(8).get(7));
        System.out.printf("9|  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  ║  %s  |  %s  |  %s  |║\n",
                board.getSquares().get(0).get(8), board.getSquares().get(1).get(8), board.getSquares().get(2).get(8),
                board.getSquares().get(3).get(8), board.getSquares().get(4).get(8), board.getSquares().get(5).get(8),
                board.getSquares().get(6).get(8), board.getSquares().get(7).get(8), board.getSquares().get(8).get(8));
        System.out.println("╚===1==╧==2==╧==3==╩==4==╧==5==╧==6==╩==7==╧==8==╧==9===╝");
    }

    public void showStatus() {
        System.out.println("Jogo " + board.getGameStatus());

        List<Square> squaresWithError = board.getSquares().stream().flatMap(Collection::stream).
                filter(s -> s.getNumber() != null && !s.getNumber().equals(s.getExpected())).toList();

        if (!squaresWithError.isEmpty()) {
            System.out.println("Contém os seguintes erros: ");
            board.getSquares().forEach(s -> {
                for (Square square : squaresWithError) {
                    if (s.contains(square)) {
                        System.out.println("Coluna: " + (board.getSquares().indexOf(s) + 1) + " Linha: " + (s.indexOf(square) + 1));
                    }
                }
            });
        } else {
            System.out.println("Sem erros até o momento");
        }
    }

    public void addNewNumber() {
        System.out.println("Digite o número da coluna");
        System.out.print(" >> ");
        int column = getWhileInvalid(MIN, MAX);

        System.out.println("Digite o número da linha");
        System.out.print(" >> ");
        int row = getWhileInvalid(MIN, MAX);

        System.out.println("Digite o valor que deseja adicionar");
        System.out.print(" >> ");
        int value = getWhileInvalid(MIN, MAX);

        System.out.println(board.addNumber(column-1, row-1, value));
    }

    public void clearNumber() {
        System.out.println("Digite o número da coluna");
        System.out.print(" >> ");
        int column = getWhileInvalid(MIN, MAX);

        System.out.println("Digite o número da linha");
        System.out.print(" >> ");
        int row = getWhileInvalid(MIN, MAX);

        System.out.println(board.removeNumber(column-1, row-1));
    }

    public int getWhileInvalid(int min, int max) {
        String value = input.next();

        if (!Pattern.matches("\\d", value)) {
            value = "-1";
        }

        while (Integer.parseInt(value) < min || Integer.parseInt(value) > max) {
            System.out.println("Digite um número válido");
            value = input.next();
            if (!Pattern.matches("\\d", value)) {
                value = "-1";
            }
        }

        return Integer.parseInt(value);
    }

    public void resetBoard() {
        System.out.println(board.reset());
    }

    public void finishGame() {
        if (board.gameOver()) {
            System.out.println("Jogo finalizado com sucesso!");
        } else {
            List<Square> squaresWithError = board.getSquares().stream().flatMap(Collection::stream).
                    filter(s -> s.getNumber() != null && !s.getNumber().equals(s.getExpected())).toList();

            if (!squaresWithError.isEmpty()) {
                System.out.println("Jogo finalizado com os seguintes erros: ");
                board.getSquares().forEach(s -> {
                    for (Square square : squaresWithError) {
                        if (s.contains(square)) {
                            System.out.println("Coluna: " + (board.getSquares().indexOf(s) + 1) + " Linha: " + (s.indexOf(square) + 1));
                        }
                    }
                });
            } else {
                System.out.println("Jogo não finalizado. Até a próxima.");
            }
        }
    }

    public Board generateBoard(String[] args) {
        var squares = Stream.of(args).collect(Collectors.toMap(
                a -> a.split(";")[0],
                b -> b.split(";")[1]
        ));

        List<List<Square>> squareList = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            squareList.add(new ArrayList<>());
            for (int j = 0; j < MAX; j++) {
                String config = squares.get("%s,%s".formatted(i, j));
                int expected = Integer.parseInt(config.split(",")[0]);
                boolean editable = Boolean.parseBoolean(config.split(",")[1]);
                squareList.get(i).add(new Square(editable, expected));
            }
        }

        return new Board(squareList);
    }
}
