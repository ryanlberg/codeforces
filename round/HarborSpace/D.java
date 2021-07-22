import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class D {


    static HashMap<Character, ArrayList<Integer>> letterlocs;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            String type = fr.next();
            letterlocs = new HashMap<>();
            for(int i = 0; i < type.length(); i++) {
                if(!letterlocs.containsKey(type.charAt(i))) {
                    letterlocs.put(type.charAt(i), new ArrayList<Integer>());
                }
                letterlocs.get(type.charAt(i)).add(i);
            }

            String toget = fr.next();
           
            boolean cando = solve(type, toget);
            if(cando) {
                out.write("YES\n");
            } else{
                out.write("NO\n");
            }
        }
        out.close();
    }

    static boolean solve(String type, String toget) {
        int i = type.length() - 1;
        int j = toget.length() - 1;
        while(i >= 0 && j >= 0) {
            if(type.charAt(i) != toget.charAt(j)) {
                i -= 2;
            } else {
                i-=1;
                j-=1;
            }
        }
        return j < 0;
        
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
