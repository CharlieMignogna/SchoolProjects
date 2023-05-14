/**
 * SmallestCardAi extends AI and plays the Smallest valid card(according to CardPile's
 * topCard) in a Hand array
 */
public class SmallestCardAI extends AI{
    /**
     * this getPlay override iterates through the passed in hand and returns the Smallest value
     * playable card, if no card is playable then getPlay returns null
     * @param hand -- the passed in Hand to be searched for a valid card
     * @param cardpile -- the passed in CardPile that getPlay refrences to find a valid play
     * @return Card -- the smallest value playable card or null
     */
    public Card getPlay(Hand hand, CardPile cardpile) {
        int num = 0;
        Card smallest1 = null;
        for (int h = 0; h < hand.getSize(); h++) { //assign smallest to the smallest value valid card
            if (cardpile.canPlay(hand.get(h))) {
                smallest1 = hand.get(h);
            }
        }
        Card smallest = smallest1;
        if(smallest == null){ //if smallest is null, return null
            return null;
        }
        for (int i = 1; i < hand.getSize(); i++) {
            if(hand.get(i) == null){
                return null;
            }
            if (hand.get(i).getRankNum() < smallest.getRankNum() && cardpile.canPlay(hand.get(i)) && cardpile.canPlay(smallest)) {
                smallest = hand.get(i);  //assign smallest to smallest value valid card
            }
        }
        return smallest;
    }

    /**
     * overides the toString method and returns this AI's name
     * @return "Smallest Card AI"
     */
    public String toString(){
        return("Smallest Card AI");
    }

}
