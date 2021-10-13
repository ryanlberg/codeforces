import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class C{

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] mice = new int[n+1];
            TreeSet<Integer> locs = new TreeSet<>(Collections.reverseOrder());
            
            for(int i = 0; i < k; i++) {
                int curloc = fr.nextInt();
                mice[curloc]++;
                locs.add(curloc);
            }

            int cat = 0;
            int totalsaved = 0;
            for(Integer x : locs) {
                
                int curloc = x;

                if(cat >= curloc) {
                    break;
                }

                int catdist = curloc - cat;
                int mousdist = n - curloc;

                int cansave = catdist / mousdist;
                int saved = Math.min(cansave, mice[curloc]);
                totalsaved += saved;
                cat += saved*mousdist;
                
               
            }

            out.write(totalsaved + "\n");

        }
        out.close();
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
