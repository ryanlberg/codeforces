import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class E {
   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int i = 0; i < cases; i++) {
            int size = fr.nextInt();
            char[] sheepline = fr.nextLine().toCharArray();
            long minmoves = 0;
            int[] sheep = new int[size+1];
            for(int j = 1; j < sheep.length; j++) {
                if (sheepline[j-1] == '*') {
                    sheep[j] = sheep[j-1] + 1;
                } else {
                    sheep[j] = sheep[j-1];
                }
            }

            for (int j = 1; j < sheep.length; j++) {
                if (sheepline[j-1] == '.') {
                    minmoves += Math.min(sheep[j], sheep[sheep.length-1] - sheep[j]);
                }
            }
            out.write(minmoves + "\n");
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
