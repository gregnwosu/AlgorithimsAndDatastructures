package datastructures;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 27/03/13
 * Time: 20:54
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTree<K extends Comparable<K>,V> {

    Node<K,V> root;



    public V get(final K key){
        Node<K,V> x = root;
        while( x != null){
            final int compVal = key.compareTo(x.key);
            if (compVal < 0) x = x.left;
            else
            if (compVal > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void put(final K key , final V value){
        root = put(root, key, value) ;
    }

    private Node<K,V> put(final Node<K,V> x, final K key, final V value) {
        if (x == null) return new Node (key, value);
        final int compVal  = key.compareTo(x.key);
        if (compVal < 0 ){
            x.left = put(x.left, key, value);
        }else
        if (compVal > 0){
            x.right = put(x.right, key , value);

        }
        else{
            x.value = value;
        }
        return x;
    }

    public K floor (final K key){
        Node<K,V> x = floor(root, key);
        return(x== null )?null:x.key;
    }



    private Node<K,V> floor(final Node<K,V> x, final K key) {
        if (x==null)return null;

        final int compValue = key.compareTo(x.key);
        if (compValue == 0) return x;
        final boolean currentNodeGreaterThanKey = compValue < 0;
        if (currentNodeGreaterThanKey){
            return floor(x.left, key);
        }
        //currentNodeIsLess than Key need to search right subtree

        final Node t = floor(x.right, key);
        //if there are any on the right that satisfy floor return them , otherwise return current node
         return t!=null?t : x;
    }

    public Iterable<K> keys(){
        Queue<K>q = new ArrayDeque<K>();
        inorder(root,q);
        return q;

    }

     void inorder(final Node<K,V> x, final Queue<K> q) {
        if (x==null)return;
        inorder(x.left, q);
        q.offer(x.key);
        inorder(x.right,q);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(final Node x) {
        if (x.left ==null)  return x.right;
        x.left = deleteMin(x.left);
//        x.count = 1+ size(x.left)+size(x.right);
        return x;
    }


    public void delete(final K key){
        root = hibbardDelete(root, key);
    }

    private Node hibbardDelete( Node<K,V> x, K key) {
             if (x==null) return null;
        final int compareValue = key.compareTo(x.key);
        if (compareValue < 0) x.left = hibbardDelete(x.left, key);
        else if (compareValue >0)  x.right = hibbardDelete(x.right, key);
        else{
            if (x.right==null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
//                            x.count = size(x.left) + size(x.right)+1;
        return x;

    }

    public Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }
}
