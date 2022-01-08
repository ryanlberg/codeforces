import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.math.BigInteger;
public class C {

    static String addd(String a, String b) {
        if(a.length() < b.length()) {
            int needed = b.length() - a.length();
            for(int i = 0; i < needed; i++) {
                a = "0" + a;
            }
        }
        if(b.length() < a.length()) {
            int needed = a.length() - b.length();
            for(int i = 0; i < needed; i++) {
                b = "0" + b;
            }
        }
        String ret = "";
        int i = a.length()-1;
        int j = b.length()-1;
        while(i >= 0 && j >= 0) {
            ret = Long.toString(Long.parseLong(Character.toString(a.charAt(i))) + Long.parseLong(Character.toString(b.charAt(j)))) + ret;
            i--;
            j--;
        }
        return ret;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            String initial = fr.next();
            String result = fr.next();
            int i = result.length()-1;
            int j = initial.length()-1;
            String ret = "";
            while(i >= 0 && j >= 0) {
                String curup = Character.toString(result.charAt(i));
                String curdown = Character.toString(initial.charAt(j));
                i--;
                j--;
                while(i >= 0 && new BigInteger(curup).compareTo(new BigInteger(curdown)) < 0) {
                    curup = Character.toString(result.charAt(i)) + curup;
                    i--;
                }
                BigInteger up = new BigInteger(curup);
                BigInteger down = new BigInteger(curdown);
                if(up.compareTo(down) < 0) {
                    break;
                }
                ret = up.subtract(down).toString() + ret;
            }
            if(i >= 0) {
                String toadd = result.substring(0, i+1);
                ret = toadd + ret;
            }
            if(addd(initial, ret).equals(result)) {
                BigInteger b = new BigInteger(ret);
                out.write(b.toString()+ "\n");
            }  else {
                out.write("-1\n");
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
