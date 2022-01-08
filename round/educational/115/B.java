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
            int[] counts = new int[5];
            int[][] thing = new int[size][5];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < 5; j++) {
                    int cur = fr.nextInt();
                    if(cur == 1) {
                        counts[j]++;
                    }
                    thing[i][j] = cur;
                }
            }

            ArrayList<int[]> candidates = new ArrayList<>();
            int needed = size/2;
            for(int i = 0; i < counts.length; i++) {
                for(int j = i+1; j < counts.length; j++) {
                    if(counts[i] >= needed && counts[j] >= needed) {
                        candidates.add(new int[]{i, j});
                    }
                }
            }
          
            boolean cando = false;
            for(int[] x : candidates) {
                boolean mayb = maybe(thing, x[0], x[1]);
                if(mayb) {
                    cando = true;
                    break;
                }
            }

            if(cando) {
                out.write("YES\n");
            } else {
                out.write("NO\n");
            }
        }
        out.close();
    }

    static boolean maybe(int[][] thing, int l, int r) {
        int left = 0;
        int right = 0;
        int both = 0;
        for(int i = 0; i < thing.length; i++) {
            if(thing[i][l] == 1 && thing[i][r] == 1) {
                both++;
            } else if(thing[i][l] == 1) {
                left++;
            } else if(thing[i][r] == 1) {
                right++;
            }
        }

        int needed = thing.length/2;
        if(left > needed || right > needed || (left + right + both) != thing.length) {
            return false;
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
