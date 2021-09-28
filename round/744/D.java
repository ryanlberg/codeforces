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
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int people = fr.nextInt();
            PriorityQueue<int[]> peeps = new PriorityQueue<>((a, b) -> {
                if(a[1] >= b[1]) {
                    return -1;
                } else {
                    return 1;
                }
            });

            for(int i = 0 ; i < people; i++) {
                int cur = fr.nextInt();
                if (cur > 0) {
                    peeps.add(new int[]{i+1, cur});
                }
            }

            ArrayList<int[]> ret = new ArrayList<>();
            while(peeps.size() > 1) {
                int[] a = peeps.poll();
                int[] b = peeps.poll();
                ret.add(new int[]{a[0], b[0]});
                a[1] -= 1;
                b[1] -= 1;
                if(a[1] > 0) {
                    peeps.add(a);
                }
                if(b[1] > 0) {
                    peeps.add(b);
                }
            }

            out.write(ret.size() + "\n");
            for(int[] x : ret) {
                out.write(x[0] + " " + x[1] + "\n");
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
