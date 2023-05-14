/**
 * AI is the parent class to 2 AI subclasses, AI plays the first valid card in a Hand
 * this sets a baseline strategy for the subclasses to expand upon
 */
public class AI {
    /**
     * getPlay iterates through a Hand and returns the first valid Card to be played(refrencing the
     * topCard of CardPile), if no cards in Hand are playable getPlay returns null
     * @param hand -- the passed in Hand to be searched for a valid card
     * @param cardPile -- the passed in CardPile that getPlay refrences to find a valid play
     * @return Card -- returns the first valid Card, if no valid cards returns null
     */
    public Card getPlay(Hand hand, CardPile cardPile){
        for(int i = 0; i < hand.getSize() - 1; i++){  //plays first valid card
            if(cardPile.canPlay(hand.get(i ))){
                return hand.get( i );
            }
        }
        return null; //null if no valid Cards
    }

    /**
     * toString overrides the toString method to return the name of current AI
     * @return -- "Random Card AI"
     */
    public String toString(){
        return("Random Card AI");
    }
}
