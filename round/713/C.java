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
            int zero = fr.nextInt();
            int ones = fr.nextInt();
            char[] needed = fr.next().toCharArray();
            out.write(cando(needed, zero, ones) + "\n");
        }
        out.close();
    }

    static String cando(char[] needed, int z, int o) {
        for(int i = 0; i < needed.length; i++) {
            if(needed[i] == '0') {
                z--;
            }
            if(needed[i] == '1') {
                o--;
            }
        }
        int start = 0;
        int end = needed.length-1;
        boolean can = true;
       
        while (start <= end) {
            if(start == end && needed[start] == '?') {
                if(z % 2 == 1) {
                   
                    needed[start] = '0';
                    z--;
                } else if(o % 2 == 1) {
                    needed[start] = '1';
                    o--;
                } else {
                    can = false;
                    break;
                }
                start++;
                end--;
            } else if(needed[start] == '?' && needed[end] == '1') {
                if(o > 0) {
                    needed[start] = '1';
                    start++;
                    end--;
                    o--;
                } else {
                    can = false;
                    break;
                }
            } else if(needed[start] == '?' && needed[end] == '0') {
                if(z > 0) {
                    needed[start] = '0';
                    start++;
                    end--;
                    z--;
                } else {
                    can = false;
                    break;
                }
            } else if(needed[start] == '1' && needed[end] == '?') {
                if(o > 0) {
                    needed[end] = '1';
                    start++;
                    end--;
                    o--;
                } else {
                    can = false;
                    break;
                }
            } else if(needed[start] == '0' && needed[end] == '?') {
                if(z > 0) {
                    needed[end] = '0';
                    start++;
                    end--;
                    z--;
                } else {
                    can = false;
                    break;
                }
            } else {
                start++;
                end--;
            }
        }
        if(can) {
            start = 0;
            end = needed.length -1;
            while(start < end) {
                if(needed[start] != '?' && needed[start] == needed[end]) {
                    start++;
                    end--;
                } else if(needed[start] == '1' && needed[end] == '0' || needed[start] == '0' && needed[end] == '1') {
                    can = false;
                    break;
                } else if(z > 0 && z % 2 == 0) {
                    needed[start] = '0';
                    needed[end] = '0';
                    start++;
                    end--;
                    z-=2;
                } else if(o > 0 && o % 2 == 0) {
                    needed[start] = '1';
                    needed[end] = '1';
                    start++;
                    end--;
                    o-=2;
                } else {
                    can = false;
                    break;
                }
                
            }
        }


        if(z == 0 && o == 0 && can) {
            return new String(needed);
        }
        else {
            return "-1";
        }
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
