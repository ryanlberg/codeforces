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
            Item[] nums = new Item[size];
            for(int i = 0; i < size; i++) {
                nums[i] = new Item(fr.nextInt());
            }

            Item[] sorted = strangesort(nums);
            boolean cando = true;
            for(int i = 1; i < sorted.length; i++) {
                if(sorted[i].val == sorted[i-1].val && sorted[i].parity == 1 && sorted[i-1].parity == 1) {
                    sorted[i].parity = 0;
                    sorted[i-1].parity = 0;
                }
                if(sorted[i-1].parity == 1) {
                    cando = false;
                    break;
                }
            }

            if(cando) {
                out.write("Yes\n");
            } else {
                out.write("No\n");
            }
            
        }
        out.close();
    }

    static Item[] strangesort(Item[] nums) {
        if(nums.length == 1) {
            return nums;
        }
        
        Item[] left;
        Item[] right;

        if(nums.length % 2 == 0) {
            left = new Item[nums.length/2];
            right = new Item[nums.length/2];
            for(int i = 0; i < nums.length/2; i++) {
                left[i] = nums[i];
                right[i] = nums[i + nums.length/2];
            }
        } else {
            left = new Item[nums.length/2 + 1];
            right = new Item[nums.length/2];
            for(int i = 0; i < nums.length/2+1; i++) {
                left[i] = nums[i];
            }
            for(int i = 0; i < nums.length/2; i++) {
                right[i] = nums[i+nums.length/2+1];
            }
        }

        Item[] a = strangesort(left);
        Item[] b = strangesort(right);
        
        return merge(a, b);
    }

    static Item[] merge(Item[] one, Item[] two) {
        Item[] ret = new Item[one.length + two.length];
        int reti = 0;
        int onei = 0;
        int twoi = 0;
        int swapped = 0;
        while (onei < one.length && twoi < two.length) {
            if(one[onei].val <= two[twoi].val) {
                ret[reti] = one[onei];
                if (swapped % 2 != 0) {
                    ret[reti].parity ^= 1;
                }
                reti++;
                onei++;
            } else {
                ret[reti] = two[twoi];
                    if((twoi + one.length - reti) % 2 != 0) {
                        ret[reti].parity ^= 1;
                    }
                reti++;
                twoi++;
                swapped++;
            }
        }

        while(onei < one.length) {
            ret[reti] = one[onei];
                if (swapped % 2 != 0) {
                    ret[reti].parity ^= 1;
                }
            reti++;
            onei++;
        }

        while(twoi < two.length) {
            ret[reti] = two[twoi];
            reti++;
            twoi++;
        }



        return ret;

    }

    static class Item implements Comparable<Item>{
        int parity;
        int val;

        public Item(int val) {
            this.parity = 0;
            this.val = val;
        }

        public int compareTo(Item that) {
            return Integer.compare(this.val, that.val);
        }

        public String toString() {
            return val + ", " + parity;
        }


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
