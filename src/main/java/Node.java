import com.sun.org.apache.regexp.internal.REDebugCompiler;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 23/04/13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
public class Node<K ,V>{
      K key;
      V value;
      Node<K,V> left;
      Node<K,V> right;

   Node(K key, V value) {
        this.key = key;
        this.value = value;
    }


}
