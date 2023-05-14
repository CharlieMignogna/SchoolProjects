/**
 * UnoWarMatch runs the actual playing of the game, using 2 AI, a deck, 2 hands, a cardpile.
 * UnoWarMath logs which AI won each round/game and generates a win rate
 */
public class UnoWarMatch {
    private AI ai1;
    private AI ai2;

    /**
     * Constructs the 2 AI playing the game
     * @param ai1 -- assigned to 1st AI
     * @param ai2 -- assigned to 2nd AI
     */
    public UnoWarMatch(AI ai1, AI ai2){
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * playGame plays unoWar until one AI has reached 10 pts, playGame creates all objects
     * needed for a game of Uno War and returns true if AI1 wins and False if AI2 wins. the AI
     * who won the previous round goes first on the next and only valid moves can be played.
     * once an AI is out of moves then the other gets a point and the next round is started.
     * first AI to 10 points wins and the game stops.
     * @return boolean winner -- True is ai1 and false is ai2
     */
    public boolean playGame(){
        boolean winner = false;
        Deck deck = new Deck();
        Hand ai1Hand = new Hand(deck, 5);
        Hand ai2Hand = new Hand(deck, 5);
        Card curr1 = new Card(1,1);
        AI currAI = new AI();
        AI currOP = new AI();
        int currOPScore = 0;
        Hand currHand = new Hand(deck, 0);
        int ai1Score = 0;
        int ai2Score = 0;
        CardPile cardPile = new CardPile(deck.draw());
        for(int i = 0; i < 21; i++){
            if(ai1Score == 10){  //if ai1 reaches 10 points return true
                winner = true;
            }
            if(ai2Score == 10){ //if ai2 reaches 10 points return false
                winner = false;
            }
            if(i % 2 == 0){ //if even ai1 plays
                currAI = ai1;
                currHand = ai1Hand;
                currOP = ai2;
            }
            else{  //if odd ai2 plays
                currAI = ai2;
                currHand = ai2Hand;
                currOP = ai1;
            }
            if(!cardPile.canPlay((currAI.getPlay(currHand, cardPile)))|| currHand.getSize() == 0){ //if no playable cards opponent get point
                currOPScore++;
            }
            else{
                cardPile.play(currAI.getPlay(currHand,cardPile)); //play card and remove it from hand, drawing new card
                if(currHand.getSize() > 0) {
                    currHand.remove(currAI.getPlay(currHand, cardPile));
                }
            }
            if(i % 2 == 0){ //assign points to ai1
                ai1 = currAI;
                ai1Hand = currHand;
                ai2Score = currOPScore;
            }
            else{ //assign points to ai2
                ai2 = currAI;
                ai2Hand = currHand;
                ai1Score = currOPScore;
            }

        }
        return winner;
    }

    /**
     * winRate runs a specified amount of games and logs how many times ai1 wins, this number is
     * then divided against the amount of games played to get a percentage of wins
     * @param trials -- the amount of games that will be played
     * @return winRate -- a double representing the percentage ai1 won
     */
    public double winRate(int trials){
        double winRate = 0;
        for(int i = 0; i < trials; i++) {  //play trials amount of games
            playGame();
            if (playGame()) {
                winRate++;
            }
        }
        return winRate/trials; //calculate and return win rate
    }


}
