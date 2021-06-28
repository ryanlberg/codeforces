import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
public class C {

    static ArrayList<Integer> nums;
   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int left = fr.nextInt();
            int right = fr.nextInt();
            nums  = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                nums.add(fr.nextInt());
            }
            Collections.sort(nums);
            long total = 0;
            for(int i = 0; i < size-1; i++) {
                if (nums.get(i) >= right || nums.get(i) >= left) {
                    break;
                }
                int l = getclosestl(i+1, nums.size()-1, left-nums.get(i)-1);
                int r = getclosestl(i+1, nums.size()-1, right-nums.get(i)+1);
                while(l < size-1 && nums.get(l) + nums.get(i) < left) l++;
                while(r > 0 && nums.get(r) + nums.get(i) > right) r--;
                if (l == r) {
                    int a = nums.get(l) + nums.get(i);
                    if(a >= left && a <= right) {
                        total += 1;
                    }
                } else {
                    total += (r+1 - l);
                }

            }
            out.write(total + "\n");
        }
        out.close();
    }

    static int getclosestl(int start, int end, int value) {
        if(nums.get(start) == value) {
            return start;
        }
    
        while (start < end) {
            int mid = start + (end - start) / 2;
            if(nums.get(mid) == value) {
                return mid;
            }
            if(value > nums.get(mid)) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
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
