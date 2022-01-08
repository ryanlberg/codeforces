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
            Deque<Integer> nums = new LinkedList<>();
            int[] order = new int[size];
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                nums.add(cur);
                order[i] = cur; 
            }

            Deque<Integer> begin = new LinkedList<>();
            Deque<Integer> ret = new LinkedList<>();

            while(nums.size() > 0) {
                int a = nums.peekFirst();
                int b = nums.peekLast();
                if(a > b) {
                    ret.addFirst(nums.peekFirst());
                    begin.addFirst(nums.pollFirst());
                } else {
                    ret.addLast(nums.peekLast());
                    begin.addLast(nums.pollLast());
                }
            }
            
            Deque<Integer> test = new LinkedList<>();

            while(begin.size() > 1) {
                int a = begin.peekFirst();
                int b = begin.peekLast();
                if(a < b) {
                    test.addFirst(begin.pollFirst());
                } else {
                    
                    test.addLast(begin.pollLast());
                }
            }

            if(order[0] == begin.peekFirst()) {
                
                test.addFirst(begin.pollFirst());
            } else {
                
                test.addLast(begin.pollLast());
            }

            int i = 0;
            boolean cando = true;
            while(test.size() > 0) {
                if(test.peekFirst() != order[i]) {
                    cando = false;
                    break;
                } else {
                    test.pollFirst();
                    i++;
                }
            }

            if(cando) {
                while(ret.size() > 0) {
                    out.write(ret.pollFirst() + " ");
                }
                out.write("\n");
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
