import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class B {
   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        
        int[][] l;
        
        int size = fr.nextInt();
        int q = fr.nextInt();
        l = new int[size+1][26];
        char[] x = fr.next().toCharArray();
        l[1][(int)x[0] - (int)'a']++;
        for(int i = 1; i < x.length; i++) {
            for(int j = 0; j < 26; j++) {
                l[i+1][j] = l[i][j]; 
            }
            l[i+1][(int)x[i]-(int)'a']++;
        }
        // for(int i = 0; i < l.length; i++) {
        //     for(int j = 0; j < l[i].length; j++) {
        //         out.write(l[i][j] + " ");
        //     }
        //     out.write("\n");
        // }
        for(int i = 0; i < q; i++) {
            out.write(getTotal(l, fr.nextInt(), fr.nextInt()) + "\n");
        }
        
        
        out.close();
    }

    static long getTotal(int[][] l, int left, int right) {
        long total = 0;
        int[] range = new int[26];
        for(int i = 0; i < 26; i++) {
            range[i] = l[right][i] - l[left-1][i];
            total += range[i] * (i+1);
        }

        return total;
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
