import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


    static TreeSet<Integer> breaks;
   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int alice = fr.nextInt();
            int bob = fr.nextInt();
    
            out.write(breaks.size() + " \n");
            for(Integer x : breaks) {
                out.write(x + " ");
            }
            out.write("\n");
            
        }
        out.close();
    }

    static void getBreaks(int alice, int bob, int starter, int breakseen, int total) {
        if(alice == 0 && bob == 0) {
            breaks.add(breakseen);
            breaks.add(total - breakseen);
        } 
        else if(starter == 0) {
            if(alice > 0) {
                getBreaks(alice-1, bob, 1, breakseen, total);
            }
            if(bob > 0) {
                getBreaks(alice, bob-1, 1, breakseen+1, total);
            }
        }
        else if(starter == 1) {
            if(alice > 0) {
                getBreaks(alice-1, bob, 0, breakseen+1, total);
            }
            if(bob > 0) {
                getBreaks(alice, bob-1, 0, breakseen, total);
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
