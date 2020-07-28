package algorithm.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

class TreeNode1{
    public List<TreeNode1> a;
    public int informTime;
    public TreeNode1 par;
    TreeNode1(int x){
        informTime=x;
        par=null;
        a=new ArrayList<>();
    }
}
public class zhousai {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
      TreeNode1 root=new TreeNode1(informTime[headID]);
      TreeNode1[] yuangong=new TreeNode1[n];
      for (int i=0;i<n;i++){
          TreeNode1 newNode=new TreeNode1(informTime[i]);

          yuangong[i]=newNode;
         // TreeNode newNode=new TreeNode(0);
      }
      for (int i=0;i<n;i++){
          if (manager[i]==-1){
              yuangong[i].par=root;
          }
          else yuangong[i].par=yuangong[manager[i]];
      }
      int max=0;
      for(int i=0;i<n;i++){
          if(yuangong[i].informTime==0){
              int t=dfs(yuangong[i]);
              max=max>t?max:t;
          }
      }
      return max;
    }

    int dfs(TreeNode1 root) {
        if (root.par==null) return 0;
        return root.informTime+dfs(root.par);
//        if (currentWorker == -1) {
//
//            for (int i = 0; i < n; i++) {
//                if (manager[i] == currentWorker) {
//                    int t = informTime[currentWorker] + dfs(i, n, manager, informTime);
//                    max = max > t ? max : t;
//                }
//            }
//        }
        //int max=0;
        //for (int i = 0; i < n; i++) {
//            if (manager[i] == currentWorker) {
//                int t = informTime[currentWorker] + dfs(i, n, manager, informTime);
//                max = max > t ? max : t;
//            }
//        }
//        return max;


    }

    public static void main(String[] argc) {
       // Sys
        //System.out.print(new zhousai().numOfMinutes(7,6,new int[]{1,2,3,4,5,6,-1},new int[]{0,6,5,4,3,2,1}));
//        int n=5;
//        StringBuffer s=new StringBuffer();
//        if((n&1)!=0){
//
//            for (int i=0;i<n;i++)
//                s.append((char)(97));
//    }else{
//            for (int i=0;i<n-1;i++)
//                s.append((char)(97));
//            s.append((char)98);
//        }
//        System.out.print(s.toString());
//        int[] light = new int[]{3, 2, 4, 1, 5};
//
//        int len = light.length;
//        boolean lights[] = new boolean[len + 1];
//        int sum = 0;
//        //int max_index[]=new int[len];
//        int max_index = light[0];
//        for (int i = 0; i < len; i++) {
//            lights[light[i]] = true;
//            int ison = 0;
//            max_index = max_index > light[i] ? max_index : light[i];
//            for (int j = max_index; j > 0; j--) {
//                if (lights[j]) ison++;
//                if (!lights[j]) break;
//            }
//            if (ison == max_index) {
//                sum++;
//                //System.out.print(a[i]);
//            }
//        }
//        System.out.print(sum);
    }
}
