package javaTest;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
    //哈希数组的长度初始化为8
    private int size = 8;
    private int number = 0;//存储的节点的个数
    //哈希数组
    private ArrayList<LinkedList> array_head = new ArrayList<LinkedList>(size);

    //构造方法
    public MyHash() {
        for(int i=0;i<size;i++) {
            LinkedList mylist = new LinkedList();//哈希数组中初始化存储的为空链表头
            array_head.add(mylist);//初始化的时候就将空节点头添加到数组中去
        }
    }


    /**
     * 根据 键值对 生成节点
     * 将节点放入哈希表中
     * @param key 键
     * @param value 值
     */
    public void put(Object key,Object value) {
        if(number/size == 10) {
            rehash();
        }
        number++;
        Node new_node = new Node(key,value);//由传入的参数生成新节点

        int code = hashcode(key.toString());//得到哈希码
        int position = locate(code);//得到该哈希码所对应的哈希数组中的位置

        //找到该位置对应的链表头
        LinkedList list_head = (LinkedList) array_head.get(position);

        //将节点放入哈希表中
        list_head.add(new_node);
    }


    /**
     *
     */
    private void rehash() {


    }


    /**
     * @param key
     * @param value
     * @return 返回键值对应得节点
     */
    public Object get(Object key) {

        int code = hashcode(key.toString());//得到哈希码
        int position = locate(code);//得到该哈希码所对应的哈希数组中的位置

        //找到该位置对应的链表
        LinkedList list_head = (LinkedList) array_head.get(position);

        //从头遍历链表 ，找到与键key对应的节点的value值进行输出
        for(int i=0;i<list_head.size();i++) {
            //首先拿到头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node!=null) {
                //如果 键 相等
                if(node.getKey().equals(key)) {
//					System.out.println("node.getValue() :"+node.getValue());
                    return node.getValue();
                }
                node = node.getNext();
            }
        }

        return null;//否则返回空
    }


    /**
     * 移除键为key的节点
     * @param key
     * @return 返回删除节点的key对应的value
     */
    public Object remove(Object key) {
        number--;
        int code = hashcode(key.toString());//得到哈希码
        int position = locate(code);//得到该哈希码所对应的哈希数组中的位置

        //找到该位置对应的链表
        LinkedList list_head = (LinkedList) array_head.get(position);

        //从头遍历链表 ，找到与键key对应的节点的value值进行输出
        for(int i=0;i<list_head.size();i++) {
            //首先拿到头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node!=null) {

                //如果 键 相等
                if(node.getKey().equals(key)) {
                    Object value = node.getValue();
                    list_head.remove(node);
                    return value;
                }
                node = node.getNext();
            }
        }
        return null;//否则返回空

    }


    public Object replace(Object key,Object newvalue) {
        System.out.println("replace");
        int code = hashcode(key.toString());//得到哈希码
        int position = locate(code);//得到该哈希码所对应的哈希数组中的位置

        //找到该位置对应的链表
        LinkedList list_head = (LinkedList) array_head.get(position);

        //从头遍历链表 ，找到与键key对应的节点的value值进行输出
        for(int i=0;i<list_head.size();i++) {
            //首先拿到头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node!=null) {
                //如果 键 相等
                if(node.getKey().equals(key)) {
                    Object oldvalue = node.getValue();
                    node.setValue(newvalue);
                    return oldvalue;
                }
                node = node.getNext();
            }
        }
        return null;//否则返回空


    }

    /**
     * @param key
     * @return 哈希表中含有该key，返回true
     */
    public boolean containsKey(Object key) {

        int code = hashcode(key.toString());//得到哈希码
        int position = locate(code);//得到该哈希码所对应的哈希数组中的位置

        //找到该位置对应的链表
        LinkedList list_head = (LinkedList) array_head.get(position);

        //从头遍历链表 ，找到与键key对应的节点的value值进行输出
        for(int i=0;i<list_head.size();i++) {
            //首先拿到头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node!=null) {

                //如果 键 相等
                if(node.getKey().equals(key)) {
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;//否则返回空

    }


    public Object containsValue(Object value) {

        //找到该位置对应的链表

        for(int k=0;k<size;k++) {
            LinkedList list_head = (LinkedList) array_head.get(k);

            //从头遍历链表 ，找到与键key对应的节点的value值进行输出
            for(int i=0;i<list_head.size();i++) {
                //首先拿到头节点
                Node head = (Node) list_head.get(i);
                Node node = head;
                while(node!=null) {

                    //如果 键 相等
                    if(node.getValue().equals(value)) {
                        return true;
                    }
                    node = node.getNext();
                }
            }
        }
        return false;//否则返回空

    }



    /**
     * 打印哈希表
     */
    public void show() {
        System.out.println("打印哈希表");
        for(int i=0;i<size;i++) {
            LinkedList list_head = array_head.get(i);//得到链表头
            System.out.println("链表 ："+(i+1));
            for(int j=0;j<list_head.size();j++) {
                Node head = (Node) list_head.get(j);//取出每个节点
                Node node = head;
                while(node!=null) {
                    //打印出每个节点得键值对
                    System.out.print("节点"+(j+1)+" :("+node.getKey()+":"+node.getValue()+")"+"-->");
                    node = node.getNext();
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     *
     * @return 返回存储的节点的个数
     */
    public int size() {

        return number;

    }



    /**
     * 清除哈希表中的所有元素
     */
    public void clear() {
        for(int i=0;i<size;i++) {

            LinkedList list_head = array_head.get(i);//得到链表头
            list_head.clear();

        }
        number = 0;
    }



    /**
     * 计算字符串的哈希码
     * ASCII码相加
     * @param s
     * @return
     */
    public int hashcode(String s) {
        int k = 0;
        for(int i=0;i<s.length();i++) {
            k += s.charAt(i);
        }
        return k;
    }

    /**
     * 得到哈希码对应在数组中的位置
     * @param k
     * @return
     */
    public int locate(int k) {
        int m = k%size;
        return m;
    }
}

