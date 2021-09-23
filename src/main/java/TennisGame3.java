
public class TennisGame3 implements TennisGame {
    
    private int pointPlayer2;
    private int pointPlayer1;
    private String namePlayer1;
    private String namePlayer2;

    public TennisGame3(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public String getScore() {
        if (movePointsPlayers()) {
            return scorePlayers();
        } else {
            if (equalsPointsPlayers(pointPlayer1, pointPlayer2))
                return "Deuce";
            return advantageOrWinnerPlayer();
        }
    }

    private boolean equalsPointsPlayers(int pointPlayer1, int pointPlayer2) {
        return pointPlayer1 == pointPlayer2;
    }

    private String advantageOrWinnerPlayer() {
        return (equalsPointsPlayers((pointPlayer1 - pointPlayer2)*(pointPlayer1 - pointPlayer2), 1)) ? advantagePlayer() : winnerPlayer();
    }

    private String winnerPlayer() {
        return "Win for " + namepPlayerWinnerOAdvantage();
    }

    private String advantagePlayer() {
        return "Advantage " + namepPlayerWinnerOAdvantage();
    }

    private String namepPlayerWinnerOAdvantage() {
        return pointPlayer1 > pointPlayer2 ? namePlayer1 : namePlayer2;
    }

    private String scorePlayers() {
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (pointPlayer1 == pointPlayer2) ?  p[pointPlayer1] + "-All" :  p[pointPlayer1] + "-" + p[pointPlayer2];
    }

    private boolean movePointsPlayers() {
        return limitMovePoints() && !(pointPlayer1 + pointPlayer2 == 6);
    }

    private boolean limitMovePoints() {
        return pointPlayer1 < 4 && pointPlayer2 < 4;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.namePlayer1))
            this.pointPlayer1 += 1;
        else
            this.pointPlayer2 += 1;
        
    }

}
