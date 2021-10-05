import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


   static int count;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int nodes = fr.nextInt();
            int k = fr.nextInt();
            int[][] cons = new int[nodes-1][2];

            G[] no = new G[nodes];
            int needed = 0;
            for(int i = 0; i < nodes; i++) {
                int val = fr.nextInt();
                needed ^= val;
                no[i] = new G(val, i);
            }

            for(int i = 0; i < nodes-1; i++) {
                int from = fr.nextInt();
                int to = fr.nextInt();
                cons[i][0] = from;
                cons[i][1] = to;
            }
           
            for(int i = 0; i < cons.length; i++) {
                int from = cons[i][0] - 1;
                int to =  cons[i][1] - 1;
                no[from].addChild(no[to]);   
                no[to].addChild(no[from]);
            }

            if(needed == 0) {
                out.write("YES\n");
            } else if(k == 2) {
                out.write("NO\n");
            } else {
                count = 0;
                dfs(no[0], no[0], needed);
                
                if(count > 2) {
                    out.write("YES\n");
                } else {
                    out.write("NO\n");
                }
            }
           

        }
        out.close();

    }

    static int dfs(G node, G node1, int target) {
        int cur = node.value;
        for(G x : node.getChildren()) {
            if(x.node == node1.node) {
                continue;
            }
            cur ^= dfs(x, node, target);
        }
        
        if(cur == target) {
            count++;
            return 0;
        } else{
            return cur;
        }
    }

    static class G {
        int value;
        int cum;
        int depth;
        int node;
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

        public void addChild(G childr) {
        
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
