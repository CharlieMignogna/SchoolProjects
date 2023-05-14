/**
 * creates a Card object using the rank and suit variables represtenting a playing card
 *
 */

public class Card {
    private int rank;
    private int suit;

    /**
     * constructs a Card object if the passed in rank or suit are out of range prints INVALID CARD
     * @param rank -- int representing the number value on the card 1 = ace 11= jack and so on
     * @param suit -- int representing the suit of the card, 1 = spades 2 =hearts and so on
     */
    public Card(int rank, int suit){
        if(rank > 0 && rank < 15){
            this.rank = rank;
        }
        else{
            this.rank = 0; //out of range
            System.out.println("INVALID CARD");
        }
       if(suit > 0 && suit < 5){
           this.suit = suit;
       }
       else{
           this.suit = 0; //out of range
           System.out.println("INVALID CARD");
       }

    }

    /**
     * returns the rank of a Card
     * @return rank
     */
    public int getRankNum(){
        return rank;
    }

    /**
     * returns a string representing a Cards rank
     * @return returnString
     */
    public String getRankName(){
        String returnString = "";
        if(rank == 1){
            returnString = "Ace";
        }
        if(rank == 2){
            returnString = "Two";
        }
        if(rank == 3){
            returnString = "Three";
        }
        if(rank == 4){
            returnString = "Four";
        }
        if(rank == 5){
            returnString = "Five";
        }
        if(rank == 6){
            returnString = "Six";
        }
        if(rank == 7){
            returnString = "Seven";
        }
        if(rank == 8){
            returnString = "Eight";
        }
        if(rank == 9){
            returnString = "Nine";
        }
        if(rank == 10){
            returnString = "Ten";
        }
        if(rank == 11){
            returnString = "Jack";
        }
        if(rank == 12){
            returnString = "Queen";
        }
        if(rank == 13){
            returnString = "King";
        }
        return returnString;
    }

    /**
     * returns the Suit name of a Card object
     * @return returnString -- suit name
     */
    public String getSuitName(){
        String returnString = "";
        if(suit == 1){
            returnString = "Spades";
        }
        if(suit == 2){
            returnString = "Hearts";
        }
        if(suit == 3){
            returnString = "Clubs";
        }
        if(suit == 4){
            returnString = "Diamonds";
        }
        return returnString;
    }

    /**
     * returns a string representation of a Card in rank of suit format
     * @return rank + of + suit -- i.e Card(13,2) =  King of Hearts
     */
    public String toString(){
        if(suit == 0 || rank == 0){ // if invalid card print ace of spades
            return("Ace of Spades");
        }
        return(getRankName() + " of " + getSuitName());
    }

    /**
     * returns a boolean representing if two Card objects are equal
     * @param o
     * @return boolean - true if equal, false otherwise
     */
    public boolean equals(Object o){

        if(o == this){
            return true;
        }
        if(!(o instanceof Card)){
            return false;
        }
        Card c = (Card) o;

        return Integer.compare(rank, c.rank) == 0 && Integer.compare(suit, c.suit) == 0;
    }
}
