import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] in = new int[size];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < size; i++) {
                in[i] = fr.nextInt();
                map.put(in[i], i);
            }
            String ratings = fr.next();
            ArrayList<Integer> likes = new ArrayList<>();
            ArrayList<Integer> dislikes = new ArrayList<>();

            for(int i = 0; i < ratings.length(); i++) {
                if(ratings.charAt(i) == '0') {
                    dislikes.add(in[i]);
                } else {
                    likes.add(in[i]);
                }
            }
            Collections.sort(likes);
            Collections.sort(dislikes);
            if(dislikes.size() == 0) {
                for(int x : in) {
                    out.write(x + " ");
                }
                out.write("\n");
            } else {
                int[] ret = new int[size];
                int i = 1;
                for(int x : dislikes) {
                    ret[map.get(x)] = i;
                    i++;
                    
                }
                for(int x : likes) {
                    ret[map.get(x)] = i;
                    i++;
                }

                for(int x : ret) {
                    out.write(x + " ");
                }
                out.write("\n");
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
