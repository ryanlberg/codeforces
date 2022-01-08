import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class A {



    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int num = fr.nextInt();
            
            ArrayList<Integer> evens = new ArrayList<>();
            ArrayList<Integer> odds = new ArrayList<>();
            int sum = 0;
            for(int i = 0; i < num; i++) {
                int cur = fr.nextInt();
                if(cur % 2 == 0) {
                    evens.add(i+1);
                } else{
                    odds.add(i+1);
                }
                sum += cur;
            }
            boolean isprime = isPrime(sum);
            if(isprime) {
                out.write((evens.size() + odds.size() - 1) + "\n"); 
                for(int x : evens) {
                    out.write(x + " ");
                }
                for(int i = 1; i < odds.size(); i++) {
                    out.write(odds.get(i) + " ");
                }
                out.write("\n");
                
            } else {
                out.write((evens.size() + odds.size()) + "\n"); 
                for(int x : evens) {
                    out.write(x + " ");
                }
                for(int i = 0; i < odds.size(); i++) {
                    out.write(odds.get(i) + " ");
                }
                out.write("\n");
            }
            
        }
        out.close();
    }

    static boolean isPrime(int curnum) {
        boolean isprime = true;
        for(int i = 2; i < curnum; i++) {
            if(curnum % i == 0) {
                isprime = false;
                break;
            }
        }
        return isprime;
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
