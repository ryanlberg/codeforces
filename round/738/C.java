import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


    static HashSet<Integer> seen;
    static ArrayList<Integer> ret;
    static boolean found;
    static HashMap<Integer, HashSet<Integer>> map;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            map = new HashMap<>();
            int a = fr.nextInt();
            seen = new HashSet<Integer>();
            ret = new ArrayList<Integer>();
            for(int i = 1; i <= a+1; i++) {
                map.put(i, new HashSet<Integer>());
            }
            for(int i = 1; i < a; i++) {
                map.get(i+1).add(i);
            }

            found = false;
            for(int i = 0; i < a; i++) {
                int cur = fr.nextInt();
                if(cur == 0) {
                    map.get(a+1).add(i+1);
                } else {
                    map.get(i+1).add(a+1);
                }
            }

            // for(Integer x : map.keySet()) {
            //     System.out.print(x + ": ");
            //     for(Integer y : map.get(x)) {
            //         System.out.print(y + ", ");
            //     }
            //     System.out.println("");
            // }

            solve(a+1, 0, a+1);
            if(found) {
                for(Integer x : ret) {
                    out.write(x + " ");
                }
            } else {
                out.write("-1");
            }
            out.write("\n");
        }
        out.close();
    }

   

    static void solve( int start, int depth, int size) {
        if(depth == size-1) {
            found = true;
            ret.add(start);
            return;
        } else {
            for (Integer x : map.get(start)) {
                if(!seen.contains(x)) {
                    seen.add(x);
                    solve(x, depth+1, size);
                    if(found) {
                        ret.add(start);
                        return;
                    }
                    seen.remove(x);
                }

            }
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
