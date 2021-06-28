import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class A {

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        
        for(int i = 0; i < cases; i++) {
            int length = fr.nextInt();
            boolean correct = true;
            char[] word = fr.nextLine().toCharArray();
            HashSet<Character> seen = new HashSet<>();
            char last = word[0];
            for(int j = 1; j < word.length; j++) {
                if (last != word[j]) {
                    if (seen.contains(last)) {
                        correct = false;
                        break;
                    }
                    seen.add(last);
                    last = word[j];
                }
            }
            if(seen.contains(last)) {
                correct = false;
            }
            if(correct) out.write("YES\n");
            else out.write("NO\n");
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
