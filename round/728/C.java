import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.ArrayList;
public class C {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int pastures = fr.nextInt();
            int[] mins = new int[pastures];
            for(int i = 0; i < pastures; i++) {
                mins[i] = fr.nextInt();
            }
            long total = 0;
            long sumbefore = 0;
            long numberbefore = 0;
            sort(mins);
            for(int i = 1; i < pastures; i++) {
                total += mins[i] - mins[i-1];
                numberbefore++;
                sumbefore += mins[i-1];
                total -= mins[i]*numberbefore - sumbefore;
            }
            
            out.write(total + "\n");
            
        }
        out.close();
    }

    static void sort(int[] a) {
        ArrayList<Integer> tbs = new ArrayList<Integer>();
        for(int i: a) tbs.add(i);
        Collections.sort(tbs);
        for(int i = 0; i < a.length; i++) a[i] = tbs.get(i);
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
