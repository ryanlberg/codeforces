import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class G {

    static int[] ret;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            ret = new int[size+1];
            int edges = fr.nextInt();
            Digraph cur = new Digraph(size);
            for(int i = 0; i < edges; i++) {
                int from = fr.nextInt();
                int to = fr.nextInt();
                cur.addEdge(from, to);
            }
            SCC sc = new SCC(cur);
            cur.fillScc(sc.postorder);
            cur.fillout(1);
            for(int i = 1; i < cur.out.length; i++) {
                if (cur.out[i] > 1) {
                    out.write(2 + " ");
                } else {
                    out.write(cur.out[i] + " ");
                }
            }
            out.write("\n");
            // for(int i = 1; i < cur.scs.length; i++) {
            //     System.out.println(i +  " " + cur.scs[i]);
            // }
            // System.out.println("");
            
        }
        out.close();
    }

    static class Digraph {
        int size;
        HashMap<Integer, HashSet<Integer>> g;
        boolean[] marked;
        int[] amounts;
        int[] scs;
        HashMap<Integer, Integer> scscounts;
        boolean[] outmarked;
        int[] out;

        public Digraph(int n) {
            this.size = n;
            out = new int[size+1];
            outmarked = new boolean[size+1];
            this.marked = new boolean[n+1];
            scs = new int[n+1];
            Arrays.fill(marked, false);
            scscounts = new HashMap<>();
            g = new HashMap<>();
            for(int i = 1; i <= size; i++) {
                g.put(i, new HashSet<Integer>());
            }
        }

        private boolean isInfinite(int node) {
            boolean multiple_components = scscounts.get(scs[node]) > 1;
            boolean self_connected = g.get(node).contains(node);
            return multiple_components || self_connected;
        }

        public void fillout(int start) {
            Queue<ArrayList<Integer>> frontier = new LinkedList<ArrayList<Integer>>();
            ArrayList<Integer> begin = new ArrayList<Integer>();
            begin.add(start);
            if(isInfinite(start)) {
                begin.add(-1);
            } else{
                begin.add(0);
            }
            frontier.add(begin);
            while(frontier.size() > 0) {
                ArrayList<Integer> cur = frontier.poll();
                //System.out.println(cur.get(0) + " " + cur.get(1));
                if(cur.get(1) == -1 || isInfinite(cur.get(0))) {
                    out[cur.get(0)] = -1;
                } else {
                    out[cur.get(0)]++;
                }
                outmarked[cur.get(0)] = true;
                for(int x : g.get(cur.get(0))) {
                    if(!outmarked[x] || (cur.get(1) == -1 && out[x] != -1)) {
                        ArrayList<Integer> next = new ArrayList<Integer>();
                        if(cur.get(1) == -1 || isInfinite(x)) {
                            next.add(x);
                            next.add(-1);
                        } else{
                            next.add(x);
                           
                            next.add(0);
                            
                        }
                        frontier.add(next);
                    } else {
                        if(cur.get(1) == -1 || isInfinite(x)) {
                            out[x] = -1;
                        }
                        else{
                            out[x]++;
                        }
                    }
                }
            }

        }
        public void fillScc(Stack<Integer> order) {
            int scc = 0;
            while(order.size() > 0) {
                int cur = order.pop();
                if(!marked[cur]) {
                    scscounts.put(scc, 0);
                    dfs(cur, scc);
                    scc++;
                }
            }
        }

        public void dfs(int cur, int scc) {
            scs[cur] = scc;
            scscounts.put(scc, scscounts.get(scc) + 1);
            marked[cur] = true;
            for(int x: g.get(cur)) {
                //System.out.println("from: " + cur + ", to: " + x);
                if(!marked[x]) {
                    dfs(x, scc);
                }   
            }

        }

        public void addEdge(int i, int j) {
           g.get(i).add(j);
        }

        private Digraph reverse() {
            Digraph rev = new Digraph(this.size);
            for(int x : this.g.keySet()) {
                for(int y : this.g.get(x)) {
                    rev.addEdge(y, x);
                }
            }
            
            return rev;
        }

        public String toString() {
            String out = "";
            for(int x : g.keySet()) {
                out += x + ": ";
                for(int y: g.get(x)) {
                    out += y + " ";
                }
                out += "\n";
            }

            return out;
        }

    }

    static class SCC {
        boolean[] marked;
        int[] scc;
        Digraph g;
        Digraph rev;
        Stack<Integer> postorder;

        public SCC(Digraph g) {
            marked = new boolean[g.size + 1];
            Arrays.fill(marked, false);
            scc = new int[g.size + 1];
            this.g = g;
            this.rev = g.reverse();
            postorder = new Stack<>();
            fillscc();
        }

        public void fillscc() {
           
            for(int i = 1; i <= g.size; i++) {
                if(!marked[i]) {
                    dfs(i);
                }
            }
        }

        private void dfs(int start) {   
            marked[start] = true;
            for(int x: rev.g.get(start)) {
                //System.out.println("from: " + start + ", to: " + x);
                if(!marked[x]) {
                    dfs(x);
                }   
            }
            postorder.add(start);
           
            
            
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
