public class Board {
    final String[] board = new String[65];
    private int freeCells = 60;
    public String[][] possibleMovesWithDirections = new String[65][8];
    public int[] possibleMoves = new int[65];

    Board() {
        for (int i = 0; i < 65; i++) {
            board[i] = "   ";
        }
        board[28] = " O ";
        board[37] = " O ";
        board[29] = " X ";
        board[36] = " X ";
    }

    public void drawBoard() {
        System.out.println("\n\t    1   2   3   4   5   6   7   8\n");
        System.out.println("\t1  " + board[1] + "|" + board[2] + "|" + board[3] + "|" + board[4] + "|" + board[5] + "|" + board[6] + "|" + board[7] + "|" + board[8]);
        System.out.println("\t    ------------------------------");
        System.out.println("\t2  " + board[9] + "|" + board[10] + "|" + board[11] + "|" + board[12] + "|" + board[13] + "|" + board[14] + "|" + board[15] + "|" + board[16]);
        System.out.println("\t    ------------------------------");
        System.out.println("\t3  " + board[17] + "|" + board[18] + "|" + board[19] + "|" + board[20] + "|" + board[21] + "|" + board[22] + "|" + board[23] + "|" + board[24]);
        System.out.println("\t    ------------------------------");
        System.out.println("\t4  " + board[25] + "|" + board[26] + "|" + board[27] + "|" + board[28] + "|" + board[29] + "|" + board[30] + "|" + board[31] + "|" + board[32]);
        System.out.println("\t    ------------------------------");
        System.out.println("\t5  " + board[33] + "|" + board[34] + "|" + board[35] + "|" + board[36] + "|" + board[37] + "|" + board[38] + "|" + board[39] + "|" + board[40]);
        System.out.println("\t    ------------------------------");
        System.out.println("\t6  " + board[41] + "|" + board[42] + "|" + board[43] + "|" + board[44] + "|" + board[45] + "|" + board[46] + "|" + board[47] + "|" + board[48]);
        System.out.println("\t    ------------------------------");
        System.out.println("\t7  " + board[49] + "|" + board[50] + "|" + board[51] + "|" + board[52] + "|" + board[53] + "|" + board[54] + "|" + board[55] + "|" + board[56]);
        System.out.println("\t    ------------------------------");
        System.out.println("\t8  " + board[57] + "|" + board[58] + "|" + board[59] + "|" + board[60] + "|" + board[61] + "|" + board[62] + "|" + board[63] + "|" + board[64]);
    }

    public Boolean getCellIsEmpty(int x) {
        return board[x].equals("   ");
    }

    public Boolean getBoardIsFull() {
        return freeCells == 0;
    }

    public void decreaseFreeCells() {
        this.freeCells--;
    }

