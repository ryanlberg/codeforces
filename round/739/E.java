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
            int original_end = 0;
            int i = cur.length()-1;
            while (i >= 0 && cando) {
                if(letters.size() == 1) {
                   
                    for(Character x : letters) {
                        t = x + t;
                        original_end += lettercounts.get(x);
                    }
                    s = cur.substring(0, original_end);
                    break;
                }
                while(consumed.contains(cur.charAt(i))) {
                    i--;
                }
                t = cur.charAt(i) + t;
                char current = cur.charAt(i);
                consumed.add(current);
                int seen = 0;
                original_end += lettercounts.get(current)/curneeded;
            
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
            //System.out.println(genIt(s, t) + " " + cur + ": " + s + ", " + t);
            if(genIt(s, t).equals(cur)) {
                out.write(s + " " + t + "\n");
            } else {
                out.write(-1 + "\n");
            }


        }
        out.close();
    }

    static String genIt(String s, String t) {
        StringBuilder ret = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for(int i = 0; i < t.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(!seen.contains(s.charAt(j))) {
                    ret.append(s.charAt(j));
                }
            }
            seen.add(t.charAt(i));
        }
        return ret.toString();
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
