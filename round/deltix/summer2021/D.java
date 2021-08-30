import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class D {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
       
      

        int n = fr.nextInt();
        int k = fr.nextInt();
        int[] curand = new int[n];
        int[] firstthree = new int[3];

        for(int i = 0; i < 3; i++) {
            if(i < 2) {
                System.out.println("and " + (i + 1) + " " + (i + 2));
                System.out.flush();
                firstthree[i] = fr.nextInt();
                System.out.println("or " + (i + 1) + " " + (i + 2));
                System.out.flush();
                firstthree[i] += fr.nextInt();
            } else {
                System.out.println("and " + (1) + " " + (3));
                System.out.flush();
                firstthree[i] = fr.nextInt();
                System.out.println("or " + (1) + " " + (3));
                System.out.flush();
                firstthree[i] += fr.nextInt();
            }
        }
        curand[1] = (firstthree[0] + firstthree[1] - firstthree[2])/2;
        curand[2] = (firstthree[1] + firstthree[2] - firstthree[0])/2;
        curand[0] = (firstthree[0] + firstthree[2] - firstthree[1])/2;

        for(int i = 3; i < n; i++) {
            int cur = 0;
            System.out.println("and " + (i-1) + " " + i);
            System.out.flush();
            cur = fr.nextInt();
            System.out.println("or " + (i-1) + " " + i);
            System.out.flush();
            cur += fr.nextInt();
            curand[i] = (cur - curand[i-1]);
        }
        
        int[] s = sort(curand);
        out.write(s[k-1]+ "\n");
    
        
        out.close();
    }

    static int[] sort(int[] nums) {
        ArrayList<Integer> numbas = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) { numbas.add(nums[i]);}
        Collections.sort(numbas);
        for(int i = 0; i < nums.length; i++) { nums[i] = numbas.get(i);}
        return nums;
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
