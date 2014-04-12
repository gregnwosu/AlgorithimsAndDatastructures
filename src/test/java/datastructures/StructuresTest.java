package datastructures;


import org.junit.Test;
import sorts.MergeSort;

import java.util.ArrayDeque;
import java.util.Queue;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 11/03/13
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class StructuresTest {



    @Test
    public void shouldMergeSort(){
        System.out.println("Merge sort");
        Integer[] unsorted = new Integer[]{9,93,4,6,6};
       MergeSort.sort(unsorted);
        for(int i : unsorted){
            System.out.println(i);
        }
        assertEquals(Integer.valueOf(93),unsorted[4]);
    }



    @Test
    public void shouldBinaryTreeSort(){
        System.out.println("Binary Tree Sort");
        Integer[] unsorted = new Integer[]{9,93,4,6,6};
        BinaryTree<Integer,String> qs = new BinaryTree<Integer,String>();
        for (Integer i : unsorted){
            qs.put(i, i.toString());
        }

        Queue<Integer> q = new ArrayDeque<Integer>();
        qs.inorder(qs.root, q);


        final Integer[] results =  q.toArray(new Integer[]{});
        for (Integer result: results){
            System.out.println(result);
        }
        assertEquals(Integer.valueOf(93), results[3]);
    }@Test
    public void shouldRedBlackBinaryTreeSort(){
        System.out.println("Red Black Binary Tree Sort");
        Integer[] unsorted = new Integer[]{9,93,4,6,6};
        RedBlackTree<Integer,String> qs = new RedBlackTree<Integer,String>();
        for (Integer i : unsorted){
            qs.put(i, i.toString());
        }

        Queue<Integer> q = new ArrayDeque<Integer>();
        qs.inorder(qs.root, q);


        final Integer[] results =  q.toArray(new Integer[]{});
        for (Integer result: results){
            System.out.println(result);
        }
        assertEquals(Integer.valueOf(93), results[3]);
    }

    public void shouldHeapSort(){
        System.out.println("Heapsort");
        Integer[] unsorted = new Integer[]{9,93,4,6,6};
        BinaryHeap  <Integer> qs = new BinaryHeap<Integer>();
        qs.sort(unsorted);
        for(int i : unsorted){
            System.out.println(i);
        }
        assertEquals(Integer.valueOf(93),unsorted[4]);
    }
   /* @Test
    public void shouldHeapSink(){
        System.out.println("HeapSink");
        Character[] unsorted = new Character[]{2,93,6,4};
        BinaryHeap  <Character> qs = new BinaryHeap<Character>();
        qs.sink(1, unsorted);
        for(int i : unsorted){
            System.out.println(i);
        }
        assertEquals(Integer.valueOf(2),unsorted[3]);
    }*/
    @Test
    public void shouldHeapSwim(){
        System.out.println("HeapSwim");
        Character[] unsorted = new Character[]{'S','P', 'R', 'N', 'T', 'O','A', 'E','I','H','G'};
        BinaryHeap  <Character> qs = new BinaryHeap<Character>();
        qs.swim(5, unsorted);
        for(int i : unsorted){
            System.out.println((char)i);
        }
        assertArrayEquals(new Character[]{'T','S', 'R', 'N', 'P', 'O','A', 'E','I','H','G'}, unsorted);
    }
@Test
    public void shouldHeapSink(){
        System.out.println("HeapSink");
        Character[] unsorted = new Character[]{'T','H', 'R', 'P', 'S', 'O','A', 'E','I','N','G'};
        BinaryHeap  <Character> qs = new BinaryHeap<Character>();
        qs.sink(2, unsorted);
        for(int i : unsorted){
            System.out.println((char)i);
        }
        assertArrayEquals(new Character[]{'T','S', 'R', 'P', 'N', 'O','A', 'E','I','H','G'}, unsorted);
    }


}
