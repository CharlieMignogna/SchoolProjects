/**
 * creates a Hand object, which is an array of Card objects of a specified size drawn
 * from the deck object
 */
public class Hand {
    private Card[] hand;
    private int size;
    private Deck deck;

    /**
     * constructs a hand object, size of hand array determined by int Size, Size amount of cards
     * are drawn from the passed in deck and added to hand
     * @param deck -- a passed in deck in which cards are drawn from
     * @param size -- an int representing the amount of cards to be drawn to fill the hand
     */
    public Hand(Deck deck, int size){
        this.deck = deck;
        this.size = size;
        this.hand = new Card[size];
        for(int i = 0; i < size; i++){  //draw hand of size amount
            hand[i] = deck.draw();
        }
    }

    /**
     * getSize returns the size of the hand array
     * @return size
     */
    public int getSize(){return this.size;}

    /**
     * get returns the Card at hand index i, if i will be out of range get prints "Invalid hand index", if
     * i will be null get returns null
     * @param i
     * @return Card -- returns the Card at hand index i
     */
    public Card get(int i){
        if(i >= hand.length || i < 0){
            System.out.println("Invalid hand index!");
            return(hand[0]);
        }

        if(hand[i] == (null)){ //if null return first card of hand
            return hand[0];
        }

        return hand[i];
    }

    /**
     * remove takes in a Card, searches a hand for that card and if it is found removes it from the
     * hand array and returns true or false depending on if the Card is in the array
     * @param card -- the passed in card to find in the Hand
     * @return boolean FoundCard -- true if card is in array, false if not
     */
    public boolean remove(Card card){
        boolean foundCard = false;
        for(int i = 0; i < hand.length; i++){ //if card is null return false
            if(hand[i] == null){
                return false;
            }
            if(hand[i].equals(card)){ //if card found return true
                foundCard = true;
                //break;
            }
            if(foundCard){
                Card[] newHand = new Card[hand.length];
                int index = 0;
                for(int j = 0; index < hand.length; index++){ //remove card from hand and draw a replacement
                    if(hand[index] == null){ // if null draw new card
                        deck.draw();
                        return false;
                    }
                    if(!hand[index].equals(card)){ //if card is not found card add to new hand
                        newHand[index] = hand[index];
                        index++;
                    }
                    if(hand[index].equals(card)){ //if card is found card replace it
                        newHand[index] = deck.draw();
                        index++;
                    }
                    hand = newHand; // assign new hand back to hand
                }
            }
        }
        return foundCard;
    }
}
