import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            String num = fr.next();
            if(!containsNumber(num, out)) {
                seeIf(num, out);
            }
        }
        out.close();
    }


    static boolean containsNumber(String n, PrintWriter out) {
        for(int i = 0; i < n.length(); i++) {
            int cur = Integer.parseInt(Character.toString(n.charAt(i)));
            if(cur > 2 && cur % 2 == 0 || cur == 9 || cur == 1) {
                out.write(1 + "\n");
                out.write(cur + "\n");
                return true;
            }
        }
        return false;
    }


    static void seeIf(String num, PrintWriter out) {
        boolean found = false;
        for(int i = 0; i < num.length(); i++) {
            for(int j = i+1; j < num.length(); j++) {
                String x = Character.toString(num.charAt(i));
                x += Character.toString(num.charAt(j));
                if(!isPrime(Integer.parseInt(x))) {
                    out.write(x.length() + "\n");
                    out.write(x + "\n");
                    found = true;
                    break;
                }
                
            }
            if(found) {
                break;
            }
        }
    }

    static boolean isPrime(int x) {
        for(int i = 2; i < x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
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
