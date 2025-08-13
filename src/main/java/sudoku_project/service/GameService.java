package sudoku_project.service;

import java.util.Scanner;

public class GameService {
    BoardService boardService;
    Scanner input;

    public GameService(String[] args, Scanner input) {
        boardService = new BoardService(args);
        this.input = input;
    }

    public void startGame() {
        int option;
        do {
            System.out.println("SELECIONE UMA OPÇÃO");
            System.out.println("1 - Adicionar número");
            System.out.println("2 - Remover número");
            System.out.println("3 - Mostrar tabuleiro do jogo");
            System.out.println("4 - Mostrar status do jogo");
            System.out.println("5 - Limpar jogo atual");
            System.out.println("6 - Encerrar jogo");
            System.out.print(" >> ");

            option = input.nextInt();

            switch (option) {
                case 1 -> boardService.addNewNumber();
                case 2 -> boardService.clearNumber();
                case 3 -> boardService.showBoard();
                case 4 -> boardService.showStatus();
                case 5 -> boardService.resetBoard();
                case 6 -> boardService.finishGame();
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        } while (option != 6);
    }
}


