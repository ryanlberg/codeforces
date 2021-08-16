import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class D {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
    
        int size = fr.nextInt();
        int a_edges = fr.nextInt();
        int b_edges = fr.nextInt();
        
        Dsu a_dsu = new Dsu(size);
        Dsu b_dsu = new Dsu(size);

        Map<Integer, HashSet<Integer>> ag = new HashMap<>();
        Map<Integer, HashSet<Integer>> bg = new HashMap<>();

        for(int i = 1; i <= size; i++) {
            ag.put(i, new HashSet<Integer>());
            bg.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < a_edges; i++) {
            int p = fr.nextInt();
            int q = fr.nextInt();
            ag.get(p).add(q);
            ag.get(q).add(p);
            a_dsu.union(p, q);
        }

        for (int i = 0; i < b_edges; i++) {
            int p = fr.nextInt();
            int q = fr.nextInt();
            bg.get(q).add(p);
            bg.get(p).add(q);
            b_dsu.union(p, q);
        }

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for(int i = 1; i <= size; i++) {
            for(int j = i+1; j <= size; j++) {
                if(!ag.get(i).contains(j) && ! bg.get(i).contains(j)) {
                    if(!a_dsu.connected(i, j) && !b_dsu.connected(i, j)) {
                        ag.get(i).add(j);
                        ag.get(j).add(i);
                        bg.get(i).add(j);
                        bg.get(j).add(i);
                        
                        a_dsu.union(i, j);
                        b_dsu.union(i, j);
                        
                        ArrayList<Integer> cur_edge = new ArrayList<>();
                        cur_edge.add(i);
                        cur_edge.add(j);
                        ret.add(cur_edge);
                    }
                }
            }
        }

        out.write(ret.size()+ "\n");

        for(ArrayList<Integer> x : ret) {
            out.write(x.get(0) + " " + x.get(1) + "\n");
        }


    
        out.close();
    }


    static class Dsu {
        
        final int[] dsu;
        final int[] sz;

        public Dsu(int size) {
            dsu = new int[size+1];
            sz = new int[size+1];
            for(int i = 1; i <= size; i++) {
                sz[i] = 1;
                dsu[i] = i;
            }
        }

        public int root(int i) {
            while(dsu[i] != i) {
                dsu[i] = dsu[dsu[i]];
                i = dsu[i]; 
            }
            return i;
        }

        public boolean connected(int i, int j) {
            return root(i) == root(j);
        }

        public void union(int i, int j) {
            int p = root(i);
            int q = root(j);
            if(p == q) {
                return;
            }
            if(sz[p] < sz[q]) { dsu[p] = q; sz[q] += sz[i]; }
            else              { dsu[q] = p; sz[p] += sz[q]; }

        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() { 
            while (st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
