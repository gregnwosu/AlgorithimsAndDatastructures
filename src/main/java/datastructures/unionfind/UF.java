package datastructures.unionfind;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 06/02/13
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public abstract class UF<T> {

    T[] id;
    int count;




    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public abstract T find(int p);

    public abstract void union(int p, int q);

    /*public static void main (String[] arg){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        UF uf = null;
        while (sc.hasNextInt()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (uf.connected(p,q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
    }*/
}
