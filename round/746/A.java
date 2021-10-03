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
            int weapons = fr.nextInt();
            int health = fr.nextInt();
            ArrayList<Integer> damage = new ArrayList<>();
            for(int i = 0; i < weapons; i++) {
                damage.add(fr.nextInt());
            }

            Collections.sort(damage);
           
            int weapon1 = damage.get(damage.size()-1);
            int weapon2 = damage.get(damage.size()-2);
            if(health % (weapon1+weapon2) == 0) {
                out.write(health / (weapon1+weapon2)*2 + "\n");
            } else {
                int leftover = health % (weapon1 + weapon2);
                if(leftover <= weapon1) {
                    out.write((health/(weapon1+weapon2)*2 + 1) + "\n");
                } else {
                    out.write((health/(weapon1+weapon2)*2+2) + "\n");
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
