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
            int size = fr.nextInt();
            String num = fr.next();
            int first_zero = -1;
            for(int i = 0; i < num.length(); i++) {
                if(num.charAt(i) == '0') {
                    first_zero = i;
                    break;
                }
            }

            if(first_zero == -1) {
                if(num.length() % 2 == 0) {out.write(writeNums(1, num.length()/2, num.length()/2+1, num.length()));}
                else { out.write(writeNums(1, num.length()/2, num.length()/2+2, num.length())); }
            }
            else if(first_zero < num.length()/2) {
                out.write(writeNums(first_zero+1, num.length(), first_zero+2, num.length()));
            } else {
                out.write(writeNums(1, first_zero+1, 1, first_zero));
            }


           
            
        }
        out.close();
    }

    static String writeNums(int a, int b, int c, int d) {
        return a + " " + b + " " + c + " " + d + "\n";
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
