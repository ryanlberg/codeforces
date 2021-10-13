import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


    static int min;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            long num = fr.nextLong();
            min = Integer.MAX_VALUE;
            int deleted = 0;
            while(num % 5 != 0) {
                num /= 10;
                deleted++;
            }
           
           
            if(num % 25 == 0) {
                out.write((deleted) + "\n");
                continue;
            }
            getMin(Long.toString(num), 0);
           
            out.write((min + deleted) + "\n");
           
        }
        out.close();
    }

    static void getMin(String number, int curnum) {
        if(number.length() <= 1) {
            min = Math.min(curnum, min);
            return;
        }
        long num = Long.parseLong(number);
        if(num % 25 == 0) {
            min = Math.min(curnum, min);
            return;
        }
        for(int i = 0; i < number.length(); i++) {
            String left = number.substring(0, i);
            String right = number.substring(i+1, number.length());
            getMin(left+right, curnum+1); 
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
