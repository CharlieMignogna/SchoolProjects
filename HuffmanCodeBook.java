/**
 * Author: Charlie Mignogna
 *
 * HuffmanCodeBook creates a dictionary(hashmap) of Characters(key) and BinarySequences(value)
 * any number of character sequence pairs can be passed in
 */
public class HuffmanCodeBook {
    private BinarySequence sequence;
    private Character letter;
    private dict characterBinarySequencedict;

    /**
     * Constructs a HuffmanCodeBook, setting the dict length to 0, this.sequence to the passed in binary sequence, and
     * letter to null
     */
    public HuffmanCodeBook(){
        this.sequence = new BinarySequence();
        this.letter = 0;
        this.characterBinarySequencedict = new dict(0);
    }

    /**
     * addSequence takes in a Character BinarySequence pair, and adds them to the dictionary datastructure
     * @param c -- a character representing the letter being stored
     * @param seq -- a binary sequence representing the letter being stored
     */
    public void addSequence(Character c, BinarySequence seq){
        characterBinarySequencedict.put(c,seq);
    }

    /**
     * Contains returns a boolean value. true if the passed in Character is in the dictionary, false if otherwise
     * @param letter -- the Character to be found in the dictionary
     * @return boolean -- true if found false if not
     */
    public boolean contains(Character letter){

        if(characterBinarySequencedict.containsKey(letter)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * getSequence takes in a Character, and returns the binarySequence associated with it,
     * first checking if the character is in the dictionary.
     * @param c -- the passed in Character in which we want the binarySequence
     * @return BinarySequence -- the binarySequence associated with the passed in key(character)
     */
    public BinarySequence getSequence(Character c){
        if(characterBinarySequencedict.containsKey(c)){
            return characterBinarySequencedict.getSeq(c);
        }
        else{
            return null;
        }
    }

    /**
     * getCharArr returns an array of all characters in the dictionary
     * this method is used in the HuffmanCodeTree class to iterate over the values in
     * the CodeBook
     * @return Character[] -- an array of all Characters in the Codebook
     */
    public Character[] getCharArr(){
        return characterBinarySequencedict.getCharacters();
    }

    /**
     * The encode method takes in a string and returns the binary sequences associated with each
     * character, encoding it.
     * @param S -- the string to be encoded
     * @return BinarySequence -- the encoded string
     */
    public BinarySequence encode(String S){
        Character[] charArray = new Character[S.length()];  //new char array of s.length
        BinarySequence seq = new BinarySequence();         // new binarySequence(this will be the encoded string)
        //loop over the string and copy each char into a char array
        for(int i = 0; i < S.length(); i++){
            charArray[i] = S.charAt(i);
        }
        //loop over the charArray, calling the getSeq method from the dict and appending each character's sequence to the binary sequence to be returned
        for(int i = 0; i < charArray.length; i++){
            seq.append(characterBinarySequencedict.getSeq(charArray[i]));
        }
        return seq;
    }

    /**
     * This method is used to check if the codebook has all the characters and sequences
     * to encode text, iterating through the text and checking if each char is in this
     * codeBook
     * @param s -- the text being checked
     * @return boolean -- false if a character is detected that is not in the codebook, true otherwise
     */
    public boolean containsAll(String s){
        char[] charArray = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            charArray[i] = s.charAt(i);
        }
        //iterates over charArray(the string but as an array of Characters) calling containsKey on each element
        for(int i = 0; i < charArray.length; i++){
            if(!characterBinarySequencedict.containsKey(charArray[i])){
                return false;
            }
        }
        return true;
    }

    /**
     *  dict is a non-generic Dictionary (or hashmap), it contains 2 arrays -- keys(Character[])
     *  and values (BinarySequence[]), it has dynamic length(once arrays are full data is copied over to
     *  new arrays with *2 length
     */
    public class dict {
        private Character[] keys;
        private BinarySequence[] values;
        private Integer count = 1;

        /**
         * This constructor takes in an int representing length and creates the arrays, the length of these
         * arrays are set to length, and if a passed in length is <= 0 length is set to one
         * @param length -- the desired length for the arrays
         */
        public dict(int length){
            if (length <= 0) {
                this.keys = new Character[1];
                this.values = new BinarySequence[1];
            } else {
                this.keys = new Character[length];
                this.values = new BinarySequence[length];
            }
        }

        /**
         * getCharacters iterates through the values array(binarySequences) using the getChar method on
         * each non-null index to get the key associated and adds it to an array of characters
         * @return -- Character[] charArr -- an array of every non-null character in the dict
         */
        public Character[] getCharacters(){
            Character[] charArr = new Character[keys.length];
            //iterating through values instead of keys so I can call getChar and get the associated key
            for(int i = 0; i < values.length; i++){
                if(values[i] != null) {
                    charArr[i] = getChar(values[i]);
                }
            }
            return charArr;
        }

        /**
         * getSeq iterates through the keys array comparing the data to the passed in character,
         * if the character is in the keys array then this method returns the value associated with it
         * @param key -- a character, that if in the keys array has an associated binary sequence
         * @return binarySequence values[i] -- the value associated with the passed in character
         * null if no match
         */
        public BinarySequence getSeq(Character key) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i].equals(key)) {
                    return values[i];
                }
            }
            return null;
        }

        /**
         * getChar iterated through the values array, comparing the passed in sequence to each element,
         * if the sequence is in the values array then the associated key is returned
         * @param seq -- the BinarySequence associated with a character (if it's in the array)
         * @return Character keys[i] -- the Character associated with the binary sequence
         */

        public Character getChar(BinarySequence seq){
            for (int i = 0; i < values.length; i++){
                if(values[i] == (seq)){
                    return keys[i];
                }
            }
            return null;
        }

        /**
         * isFull return true if the keys and values have no more nulls(full)
         * @return boolean -- false if there are nulls in the arrays (not full), otherwise true if no more nulls
         */
        public boolean isFull(){
            for(int i = 0; i < keys.length; i++){
                if(keys[i] == null && values[i] == null){
                    return false;
                }
            }
            return true;
        }

        /**
         * containsKey iterates over they keys array and returns true or false depending on if the
         * passed in key is in the array
         * @param key -- the key to compare to the keys array
         * @return boolean -- true if the passed in key is in the keys array, false if it is not
         */
        public boolean containsKey(Character key) {
            for (int i = 0; i < keys.length; i++) {
                if (key.equals(keys[i])) { // was ==
                    return true;
                }
            }
            return false;
        }

        /**
         * Put adds key value pairs to each array, if the key already exists then it replaces the existing
         * key and value(keeping the same index but that isnt too important) if the arrays are full then
         * the data is copied over to new arrays of length (length*(2*count)) (doubled)
         * @param key -- the Character to be added to the keys array
         * @param value -- the BinarySequence associeated with the Character to be put in the values array
         */
        public void put(Character key, BinarySequence value) {
            //if the key is already in the keys array
            if (containsKey(key)) {
                for(int i = 0; i < keys.length; i++){
                    if(keys[i].equals(key)){  //was ==
                        values[i] = value;
                        keys[i] = key;
                    }
                }
            }
            // if the key is not in the array and the array is not full
            if(!containsKey(key) && !isFull()){
                for(int i = 0; i < keys.length; i++){
                    if(keys[i] == null){
                        keys[i] = key ;
                        values[i] = value;
                        break;
                    }
                }
            }
            //if the array is full
            if(isFull()){
                //create new arrays (doubled length)
                Character[] tempKey = new Character[keys.length *(2*count)];
                BinarySequence[] tempVals = new BinarySequence[values.length*(2*count)];
                //copy the data to temp arrays
                for(int i = 0; i < keys.length; i++){
                    tempKey[i] = keys[i];
                    tempVals[i] = values[i];

                }
                //set the key and value arrays to the new temp arrays
                keys = tempKey;
                values = tempVals;
                //add the key value pair (dont have to worry about checking if its full obviously)
                for( int i = 0; i < keys.length + 1; i++){
                    if(keys[i] == null){
                        keys[i] = key;
                        values[i] = value;
                        break;
                    }
                }
            }

        }
    }

}
