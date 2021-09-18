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
            int chapters = fr.nextInt();
            TreeSet<Integer> chaps = new TreeSet<>();
            HashSet<Integer> understood = new HashSet<>();
            for(int i = 1; i <= chapters; i++) {
                chaps.add(i);
            }

            HashMap<Integer, HashSet<Integer>> needed = new HashMap<>();
            for(int i = 0; i < chapters; i++) {
                needed.put(i+1, new HashSet<Integer>());
                int understand = fr.nextInt();
                for(int j = 0; j < understand; j++) {
                    needed.get(i+1).add(fr.nextInt());
                }
            }


            int times = 0;
            boolean lastadded = true;
            while(understood.size() < chapters && lastadded) {
                lastadded = false;
                times++;
                for(Integer chap : chaps) {
                    if(!understood.contains(chap)) {
                        if(needed.get(chap).size() == 0) {
                            understood.add(chap);
                            //chaps.remove(chap);
                            lastadded = true;
                        } else {
                            boolean canadd = true;
                            for(Integer x : needed.get(chap)) {
                                if(!understood.contains(x)) {
                                    canadd = false;
                                    break;
                                }
                                if(canadd) {
                                    understood.add(chap);
                                    //chaps.remove(chap);
                                    lastadded = true;
                                }
                            }

                        }
                    }
                }
            }

            if(understood.size() == chapters) {
                out.write(times + "\n");
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
