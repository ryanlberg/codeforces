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
            ArrayList<ArrayList<Integer>> wordcounts = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                wordcounts.add(new ArrayList<Integer>());
            }
            int words = fr.nextInt();
            for(int i = 0; i < words; i++) {
                String curword = fr.next();
                for(int j = 0; j < 5; j++) {
                    wordcounts.get(j).add(letterVal(curword, (char)('a' + j)));
                }
            }

            for(int i = 0; i < wordcounts.size(); i++) {
                Collections.sort(wordcounts.get(i), Collections.reverseOrder());
            }

            int max = 0;
            for(int i = 0; i < wordcounts.size(); i++) {
                max = Math.max(max, getval(wordcounts.get(i)));
            }
            out.write(max + "\n");
           
        }
        out.close();
    }

    static int getval(ArrayList<Integer> lettervals) {
        int val = 0;
        int count = 0;
        for(int i = 0; i < lettervals.size(); i++) {
            if(lettervals.get(i) + val > 0) {
                val += lettervals.get(i);
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    static int letterVal(String word, char letter) {
        int lc = 0;
        int oc = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == letter) {
                lc++;
            } else {
                oc++;
            }
        }
        return lc - oc;
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
