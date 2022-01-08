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
            char[] n = fr.next().toCharArray();
            int i = 0;
            int j = size-1;
            ArrayList<Integer> start = new ArrayList<Integer>();
            Stack<Integer> end = new Stack<Integer>();
            while(i < j) {
                if(n[i] == '1' && n[j] == '0') {
                    start.add(i+1);
                    end.add(j+1);
                    i++;
                    j--;
                } else {
                    if(n[i] == '0') i++;
                    if(n[j] == '1') j--;
                } 

            }
            if(start.size() + end.size() == 0) {
                out.write(0 + "\n");
            } else {
                out.write(1 + "\n");
                out.write(start.size() + end.size() + " ");
                for(int x : start) out.write(x + " ");
                while(end.size()  > 0) out.write(end.pop() + " ");
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
