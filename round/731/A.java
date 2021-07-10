import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class A {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int aone = fr.nextInt();
            int atwo = fr.nextInt();
            int bone = fr.nextInt();
            int btwo = fr.nextInt();
            int fone = fr.nextInt();
            int ftwo = fr.nextInt();
            int dist = Math.abs(aone - bone) + Math.abs(atwo - btwo);
            if(fone == bone && fone == aone) {
                if(btwo > ftwo && atwo < ftwo || btwo < ftwo && atwo > ftwo) {
                    out.write((dist + 2) + "\n");
                } else {
                    out.write(dist + "\n");
                }
            } else if(ftwo == atwo && ftwo == btwo) {
                if(aone > fone && bone < fone || bone > fone && aone < fone) {
                    out.write((dist+2) + "\n");
                } else {
                    out.write(dist + "\n");
                }
            } 
            else {
                out.write(dist + "\n");
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
