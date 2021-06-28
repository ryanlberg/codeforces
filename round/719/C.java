import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class C {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int i = 0; i < cases; i++) {
            int outsize = fr.nextInt();
            if (outsize == 1) {
                out.write(1 + "\n");
            } else if (outsize == 2) {
                out.write(-1 + "\n");
            } else if (outsize == 3) {
                int[][] ret = new int[][]{{2, 8, 3}, {4,1,5}, {6,9,7}};
                for(int j = 0; j < ret.length; j++) {
                    for(int k = 0; k < ret[j].length; k++) {
                        out.write(ret[j][k] + " ");
                    }
                    out.write("\n");
                }
            } else {
                int start = 1;
                int[][] ret = new int[outsize][outsize];
                for(int j = 0; j < ret.length; j++) {
                    for(int k = 0; k < ret[j].length; k+=2) {
                        ret[j][k] = start;
                        start += 1;
                    }
                }
                for(int j = 0; j < ret.length; j++) {
                    for(int k = 1; k < ret[j].length; k+=2) {
                        ret[j][k] = start;
                        start += 1;
                    }
                }

                for(int j = 0; j < ret.length; j++) {
                    for(int k = 0; k < ret[j].length; k++) {
                        out.write(ret[j][k] + " ");
                    }
                    out.write("\n");
                }
            }
            
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
