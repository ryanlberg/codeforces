import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class D {


    static ArrayList<String> numbers;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();

        numbers = new ArrayList<>();
        for(long i = 0; i < 63; i++) {
            numbers.add(Long.toString((long)Math.pow(2, i)));
        }

        for(int c = 0; c < cases; c++) {
            String curnumber = Integer.toString(fr.nextInt());
            out.write(getMin(curnumber) + "\n");
        }
        out.close();
    }

    static int getMin(String curnumber) {
        int min = Integer.MAX_VALUE;
        for(String x: numbers) {
            min = Math.min(min, solve(x, curnumber));
        }
        return min;
    }

    static int solve(String x, String curNumber) {
        int removals = 0;
        int at = 0;
        int i = 0;
        while(i < curNumber.length()){
            if(x.charAt(at) == curNumber.charAt(i)) {
                at++;
                i++;
            } else {
                removals++;
                i++;
            }
            if(at >= x.length()) {
                removals += curNumber.length() - i;
                break;
            }
        }

        return Math.min(removals + x.length() - at, x.length() + curNumber.length());
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
