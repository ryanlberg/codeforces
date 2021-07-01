import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class D {

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int n = fr.nextInt();
        boolean[][] cons = new boolean[n][n];
        ArrayList<Integer> oddaway = new ArrayList<>();
        ArrayList<Integer> evenaway = new ArrayList<>();
        System.out.println("? 1\n");
        System.out.flush();
        ArrayList<Integer> resp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            resp.add(fr.nextInt());
        }
        
        for(int i = 0; i < resp.size(); i++) {
            if(resp.get(i) % 2 == 0) {
                if(resp.get(i) != 0) {
                    evenaway.add(i+1);
                }
                
            } else {
                oddaway.add(i+1);
            } 
            if(resp.get(i) == 1) {
                cons[i][0] = true;
                cons[0][i] = true;
            }
        }
        if (evenaway.size() +1 <= (n+1)/2) {
            for(Integer x: evenaway) {
                System.out.println("? " + (x) + "\n");
                System.out.flush();
                resp = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    resp.add(fr.nextInt());
                }
                for(int j = 0; j < resp.size(); j++) {
                    if(resp.get(j) == 1) {
                        cons[x-1][j] = true;
                        cons[j][x-1] = true;
                    }
                }
            }
           
        } else {
            for(Integer x: oddaway) {
                System.out.println("? " + (x) + "\n");
                System.out.flush();
                resp = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    resp.add(fr.nextInt());
                }
                for(int j = 0; j < resp.size(); j++) {
                    if(resp.get(j) == 1) {
                        cons[x-1][j] = true;
                        cons[j][x-1] = true;
                    }
                }
            }
        }

        out.write("!\n");
        for(int i = 0; i < cons.length; i++) {
            for(int j = i+1; j < cons.length; j++) {
                if (cons[i][j]) {
                    out.write((i+1) + " " + (j+1) + "\n");
                }
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
