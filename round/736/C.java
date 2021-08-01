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
        int nobles = fr.nextInt();
        int friendships = fr.nextInt();

        G[] dudes = new G[nobles+1];
        for(int i  = 1; i < nobles+1; i++) {
            dudes[i] = new G();
        }

        int nobles_alive = nobles;
        
        for(int i = 0; i < friendships; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            boolean alive_a = dudes[a].isAlive();
            boolean alive_b = dudes[b].isAlive();
            dudes[a].addFriend(b, a);
            dudes[b].addFriend(a, b);
           
            if(alive_a && !dudes[a].isAlive()) {
                nobles_alive--;
            }
            if(alive_b && !dudes[b].isAlive()) {
                nobles_alive--;
            }
        }

        int q = fr.nextInt();
       
        for(int i = 0; i < q; i++) {
            int type = fr.nextInt();
            if(type == 1) {
                
                int a = fr.nextInt();
                int b = fr.nextInt();
                boolean alive_a = dudes[a].isAlive();
                boolean alive_b = dudes[b].isAlive();
                dudes[a].addFriend(b, a);
                dudes[b].addFriend(a, b);
                if(alive_a && !dudes[a].isAlive()) {
                    nobles_alive--;
                }
                if(alive_b && !dudes[b].isAlive()) {
                    nobles_alive--;
                }

            }

            else if(type == 2) {
                
                int a = fr.nextInt();
                int b = fr.nextInt();
                boolean alive_a = dudes[a].isAlive();
                boolean alive_b = dudes[b].isAlive();
                dudes[a].removeFriend(b, a);
                dudes[b].removeFriend(a, b);
                
                if(!alive_a && dudes[a].isAlive()) {
                    nobles_alive++;
                }
                if(!alive_b && dudes[b].isAlive()) {
                    nobles_alive++;
                }

            } else {
                
                out.write(nobles_alive + "\n");
            }
        }
        out.close();
    }


    static int got_it(G[] nobles) {
        int left_alive = 0;
       
        for(int i = 1; i < nobles.length; i++) {
            if(nobles[i].friends.size() == 0 || nobles[i].friends.last() < i) {
                left_alive++;
            }
        }  
        return left_alive;
    }

    static class G {
        
        TreeSet<Integer> friends;
        boolean alive;

        public G() {
            this.friends = new TreeSet<>();
            this.alive = true;
        }

        public void addFriend(int x, int i) {
            this.friends.add(x);
            if(x > i) {
                this.kill();
            }
        }

        public void removeFriend(int x, int i) {
            this.friends.remove(x);
            if(x > i) {
                if(this.friends.size() == 0 || this.friends.last() < i) {
                    this.revive();
                }
            }
        }

        public void kill() {
            this.alive = false;
        }

        public void revive() {
            this.alive = true;
        }

        public boolean isAlive() {
            return this.alive;
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
