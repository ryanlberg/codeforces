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
            int nums = fr.nextInt();
            ArrayList<int[]> ranges = new ArrayList<>();
            for(int i = 0; i < nums; i++) {
                ranges.add(new int[]{fr.nextInt(), fr.nextInt()});
            }

            Collections.sort(ranges, (a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
            ArrayList<int[]> retvals = new ArrayList<>();
            HashSet<Integer> seen = new HashSet<>();
            for(int[] x : ranges) {
                if(x[0] == x[1]) {
                    seen.add(x[0]);
                    retvals.add(new int[]{x[0], x[1], x[0]});
                } else {
                    for(int i = x[0]; i <= x[1]; i++) {
                        if(!seen.contains(i)) {
                            seen.add(i);
                            retvals.add(new int[]{x[0], x[1], i});
                            break;
                        }
                    }
                }
            }
            for(int[] x : retvals) {
                out.write(x[0] + " " + x[1] + " " + x[2] + "\n");
            }
            out.write("\n");

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
