public class HumanMove {
    public static final String INCORRECT_MOVE = "Такой ход сделать невозможно";
    private final int vmove;
    private final int gmove;
    HumanMove(int vmove, int gmove) {
        this.vmove = vmove;
        this.gmove = gmove;
    }
    public boolean checkMove (Board board) {
        if (board.possibleMoves[(vmove - 1) * 8 + gmove] != 1) {
            System.out.println(INCORRECT_MOVE);
            return false;
        } else {
            return true;
        }
    }
}
