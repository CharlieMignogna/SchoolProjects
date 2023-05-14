/**
 * this class holds the main function, in which each AI plays uno war 1000 times against each
 * other AI and itself and the win rates of all are printed to the screen
 */
public class Tournament {
    /**
     * all 3 AI are created and all play against each other and themselves 1000 times to generate
     * the win rates of each strategy
     */
    public static void main(String[] args){
        AI SMCard = new SmallestCardAI();
        AI BGCard = new BiggestCardAI();
        AI RandCard = new AI();
        UnoWarMatch warSB = new UnoWarMatch(SMCard, BGCard);
        UnoWarMatch warSS = new UnoWarMatch(SMCard, SMCard);
        UnoWarMatch warSR = new UnoWarMatch(SMCard, RandCard);
        UnoWarMatch warBS = new UnoWarMatch(BGCard, SMCard);
        UnoWarMatch warBB = new UnoWarMatch(BGCard, BGCard);
        UnoWarMatch warBR = new UnoWarMatch(BGCard, RandCard);
        UnoWarMatch warRS = new UnoWarMatch(RandCard, SMCard);
        UnoWarMatch warRB = new UnoWarMatch(RandCard, BGCard);
        UnoWarMatch warRR = new UnoWarMatch(RandCard, RandCard);

        System.out.println(SMCard.toString() + " VS " + RandCard.toString() + " win rate: " + warSR.winRate(1000));
        System.out.println(SMCard.toString() + " VS " + SMCard.toString() + " win rate: " + warSS.winRate(1000));
        System.out.println(SMCard.toString() + " VS " + BGCard.toString() + " win rate: " + warSB.winRate(1000));

        System.out.println(BGCard.toString() + " VS " + RandCard.toString() + " win rate: " + warBR.winRate(1000));
        System.out.println(BGCard.toString() + " VS " + SMCard.toString() + " win rate: " + warBS.winRate(1000));
        System.out.println(BGCard.toString() + " VS " + BGCard.toString() + " win rate: " + warBB.winRate(1000));

        System.out.println(RandCard.toString() + " VS " + RandCard.toString() + " win rate: " + warRR.winRate(1000));
        System.out.println(RandCard.toString() + " VS " + SMCard.toString() + " win rate: " + warRS.winRate(1000));
        System.out.println(RandCard.toString() + " VS " + BGCard.toString() + " win rate: " + warRB.winRate(1000));


    }
}
