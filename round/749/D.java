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
        
       
        int nums = fr.nextInt();
        int[] ret = new int[nums];
        int[] q = new int[nums];
        Arrays.fill(q, 1);
        for(int i = 0; i < nums; i++) {
            int cur = makeQuery(q, fr);
            ret[cur] = i+1;
            q[cur] = nums;
        }

        out.write("! ");
        for(int x : ret) {
            out.write(x + " ");
        }
        out.write("\n");
        out.close();
    }

    static int makeQuery(int[] q, FastReader fr) {
        StringBuilder sb = new StringBuilder();
        sb.append("? ");
        for(int x : q) {
            sb.append(Integer.toString(x) + " ");
        }
        sb.append("\n");
        System.out.println(sb.toString());
        
        return fr.nextInt();
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