    public int numberOfPossibleMoves(String forWho) {
        int number = 0;
        String playerChip;
        String opponentChip;
        if (forWho.equals("Computer")) {
            playerChip = " O ";
            opponentChip = " X ";
        } else {
            playerChip = " X ";
            opponentChip = " O ";
        }
        int j, numberOfOpponents, numberOfDirections, change = 0;
        String direction = "";
        for (int i = 1; i <= 64; i++) {
            if (getCellIsEmpty(i)) {
                numberOfDirections = 0;
                for (int k = 0; k < 8; k++) {
                    switch (k) {
                        case 0 -> {
                            change = -9;
                            direction = "downright";
                        }
                        case 1 -> {
                            change = -8;
                            direction = "down";
                        }
                        case 2 -> {
                            change = -7;
                            direction = "downleft";
                        }
                        case 3 -> {
                            change = -1;
                            direction = "right";
                        }
                        case 4 -> {
                            change = 1;
                            direction = "left";
                        }
                        case 5 -> {
                            change = 7;
                            direction = "upright";
                        }
                        case 6 -> {
                            change = 8;
                            direction = "up";
                        }
                        case 7 -> {
                            change = 9;
                            direction = "upleft";
                        }
                    }
                    j = i + change;
                    numberOfOpponents = 0;
                    while (j >= 1 && j <= 64 && board[j].equals(opponentChip)) {
                        numberOfOpponents++;
                        j += change;
                        if (direction.equals("right") && j % 8 == 0) {
                            break;
                        }
                        if (direction.equals("left") && (j - 1) % 8 == 0) {
                            break;
                        }
                        if (direction.equals("upleft") && (j - 1) % 8 == 0) {
                            break;
                        }
                        if (direction.equals("downleft") && (j - 1) % 8 == 0) {
                            break;
                        }
                        if (direction.equals("upright") && j % 8 == 0) {
                            break;
                        }
                        if (direction.equals("downright") && j % 8 == 0) {
                            break;
                        }
                    }
                    if (numberOfOpponents > 0 && j >= 1 && j <= 64 && board[j].equals(playerChip)) {
                        possibleMovesWithDirections[i][numberOfDirections] = direction;
                        possibleMoves[i] = 1;
                        numberOfDirections++;
                        number++;
                        board[i] = " * ";
                    }
                }
            }
        }
        return number;
    }
    public void clearBoard() {
        for (int i = 1; i<= 64; i++) {
            if (board[i].equals(" * ")) {
                board[i] = "   ";
            }
        }
    }
    public void clearBoardArray() {
        for (int i = 1; i <= 64; i++) {
            possibleMoves[i] = 0;
        }
    }
    public void clearBoardArrayDirections() {
        for (int i = 1; i <= 64; i++) {
            for (int j = 0; j < 8; j++) {
                possibleMovesWithDirections[i][j] = null;
            }
        }
    }
    public void changeBoard(int move, String forWho) {
        String playerChip;
        String opponentChip;
        if (forWho.equals("Computer")) {
            playerChip = " O ";
            opponentChip = " X ";
        } else {
            playerChip = " X ";
            opponentChip = " O ";
        }
        int k;
        board[move] = playerChip;
        for (int i = 0; i < 8; i++) {
            k = move;
            if (possibleMovesWithDirections[move][i] != null) {
                switch (possibleMovesWithDirections[move][i]) {
                    case "up" -> {
                        k += 8;
                        while (k <= 64 && board[k].equals(opponentChip)) {
                            board[k] = playerChip;
                            k += 8;
                        }
                    }
                    case "upleft" -> {
                        k += 9;
                        while (k <= 64 && board[k].equals(opponentChip)) {
                            board[k] = playerChip;
                            k += 9;
                        }
                    }
                    case "upright" -> {
                        k += 7;
                        while (k <= 64 && board[k].equals(opponentChip)) {
                            board[k] = playerChip;
                            k += 7;
                        }
                    }
                    case "left" -> {
                        k += 1;
                        while (k <= 64 && board[k].equals(opponentChip)) {
                            board[k] = playerChip;
                            k += 1;
                        }
                    }
                    case "right" -> {
                        k -= 1;
                        while (k >= 1 && board[k].equals(opponentChip)) {
                            board[k] = playerChip;
                            k -= 1;
                        }
                    }
                    case "downleft" -> {
                        k -= 7;
                        while (k >= 1 && board[k].equals(opponentChip)) {
                            board[k] = playerChip;
                            k -= 7;
                        }
                    }
                    case "down" -> {
                        k -= 8;
                        while (k >= 1 && board[k].equals(opponentChip)) {
                            board[k] = playerChip;
                            k -= 8;
                        }
                    }
                    case "downright" -> {
                        k -= 9;
                        while (k >= 1 && board[k].equals(opponentChip)) {
                            board[k] = playerChip;
                            k -= 9;
                        }
                    }
                }
            } else {
                break;
            }
        }
        decreaseFreeCells();
    }
    public int score() {
        int ans = 0;
        for (int i = 1; i <= 64; i++) {
            if (board[i].equals(" X ")) {
                ans++;
            }
        }
        return ans;
    }
}
