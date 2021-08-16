import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


    static HashMap<Integer, HashSet<Integer>> map;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            map = new HashMap<>();
            int a = fr.nextInt();
            for(int i = 1; i <= a+1; i++) {
                map.put(i, new HashSet<Integer>());
            }
            for(int i = 1; i < a; i++) {
                map.get(i).add(i+1);
            }

           
            for(int i = 0; i < a; i++) {
                int cur = fr.nextInt();
                if(cur == 0) {
                    map.get(i+1).add(a+1);
                } else {
                    map.get(a+1).add(i+1);
                }
            }

            // for(Integer x : map.keySet()) {
            //     System.out.print(x + ": ");
            //     for(Integer y : map.get(x)) {
            //         System.out.print(y + ", ");
            //     }
            //     System.out.println("");
            // }

           
            boolean solved = false;
            if(map.get(a+1).contains(1)) {
                solved = true;
                out.write(a+1 + " ");
                for(int i = 1; i <= a; i++) {
                    out.write(i + " ");
                }
                out.write("\n");
            }

            if(!solved) {
                if(map.get(a).contains(a+1)) {
                    solved = true;
                    for(int i = 1; i <= a + 1; i++) {
                        out.write(i + " ");
                    }
                    out.write("\n");
                }
            }

            if(!solved) {
                for(int i = 1; i <= a; i++) {
                    if(map.get(i).contains(a+1) && map.get(a+1).contains(i+1)) {
                        solved = true;
                        for(int j = 1; j <= i; j++) {
                            out.write(j + " ");
                        }
                        out.write(a+1 + " ");
                        for(int j = i+1; j <= a; j++) {
                            out.write(j + " ");
                        }
                        out.write("\n");
                        break;
                    }
                }
            }

            if(!solved) {
                out.write("-1\n");
            }
            
        }
        out.close();
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
