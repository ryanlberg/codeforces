import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class F1 {


    static TreeSet<Integer> onenums; 
    static TreeSet<Integer> twonums;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        onenums = new TreeSet<>();
        twonums = new TreeSet<>();
        genOneNums(10);
        
        for(int c = 0; c < cases; c++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
        }
        out.close();
    }


    static void genOneNums(int count) {
        
        for(int i = 1; i < count; i++) {
            int num = 0;
       
            for(int j = 0; j < count; j++) {
                num += (int)Math.pow(10, j) + i;
                System.out.println(num);
                onenums.add(num);
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
