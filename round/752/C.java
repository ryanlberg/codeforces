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
            Stack<int[]> yeses = new Stack<>();
            Stack<int[]> nos = new Stack<>();
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                if(cur % (i+2) != 0) {
                    yeses.add(new int[]{i+1, cur});
                } else {
                    nos.add(new int[]{i+1, cur});
                }
            }

            while(yeses.size() > 0) {
                int[] cur = yeses.pop();
                Stack<int[]> toadd = new Stack<>();
                Stack<int[]> backtoNo = new Stack<>();
                while(nos.size() > 0 && nos.peek()[0] > cur[0]) {
                    int[] curno = nos.pop();
                    if(curno[1] % curno[0] != 0) {
                        toadd.add(new int[]{curno[0]-1, curno[1]});
                    }  else {
                        backtoNo.add(new int[]{curno[0]-1, curno[1]});
                    }
                }
                while(toadd.size() > 0) {
                    yeses.add(toadd.pop());
                }
                while(backtoNo.size() > 0) {
                    nos.add(backtoNo.pop());
                }
            }

            if(yeses.size() == 0 && nos.size() == 0) {
                out.write("YES\n");
            } else {
                out.write("NO\n");
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
