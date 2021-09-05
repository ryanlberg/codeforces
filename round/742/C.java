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
            String num = fr.next();
            
            if(num.length() == 2) {
                out.write((Integer.parseInt(num) % 10 * 2) + "\n");
            } else if (num.length() == 1) {
                out.write((Integer.parseInt(num) - 1)+ "\n");
            }
            int start = 0;
            int total = 1;
            while(start < num.length() && start != num.length() - 1 || start != num.length()-2) {
                
            }
            start = 1; {
            while(start < num.length() && start != num.length() - 1 || start != num.length()-2) {

            }
            out.write(total + "\n");
            }
        }
        out.close();
    }

    static int waysWithCarry(int n) {
        return 0;
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
