import java.util.Random;

/**
 * creates a Deck object, a deck is an array of 52 individual card objects
 */
public class Deck {
    private Card[] deck;
    private Card[] dealt;

    /**
     * constructs a Deck object and fills it with 52 unique cards, then shuffles
     */
    public Deck(){
        this.deck = new Card[52];
        int curr = 0;
        for(int rank = 1; rank <= 13; rank++){ //fills deck with unique cards
            deck[curr++] = new Card(rank, 1);
            deck[curr++] = new Card(rank, 2);
            deck[curr++] = new Card(rank, 3);
            deck[curr++] = new Card(rank, 4);
        }
        shuffle(); //randomize order
    }
    /**
     * randomizes elements of the deck array using the Durstenfeld-Fisher-Yates algorithm
     * this method is called on during the constucting of a deck object
     */
    public void shuffle(){
        Random rand = new Random();
        for(int i = deck.length -1; i > 0; i--){
            int index = rand.nextInt(i + 1);
            Card temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;
        }
    }
    /**
     * this function removes the first card from the Deck array by copying all other cards onto a new
     * array newCards and then assigning that to the deck. If the deck is empty Draw draws 52 unique cards
     * again and shuffles
     * @return deck - an array of cards minus the drawn card
     */
    public Card draw(){

        if(isEmpty() == true){  //if deck is empty create new Deck and reshuffle
            deck = new Card[52];
            int curr = 0;
            for(int rank = 1; rank <= 13; rank++){
                deck[curr++] = new Card(rank, 1);
                deck[curr++] = new Card(rank, 2);
                deck[curr++] = new Card(rank, 3);
                deck[curr++] = new Card(rank, 4);
            }
            shuffle();
        }
        Card card = deck[0];
        Card[] newCards = new Card[deck.length - 1];
        for(int i = 1; i < deck.length; i++){ //remove the first card of the deck
            newCards[i -1] = deck[i];
        }
        deck = newCards; //deck without top card
        return card;
    }
    /**
     * cardsRemaining returns an int amount representing the card amount left in the deck
     * @return int cardsRemaining
     */
    public int cardsRemaining(){
        int cardsRemaining = this.deck.length;

        return cardsRemaining;
    }

    /**
     * is empty returns true if the deck has a length of 0 and false otherwise
     * @return boolean
     */
    public boolean isEmpty(){
        if(this.deck.length == 0){
           return true;
        }
        return false;
    }
}
