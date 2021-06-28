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
            int l = fr.nextInt();
            char[] cur = Integer.toString(l).toCharArray();
            boolean cando = true;
            if (cur.length <= 1) {
                cando = false;
            }
            if(cando) {
                for(int i = 1; i < cur.length; i++) {
                    if(cur[i] < cur[i-1]) {
                        cando = false;
                        break;
                    }
                }
                if(cur[cur.length-1] != cur[cur.length-2]) {
                    cando = false;
                }
            }
            if (cando) {
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
