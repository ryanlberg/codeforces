import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int nodes = fr.nextInt();
            int k = fr.nextInt();
            int[][] cons = new int[nodes-1][2];

            G[] no = new G[nodes];

            for(int i = 0; i < nodes; i++) {
                int val = fr.nextInt();
                no[i] = new G(val, i);
            }

            for(int i = 0; i < nodes-1; i++) {
                int from = fr.nextInt();
                int to = fr.nextInt();
                cons[i][0] = from;
                cons[i][1] = to;
            }
           
            for(int i = 0; i < cons.length; i++) {
                int from = Math.min(cons[i][0] - 1, cons[i][1] - 1);
                int to = Math.max(cons[i][0] - 1, cons[i][1] - 1);
                no[from].addChild(no[to], from);   
            }

            no[0].setCum(0);
            int needed = no[0].cum;
            if(needed == 0) {
                out.write("YES\n");
            } else if(needed != 0 && k == 2) {
                out.write("NO\n");
            } else {
                ArrayList<Node> nodelist = new ArrayList<>();
                for(int i = 0; i < nodes; i++) {
                    nodelist.add(new Node(no[i].depth, no[i]));
                }
                Collections.sort(nodelist);
                for(Node x : nodelist) {
                    System.out.println(x);
                }
            }
           

        }
        out.close();

    }

    static class Node implements Comparable<Node> {
        int depth;
        G no;

        public Node(int depth, G node) {
            this.depth = depth;
            this.no = node;
        }

        public int compareTo(Node that) {
            if(this.depth >= that.depth) {
                return -1;
            }
            return 1;
        }

        public String toString() {
            String out = "";
            out += "Node : " + no.value + ", Depth: " + no.depth;
            return out;
        }
    }

    static class G {
        int value;
        int cum;
        int depth;
        int node;
        int from;
        ArrayList<G> children;

        public G(int value, int node) {
            this.value = value;
            this.cum = 0;
            this.node = node;
            
            children = new ArrayList<>();
        }

        public void setCum(int depth) {
            this.depth = depth;
            for(G x : children) {
                x.setCum(depth+1);
                cum ^= x.cum;
            }
            cum ^= value;
        }

        public void addChild(G childr, int from) {
            this.from = from;
            this.children.add(childr);
        }
        
        public ArrayList<G> getChildren() {
            return this.children;
        }

        public String toString() {
            String out = "";
            out += value;
            out += ": ";
            out += children();
            return out;
        }

        private String children() {
            String children = "";
            for(G x : this.children) {
                children += x.value + ", ";
            }
            return children;
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
