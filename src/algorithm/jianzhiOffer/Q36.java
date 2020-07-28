package algorithm.jianzhiOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val,Node2 _left,Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class Q36 {

    //0ms
    Node2 pre=null,head=null;
    public Node2 treeToDoublyList(Node2 root) {
        if(root==null) return null;

        inOrder(root);
        pre.right=head;
        head.left=pre;
        return head;
    }
    void inOrder(Node2 root){
        if(root==null) return;
        inOrder(root.left);
        root.left=pre;
        if(pre!=null) pre.right=root;
        else head=root;
        pre=root;
        inOrder(root.right);
    }


//2ms
     List<Node2> list=new ArrayList();
    public Node2 treeToDoublyList2(Node2 root) {
        if(root==null) return null;

        inOrder2(root);

         int size=list.size();
         if(size==1) {
             root.left=root.right=root;
             return root;
         }
         list.get(0).right=list.get(1);
         list.get(0).left=list.get(size-1);
         list.get(size-1).left=list.get(size-2);
         list.get(size-1).right=list.get(0);
         if(size==2){
             return list.get(0);
         }
         for(int i=1;i<size-1;i++){
                 list.get(i).right=list.get(i+1);
                 list.get(size-i-1).left=list.get(size-i-2);
         }
         return list.get(0);
    }
    void inOrder2(Node2 root){
        if(root==null) return;
        inOrder2(root.left);
        list.add(root);
        inOrder2(root.right);
    }


}
