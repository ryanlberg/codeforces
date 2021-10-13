import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class E {


    static ArrayList<Integer> leaves;
    static node[] nodes;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int k = fr.nextInt();
            nodes = new node[size+1];
            for(int i = 1; i <= size; i++) {
                nodes[i] = new node();
            }
            for(int i = 0; i < size-1; i++) {
                int from = fr.nextInt();
                int to = fr.nextInt();
                nodes[from].addNode(to);
                nodes[to].addNode(from);
            }
            HashSet<Integer> removed = new HashSet<>();
            leaves = new ArrayList<Integer>();

            if(k >= size-1) {
                out.write("0\n");
                continue;
            } else {
                dfs(1, 1);
        
                while(k > 0) {
                    ArrayList<Integer> next = new ArrayList<>();
                    if(leaves.size() == 0) {
                        break;
                    }
                    for(int x : leaves) {
                        node cur = nodes[x];
                        for(int y : cur.connected) {
                            nodes[y].connected.remove(x);
                            if(nodes[y].connected.size() <= 1) {
                                next.add(y);
                            }
                        }
                        removed.add(x);
                    }
                    k--;
                    leaves = next;
                }
                out.write((size - removed.size()) + "\n");
            }

        }
        out.close();
    }

    static void dfs(int cur, int from) {
        node curn = nodes[cur];
        if(curn.connected.size() <= 1) {
            leaves.add(cur);
        }
        for(int x : curn.connected) {
            if(x != from) {
                dfs(x, cur);
            }
        }
    }

    static class node {
        
        HashSet<Integer> connected;

        public node() {
            connected = new HashSet<Integer>();
        }

        public void addNode(int con) {
            connected.add(con);
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
