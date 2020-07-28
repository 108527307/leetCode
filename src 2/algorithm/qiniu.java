package algorithm;

import java.util.Scanner;

public class qiniu {


    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        int M = Integer.parseInt(ss[1]);
        if (M < N - 1) {
            System.out.print("NO");
            return;
        }
        boolean adj[][] = new boolean[N][N];

        while (in.hasNext()) {

            String[] s = in.nextLine().split(" ");
            int x = Integer.parseInt(s[0])-1, y = Integer.parseInt(s[1])-1;
            if (x <= y)
                adj[x][y] = true;
            else {
                x = x + y - (y = x);
                adj[x][y] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i+1; j < N; j++) {
                if (!adj[i][j]) count++;
            }
            if(count==(N-i)){
                for(int k=0;k<i;k++){
                    if(!adj[k][i]) count--;
                }
                if(count==0){
                    System.out.print("NO");
                    return;
                }
            }
        }
        System.out.print("YES");


    }
}
