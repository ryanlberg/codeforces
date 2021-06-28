import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class B {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] counter = new int[3];
            int needed = size/3;
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                int spot = cur%3;
                counter[spot]++;
            }
            int ret = 0;
            
            while(counter[0] != needed || counter[1] != needed || counter[2] != needed) {
                //out.write(counter[0]+ " " + counter[1] + " " + counter[2] + "\n");
                if (counter[0] > needed) {
                    ret += counter[0]-needed;
                    counter[1] += counter[0] - needed;
                    counter[0] = needed; 
                }
                if (counter[1] > needed) {
                    ret += counter[1] - needed;
                    counter[2] += counter[1] - needed;
                    counter[1] = needed;
                }
                if(counter[2] > needed) {
                    ret += counter[2] - needed;
                    counter[0] += counter[2] - needed;
                    counter[2] = needed;
                }
                //out.write(counter[0]+ " " + counter[1] + " " + counter[2] + "\n");
            }
            
            out.write(ret + "\n");
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
