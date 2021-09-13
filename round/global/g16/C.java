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
            String astring = fr.next();
            String bstring = fr.next();

            int max = 0;
            int i = 0;
            while(i < size) {
                char achar = astring.charAt(i);
                char bchar = bstring.charAt(i);
                if(achar == '1' && bchar == '0' || bchar == '1' && achar == '0') {
                    i++;
                    max += 2;
                
                }

                else if(achar == '0' && bchar == '0') {
                    if(i < astring.length() - 1) {
                        if(astring.charAt(i+1) == '1' && bstring.charAt(i+1) == '1') {
                            max += 2;
                            i += 2;
                        } else {
                            i++;
                            max += 1;
                        }
                    } else {
                        i++;
                        max += 1;
                        
                    }
                }

                else if(achar == '1' && bchar == '1') {
                    if(i < size-1) {
                        if(astring.charAt(i+1) == '0' && bstring.charAt(i+1) == '0') {
                            max += 2;
                            i += 2;
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                    
                   
                }

            }

            out.write(max + "\n");
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
