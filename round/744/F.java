import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class F {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
           ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
           int size = fr.nextInt();
           int d = fr.nextInt();
           int[] numbers = new int[size];
           for(int i = 0; i < size; i++) {
               int cur = fr.nextInt();
                numbers[i] = cur;
           }
           HashSet<Integer> seen = new HashSet<>();
           for(int i = 0; i < size; i++) {
               int cur = i;
               ArrayList<Integer> next = new ArrayList<>();
               while(!seen.contains(cur)) {
                   seen.add(cur);
                   next.add(numbers[cur]);
                   cur = (cur+d)%size;
               }
               if(next.size() > 0) {
                   nums.add(next);
               }
           }

           boolean cando = true;
           int max = 0;
           for(ArrayList<Integer> x : nums) {
             
               int[] retvals = candonum(x);
               if(retvals[1] == 1) {
                   cando = false;
                   break;
               } else {
                   max = Math.max(max, retvals[0]);
               }
           }

           if(cando) {
               out.write(max + "\n");
           } else {
               out.write(-1 + "\n");
           }

        }
        out.close();
    }

    static int[] candonum(ArrayList<Integer> curnums) {
        int[] l = new int[curnums.size()*2];
        int[] ret = new int[2];
        for(int i = 0; i < curnums.size(); i++){
            l[i] = curnums.get(i);
            l[i+curnums.size()] = curnums.get(i);
        }
        // for(int x : l) {
        //     System.out.print(x + " ");
        // } 
        // System.out.println("");
        int cur = 0;
        if(l[0] == 1) {
            cur++;
        }
        ret[0] = Math.max(ret[0], cur);
        for(int i = 1; i < l.length; i++) {
            if(l[i] == 1) {
                cur++;
            } else {
                cur = 0;
            }
            ret[0] = Math.max(ret[0], cur);
        }

        if(ret[0] == curnums.size()*2) {
            ret[1] = 1;
        }

        return ret;
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
