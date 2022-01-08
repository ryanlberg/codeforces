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
            int[][] seen = new int[size+1][3];
            char[] puzzle = fr.next().toCharArray();
            seen[0] = new int[]{0, 0, 0};
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < size; i++) {
                if(puzzle[i] == 'a') {
                    seen[i+1] = new int[]{seen[i][0] + 1, seen[i][1], seen[i][2]};
                } else if(puzzle[i] == 'b') {
                    seen[i+1] = new int[]{seen[i][0], seen[i][1]+1, seen[i][2]};
                } else {
                    seen[i+1] = new int[]{seen[i][0], seen[i][1], seen[i][2] + 1};
                }
            }
            for(int i = 2; i < 10; i++) {
                for(int j = i; j < seen.length; j++) {
                    int as = seen[j][0] - seen[j-i][0];
                    int bs = seen[j][1] - seen[j-i][1];
                    int cs = seen[j][2] - seen[j-i][2];
                    if(as > bs && as > cs) {
                        min = Math.min(i, min);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE) {
                out.write(-1 + "\n");
            } else {
                out.write(min + "\n");
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
