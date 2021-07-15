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
            System.out.println(cur);
        }
        out.close();
    }

    static class Digraph {
        int size;
        HashMap<Integer, HashSet<Integer>> g;
        int[] marked;
        int[] amounts;

        public Digraph(int n) {
            this.size = n;
            this.marked = new int[n+1];
            Arrays.fill(marked, -1);
            g = new HashMap<>();
            for(int i = 1; i <= size; i++) {
                g.put(i, new HashSet<Integer>());
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

            while(postorder.size() > 0) {
                System.out.println("Postorder: " + postorder.pop() + " ");
            }
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
                System.out.println("from: " + start + ", to: " + x);
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
