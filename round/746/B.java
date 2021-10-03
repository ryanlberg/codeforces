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
            int x = fr.nextInt();
            int[] nums = new int[size];
            int[] check = new int[size];
           
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                nums[i] = cur;
                check[i] = cur;
            }

            sort(check);

            if(x <= (size/2)) {
                out.write("YES\n");
            } else {
                int mid = (size/2);
                boolean cando = true;
                
                for(int i =  mid; i < nums.length; i++) {
                    if(nums[i] != check[i]) {
                        if(i + x < size || i - x >= 0) {
                            continue;
                        } else {
                            cando = false;
                            break;
                        }
                    }
                }
                
                if(cando) {
                    for(int i = mid; i >= 0; i--) {
                        if(nums[i] != check[i]) {
                            if(i + x < size || i - x >= 0) {
                                continue;
                            } else {
                                cando = false;
                                break;
                            }
                        }
                    }
                }
                

                if(cando) {
                    out.write("YES\n");
                } else {
                    out.write("NO\n");
                }
            }
            

            
        }
        out.close();
    }

    static void sort(int[] nums) {
        ArrayList<Integer> tosort = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {tosort.add(nums[i]);}
        Collections.sort(tosort);
        for(int i = 0 ; i < nums.length; i++) {nums[i] = tosort.get(i);}
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
