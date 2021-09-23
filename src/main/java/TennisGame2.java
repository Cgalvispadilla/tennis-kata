
public class TennisGame2 implements TennisGame
{
    public int pointPlayer1 = 0;
    public int pointPlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (pointPlayer1 == pointPlayer2) score = equalsScore(pointPlayer1);
        else if (moveScoreWinner()) {
            score = advantagePlayers(pointPlayer1, pointPlayer2);
        } else {
            score = moveScore(pointPlayer1) + "-" + moveScore(pointPlayer2);
        }
        return score;
    }

    private boolean moveScoreWinner() {
        return pointPlayer1 >= 4 || pointPlayer2 >= 4;
    }

    private String advantagePlayers(int pointPlayer1, int pointPlayer2) {
        int minusResult = pointPlayer1 - pointPlayer2;
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
    private String equalsScore(int pointPlayer){
        String score[]={"Love-All","Fifteen-All","Thirty-All","Deuce","Deuce"};
        return score[pointPlayer];
    }
    private String moveScore(int pointPlayer){
        String score[]={"Love","Fifteen", "Thirty", "Forty"};
        return score[pointPlayer];
    }
    public void P1Score(){
        pointPlayer1++;
    }

    public void P2Score(){
        pointPlayer2++;
    }

    public void wonPoint(String player) {
        if (player.equals(this.player1Name))
            P1Score();
        else
            P2Score();
    }
}