/**
 * the CardPile class represents the played cards, more specifically the most recent played card
 * the topCard is used to play an actual uno war match
 */
public class CardPile {
    private Card topCard;
    private int size = 1;

    /**
     * constructs a CardPile, assigning the passed in topCard as the top of the pile
     * @param topCard - the first topCard
     */
    public CardPile(Card topCard){
        this.topCard = topCard;
    }

    /**
     * canPlay checks if the passed in card is a valid move, to be valid the card must be the same or
     * higher rank than the top card or the same suit as the topCard
     * @param card -- the card play that is being validated
     * @return boolean canPlay - true if valid move, false otherwise
     */
    public boolean canPlay(Card card){
        boolean canPlay = false;
        if(card == null){ // if card is null, return false
            return false;
        }
        if(card.getRankNum() >= this.topCard.getRankNum() || card.getSuitName().equals(topCard.getSuitName())){ //if valid move return true
            canPlay = true;
        }
        return canPlay;
    }

    /**
     * this method plays the card, it adds the card to the CardPile and increases the CardPile size
     * @param card -- the card a player wishes to play
     */
    public void play(Card card) {
        if (canPlay(card)) { //play card, assigning it as the new topCard
            this.topCard = card;
            this.size ++;
        }
        else{
            System.out.println("illegal move detected");
        }
    }

    /**
     * getNumCards returns the size of cards in the CardPile
     * @return size
     */
    public int getNumCards(){return size;}

    /**
     * getTopCard returns the current topCard of the CardPile;
     * @return topCard
     */
    public Card getTopCard(){return topCard;}
}
