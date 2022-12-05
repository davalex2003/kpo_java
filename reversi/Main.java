import java.util.Scanner;

public class Main {
    public static final String BEGIN_TEXT = """
            Игра Реверси.
            Правила: https://ru.wikipedia.org/wiki/Реверси
            Ход следует вводить в виде число_по_вертикали число_по_горизонтали
            Возможные ходы отмечены на поле *""";
    public static final String NEXT_MOVE = "\nКаков ваш следующий ход? Введите число: ";
    public static final String ZERO_PEOPLE_MOVE = "\nУ вас нет ходов";
    public static final String ZERO_COMPUTER_MOVE = "\nУ компьютера нет ходов";
    public static int move_number = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board gameBoard = new Board();
        int possibleMoves;
        int vmove, gmove;
        System.out.println(BEGIN_TEXT);
        while (true) {
            if (gameBoard.getBoardIsFull()) {
                break;
            }
            possibleMoves = gameBoard.numberOfPossibleMoves("Player");
            gameBoard.drawBoard();
            if (possibleMoves > 0) {
                System.out.print(NEXT_MOVE);
                vmove = in.nextInt();
                gmove = in.nextInt();
                HumanMove move = new HumanMove(vmove, gmove);
                while (!move.checkMove(gameBoard)) {
                    System.out.print(NEXT_MOVE);
                    vmove = in.nextInt();
                    gmove = in.nextInt();
                    move = new HumanMove(vmove, gmove);
                }
                gameBoard.changeBoard((vmove - 1) * 8 + gmove, "Player");
                gameBoard.clearBoard();
                gameBoard.clearBoardArray();
                gameBoard.clearBoardArrayDirections();
            } else {
                System.out.println(ZERO_PEOPLE_MOVE);
            }
            if (gameBoard.getBoardIsFull()) {
                break;
            }
            move_number++;
            possibleMoves = gameBoard.numberOfPossibleMoves("Computer");
            if (possibleMoves > 0) {
                ComputerMove move = new ComputerMove(gameBoard);
                gameBoard.changeBoard(move.cell, "Computer");
                gameBoard.clearBoard();
                gameBoard.clearBoardArray();
                gameBoard.clearBoardArrayDirections();
            } else {
                System.out.println(ZERO_COMPUTER_MOVE);
            }
        }
        int res = gameBoard.score();
        System.out.println("\nВы набрали " + res + " очков");
        if (res < 32) {
            System.out.println("Вы проиграли(");
        } else {
            System.out.println("Вы выиграли!");
        }
    }
}
