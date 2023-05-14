/**
 * Author: Charlie Mignogna
 *
 * The HuffmanNode class represents a binary node, containing data and two pointers to a zero and one
 * children, these nodes can be either internal nodes(no data, doesn't point to any nulls) or leaf nodes
 * (data and no pointers)
 */
public class HuffmanNode {
    private HuffmanNode zero;
    private HuffmanNode one;
    private Character data;

    /**
     * constructs a HuffmanNode with zero and one pointers and null data (internal)
     * @param zero -- the HuffmanNode which is the left decendant  of this node
     * @param one -- the Huffaman node which is the right decendant of this node
     */
    public HuffmanNode(HuffmanNode zero, HuffmanNode one){
        this.zero = zero;
        this.one = one;
        this.data = null;
    }

    /**
     * Constructs a HuffmanNode with nul pointers and a character being stored in data (leaf)
     * @param data -- the character to be stored in this leaf node
     */
    public HuffmanNode(Character data){
        this.zero = null;
        this.one = null;
        this.data = data;
    }

    /**
     * returns zero decendent of this node, if null returns null
     * @return HuffmanNode -- zero or null
     */
    public HuffmanNode getZero(){
        if(zero == null){
            return null;
        }
        return zero;
    }

    /**
     * getOne returns the One decendent of this node
     * @return HuffmanNode -- One if not null, otherwise null
     */
    public HuffmanNode getOne(){
        if(one == null){
            return null;
        }
        return one;
    }

    /**
     * getData returns the data being held in a node
     * @return data -- Character
     */
    public Character getData(){
        return data;
    }

    /**
     * setData sets the data to the passed in data
     * @param data
     */
    public void setData(Character data){
        this.data = data;
    }

    /**
     * sets the zero decendent to the passed in node
     * @param zero
     */
    public void setZero(HuffmanNode zero){
        this.zero = zero;
    }

    /**
     * sets the one decendant to the passed in node
     * @param one
     */
    public void setOne(HuffmanNode one){
        this.one = one;
    }

    /**
     * check if a node is a leaf
     * @return boolean -- true if the node is a leaf, false if internal or invalid
     */
    public boolean isLeaf(){
        if(data != null && zero == null && one == null){
            return true;
        }
        return false;
    }

    /**
     * checks if a node is internal
     * @return boolean -- true if the node is internal, if not returns false
     */
    public boolean isInternal(){
        if(data == null && one != null && zero != null){
            return true;
        }
        return false;
    }

    /**
     * isValidNode checks a node for being internal or a leaf node, if it is one of these two then
     * the node is valid. If the node is not then it is an invalid node and false is returned
     * @return boolean -- true if node is internal or leaf, otherwise false
     */
    public boolean isValidNode(){
        if(isInternal()){
            return true;
        }
        if(isLeaf()){
            return true;
        }
        return false;
    }

    /**
     * isValidTree checks a node(root node usually but thats not defined here) if the node is a leaf, isValidTree returns true
     * if the node is internal then isValidTree recursively calls and checks the internal nodes children. If the node is
     * neither an internal nor leaf node isValid tree returns false
     * @return boolean -- true if all recursive checks are true(valid tree), false if there are invalid nodes
     */
    public boolean isValidTree(){
        //leaf node
        if(data != null && zero == null && one == null){
            return true;
        }
        //internal node
        if(one != null && zero != null){
            //recursive left & right calls
            return one.isValidTree() && zero.isValidTree();
        }
        //not valid internal or leaf node
        return false;
    }
}
