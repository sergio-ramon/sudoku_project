package sudoku_project.application;

import sudoku_project.service.GameService;
import java.util.Scanner;

public class SudokuTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameService game = new GameService(args, input);
        game.startGame();
        input.close();
    }
}
