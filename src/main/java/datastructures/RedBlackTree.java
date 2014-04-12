package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 03/04/13
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */
public class RedBlackTree<K extends Comparable<K>,V> extends BinaryTree{
    private static final boolean BLACK = false;
    private static final boolean RED = true;
    public   boolean isRed(RBNode x){
        return x != null && x.colour == RED;
    }
    private class RBNode extends Node<K,V>{

        private  boolean colour;

        RBNode(K key , V val, boolean colour){
            super(key, val);
            this.colour = colour;
        }



    }

    private RBNode rotateLeft(RBNode h){
        RBNode x = (RBNode) h.right;
        assert isRed(x);
        h.right = x.left;
        x.left = h;
        x.colour = h.colour;
        h.colour = RED;
        return x;
    }private RBNode rotateRight(RBNode h){
        RBNode x = (RBNode) h.left;
        assert isRed(x);
        h.left = x.right;
        x.right = h;
        x.colour = h.colour;
        h.colour = RED;
        return x;
    }

    private void flipColors(RBNode h){
        h.colour = RED;
        ((RBNode)h.left).colour=BLACK;
        ((RBNode)h.right).colour=BLACK;
    }

    public void putRB(final K key , final V value){
        root = putRB((RBNode)root, key, value) ;
    }
    private RBNode putRB(RBNode h , K key , V val){
        if (h == null) {return new RBNode(key , val , RED); }
        int cmp =key.compareTo(h.key);
        {
           final RBNode left = (RBNode) h.left;
           final RBNode right = (RBNode) h.right;
           if (cmp < 0) h.left = putRB(left, key, val);
           else if (cmp >0) h.right = putRB(right, key,val);
           else if (cmp ==0) h.value = val;
        }

        if (isRed((RBNode) h.right) && !isRed((RBNode)h.left)) h = rotateLeft(h);
        if (isRed((RBNode) h.left)  && isRed((RBNode) h.left.left)) h = rotateRight(h);
        if (isRed((RBNode) h.right) && isRed((RBNode) h.left)) flipColors(h);
        return h;
    }            }
