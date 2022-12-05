public class ComputerMove {
    public int cell;
    ComputerMove(Board board) {
        double sum, max = 0;
        int max_i = 0, k;
        for (int i = 1; i <= 64; i++) {
            if (board.possibleMoves[i] == 1) {
                if (i == 1 || i == 8 || i == 57 || i == 64) {
                    sum = 0.8;
                } else if (i < 8 || i % 8 == 0 || (i - 1) % 8 == 0 || i > 57) {
                    sum = 0.4;
                } else {
                    sum = 0;
                }
                for (int j = 0; j < 8; j++) {
                    k = i;
                    if (board.possibleMovesWithDirections[k][j] != null) {
                        switch (board.possibleMovesWithDirections[k][j]) {
                            case "up" -> {
                                k += 8;
                                while (k <= 64 && board.board[k].equals(" X ")) {
                                    if (k < 8 || k % 8 == 0 || (k - 1) % 8 == 0 || k > 57) {
                                        sum += 2;
                                    } else {
                                        sum++;
                                    }
                                    k += 8;
                                }
                            }
                            case "upleft" -> {
                                k += 9;
                                while ((k - 1) % 8 != 0 && k <= 64 && board.board[k].equals(" X ")) {
                                    if (k < 8 || k % 8 == 0 || (k - 1) % 8 == 0 || k > 57) {
                                        sum += 2;
                                    } else {
                                        sum++;
                                    }
                                    k += 9;
                                }
                            }
                            case "upright" -> {
                                k += 7;
                                while (k % 8 != 0 && k <= 64 && board.board[k].equals(" X ")) {
                                    if (k < 8 || k % 8 == 0 || (k - 1) % 8 == 0 || k > 57) {
                                        sum += 2;
                                    } else {
                                        sum++;
                                    }
                                    k += 7;
                                }
                            }
                            case "left" -> {
                                k += 1;
                                while ((k - 1) % 8 != 0 && k <= 64 && board.board[k].equals(" X ")) {
                                    if (k < 8 || k % 8 == 0 || (k - 1) % 8 == 0 || k > 57) {
                                        sum += 2;
                                    } else {
                                        sum++;
                                    }
                                    k += 1;
                                }
                            }
                            case "right" -> {
                                k -= 1;
                                while (k % 8 != 0 && k >= 1 && board.board[k].equals(" X ")) {
                                    if (k < 8 || k % 8 == 0 || (k - 1) % 8 == 0 || k > 57) {
                                        sum += 2;
                                    } else {
                                        sum++;
                                    }
                                    k -= 1;
                                }
                            }
                            case "downleft" -> {
                                k -= 7;
                                while ((k - 1) % 8 != 0 && k >= 1 && board.board[k].equals(" X ")) {
                                    if (k < 8 || k % 8 == 0 || (k - 1) % 8 == 0 || k > 57) {
                                        sum += 2;
                                    } else {
                                        sum++;
                                    }
                                    k -= 7;
                                }
                            }
                            case "down" -> {
                                k -= 8;
                                while (k >= 1 && board.board[k].equals(" X ")) {
                                    if (k < 8 || k % 8 == 0 || (k - 1) % 8 == 0 || k > 57) {
                                        sum += 2;
                                    } else {
                                        sum++;
                                    }
                                    k -= 8;
                                }
                            }
                            case "downright" -> {
                                k -= 9;
                                while ((k - 1) % 8 != 0 && k >= 1 && board.board[k].equals(" X ")) {
                                    if (k < 8 || k % 8 == 0 || (k - 1) % 8 == 0 || k > 57) {
                                        sum += 2;
                                    } else {
                                        sum++;
                                    }
                                    k -= 9;
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (sum > max) {
                    max_i = i;
                    max = sum;
                }
            }
        }
        this.cell = max_i;
    }
}
