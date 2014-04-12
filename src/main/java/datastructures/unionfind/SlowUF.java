package datastructures.unionfind;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 07/02/13
 * Time: 13:26
 * To change this template use File | Settings | File Templates.
 */
public class SlowUF extends UF<Integer> {
    public SlowUF(int N) {
        count =N;
        id =new Integer[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
    }


    @Override
    public Integer find(int p) {
        return id[p];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void union(int p, int q) {
        final int pid = id[p];
        final int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            final boolean shouldReplaceVal = pid == id[i];
            if (shouldReplaceVal){
            }

        }
    }
}
