/**
 * BiggestCardAi extends AI and plays the largest valid card(according to CardPile's
 * topCard) in a Hand array
 */
public class BiggestCardAI extends AI{
    /**
     * this getPlay override iterates through the passed in hand and returns the largest value
     * playable card, if no card is playable then getPlay returns null
     * @param hand -- the passed in Hand to be searched for a valid card
     * @param cardPile -- the passed in CardPile that getPlay refrenced to find a valid play
     * @return Card -- the largest playable Card in the Hand array or null if no playble cards found
     */
    public Card getPlay(Hand hand, CardPile cardPile){
        Card largest = hand.get(0); //assign largest to first Card
        if(largest == null){
            return null;
        }
        for(int i =1; i < hand.getSize(); i++){
            if(hand.get(i) == null){
                return null;
            }
            if(hand.get(i).getRankNum() > largest.getRankNum() && cardPile.canPlay(hand.get(i))){
                largest = hand.get(i);  // assign largest to largest valid card

            }
        }
            return largest;
    }
    /**
     * overides the toString method and returns this AI's name
     * @return "Biggest Card AI"
     */
    public String toString(){
        return("Biggest Card AI");
    }
}

