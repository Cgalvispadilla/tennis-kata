
public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            scorePlayer1++;
        }
        if (playerName.equals(player2Name)) {
            scorePlayer2++;
        }
    }

    public String getScore() {
        String score = "";
        if (equalsScore()) {
            score = equalScore();
        } else if (scoreWinner()) {
            score = moveScore(scorePlayer1,scorePlayer2);
        } else {
                score = scorePlayer(scorePlayer1)+"-"+ scorePlayer(scorePlayer2);
        }
        return score;
    }

    private boolean scoreWinner() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private boolean equalsScore() {
        return scorePlayer1 == scorePlayer2;
    }

    private String moveScore(int scorePlayer1, int scorePlayer2) {
        int minusResult = scorePlayer1 - scorePlayer2;
        switch (minusResult){
            case 1:
                return advantagePlayer(this.player1Name);
            case -1:
                return advantagePlayer(this.player2Name);
            default:
                return playerWin(minusResult);
        }
    }

    private String advantagePlayer(String playerName) {
        return "Advantage " + playerName;
    }


    private String playerWin(int minusResult) {
        return minusResult >= 2?"Win for " + this.player1Name:"Win for " + this.player2Name;
    }

    private String equalScore() {
        switch (scorePlayer1) {
            case 0:
                return   "Love-All";
            case 1:
                return   "Fifteen-All";
            case 2:
                return  "Thirty-All";
            default:
                return   "Deuce";
        }
    }

    private String scorePlayer(int scorePlayer) {
        switch (scorePlayer) {
            case 0:
                return  "Love";
            case 1:
                return  "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}
