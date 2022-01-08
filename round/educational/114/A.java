import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class A {


    static ArrayList<String> brackets;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int bracks = fr.nextInt();
            brackets = new ArrayList<>();
            loadBrackets(bracks, bracks, 0, "");
            for(String brack : brackets) {
                out.write(brack + "\n");
            }
        }
        out.close();
    }

    static void loadBrackets(int total, int breakp, int starting, String current) {
        if(brackets.size() < breakp) {
        //System.out.println(current);
            if(total == 0 && starting == 0) {
                brackets.add(current);
            }
            if(starting > 0) {
                loadBrackets(total, breakp, starting-1, current + ")");
            } 
            if(total > 0) {
                loadBrackets(total-1, breakp, starting+1, current + "(");
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
