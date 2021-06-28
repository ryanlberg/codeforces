import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
public class B {

    static ArrayList<HashSet<Integer>> locations;
    static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static ArrayList<String> frontier;
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            locations = new ArrayList<HashSet<Integer>>();
            for(int i = 0; i < 26; i++) { locations.add(new HashSet<Integer>());}
            int letters = fr.nextInt();
            char[] lets = fr.next().toCharArray();
            for(int i = 0; i < letters; i++) {
                locations.get(lets[i] - 'a').add(i);
            }

            for(int i = 1; i < 10; i++) {
                frontier = new ArrayList<String>();
                getstring("", i);
                boolean added = false;
               
                for(int j = 0; j < frontier.size(); j++) {
                    //System.out.println(frontier.get(j));
                    if(!contains(frontier.get(j), -1)) {
                        out.write(frontier.get(j) + "\n");
                        added = true;
                        break;
                        
                    }
                }    
                if(added) {
                    break;
                }     
            }


        }
        out.close();
    }

    static void getstring(String start, int length) {
        if(length == 0) {
            frontier.add(start);
        } else {
            for(int i = 0; i < 26; i++) {
                getstring(start + letters[i], length-1);
            }
        }
        
    }

    static boolean contains(String x, int lastseen) {
        if(x.length() == 0) {
            return true;
        }
        char needed = x.charAt(0);

        if(lastseen == -1) {
            for(Integer cur : locations.get(needed - 'a')) {
                boolean a = contains(x.substring(1), cur+1);
                if(a) {
                    return a;
                }
            }
        } else {
            if(locations.get(needed -'a').contains(lastseen)) {
                return contains(x.substring(1), lastseen+1);
            }
        }
        return false;
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
