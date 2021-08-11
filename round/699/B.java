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
        for (int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int boulders = fr.nextInt();
            int[] heights = new int[size];
            for (int i = 0; i< size; i++) {
                heights[i] = fr.nextInt();
            }

            out.write(solve(heights, boulders) + "\n");
        }
        out.close();
    }

    static int solve(int[] heights, int boulders) {
        if (heights.length == 1) {
            return -1;
        }
        if (heights[1] > heights[0]) {
            int dif = (heights[1] - heights[0]);
            heights[0] += dif;
            boulders -= dif;
        }

        if (boulders <= 0) {
            return 1;
        }

        int i = 0;
        int j = 1;

        while (j < heights.length && boulders > 0) {

            while(j < heights.length && heights[i] == heights[j]) {
                i++;
                j++;
            }

            while (j < heights.length && heights[j] <= heights[j-1]) {
                j++;
            }

            if(j >= heights.length) {
                return -1;
            }

            int to_fill = (heights[j] - heights[j-1]) * (j - i - 1);
            if (to_fill >= boulders) {
                return j - boulders + 1;
            } else {
                heights[j-1] = heights[j];
                boulders -= to_fill;
                j++;
            }
        }

        return -1;
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
