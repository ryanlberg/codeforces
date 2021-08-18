import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class E {
   
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            HashMap<Character, Integer> lettercounts = new HashMap<>();
            HashSet<Character> letters = new HashSet<>();
            String cur = fr.next();
            String t = "";
            String s = "";
            for (int i = 0; i < cur.length(); i++) {
                char curletter = cur.charAt(i);
                if(!lettercounts.containsKey(curletter)) {
                    lettercounts.put(curletter, 1);
                    letters.add(curletter);
                } else {
                    lettercounts.put(curletter, lettercounts.get(curletter)+1);
                }   
            }

            boolean cando = true;
            int curneeded = letters.size();
            HashSet<Character> consumed = new HashSet<Character>();
            int i = cur.length()-1;
            while (i >= 0 && cando) {
                System.out.println(i);
                if(letters.size() == 1) {
                    s = cur.substring(0, i+1);
                    for(Character x : letters) {t = x + t;}
                    break;
                }
                while(consumed.contains(cur.charAt(i))) {
                    i--;
                }
                t = cur.charAt(i) + t;
                char current = cur.charAt(i);
                consumed.add(current);
                int seen = 0;
                if(seen < lettercounts.get(current)/curneeded) {
                    while(seen < lettercounts.get(current)/curneeded) {
                            //System.out.println(current + " " + seen + " "  + lettercounts.get(current)/curneeded);
                            if(!consumed.contains(cur.charAt(i))) {
                                cando = false;
                                break;
                            }
                            if(cur.charAt(i) == current) {
                                seen++;
                            }
                            i--;
                        } 
                } else {
                    cando = false;
                }
                letters.remove(current);
                curneeded = letters.size();
            }

            if(cando) {
                out.write(s + " " + t + "\n");
            } else {
                out.write(-1 + "\n");
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
