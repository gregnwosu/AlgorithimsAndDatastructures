package datastructures.unionfind;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 07/02/13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public class ForestUF extends UF<Integer> {

    public ForestUF(int N) {
        id = new Integer[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;

        }
    }

    @Override
    public Integer find(int p) {
        if (p==id[p])
            return p;
        return find(id[p]);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void union(int p, int q) {
        id[find(p)] = id[find(q)];
    }
}
