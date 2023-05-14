/**
 * Author: Charlie Mignogna
 *
 * HuffmanCodeTree represents a binary tree comprised of internal and leaf nodes(defined in HUffmanNode)
 * HuffmanCodeTree builds a valid binary tree using methods from HuffmanCodeBookk and HuffmanNode and can
 * be used to decode encoded text
 */
public class HuffmanCodeTree {
    private HuffmanNode root;

    /**
     * constructs a HuffmanCodeTree comprised of a single root node
     * @param root -- the passed in node representing to root of the tree
     */
    public HuffmanCodeTree(HuffmanNode root) {
        this.root = root;
    }

    /**
     * constructs a HuffmanCodeTree by taking in a HuffmanCodeBook, iterating over it using the getCharArr
     * method in the HuffmanCodeBook to get an iterable array of all the characters. This constructor then iterates
     * over the array of characters calling the put method on each one adding the Character and its sequence to the tree
     * (sequence is available through the getSequence method that is used on keys to return the associated value)
     * @param codeBook -- a HuffmanCodeBook with Characters and their binarySequences
     */
    public HuffmanCodeTree(HuffmanCodeBook codeBook) {
        HuffmanNode newRoot = new HuffmanNode(null, null);
        for (int i = 0; i < codeBook.getCharArr().length; i++) {
            if (codeBook.getCharArr()[i] != null) {
                put(codeBook.getSequence(codeBook.getCharArr()[i]), codeBook.getCharArr()[i]);
            }
        }
    }

    /**
     * isValid calls the recursive isValidTree method in HuffmanNode on the root node of a tree. The recursion
     * checks every subsequent node and if they all return true then this tree is valid
     * @return boolean -- true if the tree is valid, false if it is not
     */
    public boolean isValid() {
        return root.isValidTree();
    }

    /**
     * the put method adds a node to the BinaryTree. Sets a node "current" to the root node then iterates through the
     * passed in binary sequence. each index of the binarySequence represents a path of zeros and ones at the
     * end of which the associated character should be put. at each iteration the value of the binary sequence is checked
     * (false == zero)(true == one) and put updates current to traverse down the tree int the order or the given sequence,
     * if the child is null then an empty node is created and current is set to that new node(continuing its traversal)
     * and at the end of iterating over the sequence(reached to spot to add the leaf node) setData is called to add
     * the passed in character to the node
     * @param seq -- a binarySequence used to traverse the tree and add the data at the right spot
     * @param letter -- the data to be added as a leaf node(or to an existing leaf node)
     */
    public void put(BinarySequence seq, Character letter) {
        if(root == null){
            root = new HuffmanNode(null, null);
        }
        //set current to root
        HuffmanNode current = root;
        for (int i = 0; i < seq.size(); i++) {
            //if the sequence at i is a 0
            if (seq.get(i) == false) {
                //if no node exists at this point in the tree create an empty node here
                if (current.getZero() == null) {
                    //create new node as a child of current
                    current.setZero(new HuffmanNode(null, null));
                }
                //set current to its zero child
                current = current.getZero();

                //if the sequence at i is a 1
            } else if (seq.get(i) == true) {
                //create new node if no node exists at this point in tree
                if (current.getOne() == null) {
                    // create new node as a child of current
                    current.setOne(new HuffmanNode(null, null));
                }
                //set current to its one child
                current = current.getOne();
            }
        }
        //we can assume the current ended on a leaf node and set its data to letter
        current.setData(letter);
    }

    /**
     * decode iterates through the binarytree using a BinarySequence(like in the put method) and upon
     * reaching a leaf node decode appends the data at the leaf node to a StringBuilder, then
     * sets node to root to start the traversal at the top again for the next character
     * @param s -- the passed in binarySequence to decode
     * @return sb.toString() -- a string of all the decoded characters
     */
    public String decode(BinarySequence s){
        //set node to root
        HuffmanNode node = root;
        //create stringbuilder
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.size(); i++){
            //if sequence at i is a 1 then traverse down the right side(One child)
            if(s.get(i) == true){
                node = node.getOne();
            }
            // if sequence at i is 0 then traverse down the left side(zero child)
            if(s.get(i) == false){
                node = node.getZero();
            }
            //if a leaf node is reached append the data stored(Character) to the string builder and
            //set node back to root
            if(node.getData() != null){
                sb.append(node.getData());
                node = root;
            }
        }
        return sb.toString();
    }
}

