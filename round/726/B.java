import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class B {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int row = fr.nextInt();
            int col = fr.nextInt();

            int startrow = fr.nextInt() - 1;
            int startcol = fr.nextInt() - 1;

            int[][] potentials = new int[][] {{0, 0}, {0, col-1}, {row-1, 0}, {row-1, col-1}};

            long[] distances = new long[4];

            for(int i = 0 ; i < 4; i++) {
                distances[i]  = Math.abs(potentials[i][0] - startrow) + Math.abs(potentials[i][1] - startcol);
            }
            long maxdistance = 0;
            long[][] outnums = new long[2][2];
            for(int i = 0; i < distances.length; i++) {
                if (distances[i] > maxdistance) {
                    maxdistance = distances[i];
                    outnums[0][0] = potentials[i][0];
                    outnums[0][1] = potentials[i][1];
                }
            }

            long[] backdistances = new long[4];
            for(int i = 0; i < 4; i++) {
                backdistances[i]  = Math.abs(potentials[i][0] - startrow) + Math.abs(potentials[i][1] - startcol) + Math.abs(potentials[i][0] - outnums[0][0]) + Math.abs(potentials[i][1] - outnums[0][1]);
            }

            maxdistance = 0;
            for(int i = 0; i < backdistances.length; i++) {
                if (backdistances[i] > maxdistance) {
                    maxdistance = backdistances[i];
                    outnums[1][0] = potentials[i][0];
                    outnums[1][1] = potentials[i][1];
                }
            }
            out.write((outnums[0][0] + 1) + " " + (outnums[0][1] + 1) + " " + (outnums[1][0] + 1) + " " + (outnums[1][1] + 1) +"\n");
            
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
