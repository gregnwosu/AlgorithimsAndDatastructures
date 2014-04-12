package datastructures.unionfind;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 08/02/13
 * Time: 18:30
 * To change this template use File | Settings | File Templates.
 */
public class WeightedForest extends ForestUF {
    final Integer[] sz;

    public WeightedForest(int N) {
        super(N);
        this.sz = new Integer[N];
        for (int i = 0; i < sz.length; i++) {
            sz[i] =1;

        }
    }

    @Override
    public void union(final int a, final int b) {
        int childroot = find(a);
        int parentroot = find(b);
        if (sz[childroot] > sz[parentroot]){
            id[parentroot] = id[childroot];
            sz[childroot] += sz[parentroot];
        }else{
            id[childroot] = id[parentroot];
            sz[parentroot] += sz[childroot];
        }
    }
}
