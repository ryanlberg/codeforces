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
        int heroes = fr.nextInt();
        int[] heros = new int[heroes];

        int totalpow = 0;

        for(int i = 0; i < heroes; i++) {
            heros[i] = fr.nextInt();
            totalpow += heros[i];
        }

        sort(heros);

        int dragons = fr.nextInt();
        for(int i = 0; i < dragons; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            int minleft = findClosest(heros, x);
            int minright = findClosest(heros, y);

            int a = 0;
            int b = 0;

            if(minleft < x) {
                a += x - minleft;
            }

            if((totalpow - minleft) < y) {
                a += y - (totalpow-minleft);
            }

            if(minright < x) {
                b += x - minright;
            }
            if((totalpow - minright) < y) {
                b += y - (totalpow-minright);
            }

            out.write(Math.min(a, b) + "\n");
        }
       
        out.close();
    }

    static void sort(int[] needs) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < needs.length; i++) {temp.add(needs[i]);}
        Collections.sort(temp);
        for(int i = 0; i < needs.length; i++) {needs[i] = temp.get(i);}
    }

    static int findClosest(int[] heros, int needed) {
        int start = 0;
        int end = heros.length-1;
        int closest_seen = Integer.MAX_VALUE;
        int dif = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start+end)/2;
            if(heros[mid] == needed) {
                return heros[mid];
            } 
            if(Math.abs(needed - heros[mid]) < dif) {
                dif = Math.abs(needed-heros[mid]);
                closest_seen  = heros[mid];
            }
            if(needed < heros[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return closest_seen;
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
