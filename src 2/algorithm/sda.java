package algorithm;

import com.sun.javafx.geom.Edge;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class sda {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public int sol(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list1.sort((i,j)->{
            String si=String.valueOf(i),sj=String.valueOf(j);
            int ilen=si.length();
            int jlen=sj.length();
            int ie=0,je=0;
            while(ie<ilen&&je<jlen){
                if((int)si.charAt(ie)<(int)sj.charAt(je))
                    return 1;
                else if((int)si.charAt(ie)>(int)sj.charAt(je))
                    return -1;
                ie++;
                je++;
            }
            if(ie==ilen&&je==jlen) return 0;
            if(ie!=ilen) return -1;
            else return 1;

        });
        int max = 0;
        for (int i = 0; i < list1.size(); i++) {
            int temp = list1.get(i);
            list1.remove(i);
            int subMax = lengthOfLIS(list1.stream().mapToInt(Integer::valueOf).toArray());
            max = max > subMax ? max : subMax;
            list1.add(i, temp);
        }
        return max;

    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int re = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i])
                    dp[i] = dp[i] > (dp[j] + 1) ? dp[i] : (dp[j] + 1);
            }
            re = re > dp[i] ? re : dp[i];
        }
        return re;
    }

    private class Vertex {
        private int vertexLabel;//顶点标识
        private List<sda.Edge> adjEdges;//与该顶点邻接的边(点)
        private int dist;//顶点距离(该顶点到起始顶点的距离)
        private Vertex preNode;

        public Vertex(int vertexLabel) {
            this.vertexLabel = vertexLabel;
            adjEdges = new LinkedList<>();
            dist = Integer.MAX_VALUE;
            preNode = null;
        }
    }

    private class Edge {
        private Vertex endVertex;
        private int m;
        public Edge(Vertex endVertex,int m) {
            this.m=m;
            this.endVertex = endVertex;
        }
    }

    private Map<Integer, Vertex> nonDirectedGraph;//保存了图中所有的顶点，边的关系以List形式保存在Vertex类中

    private Vertex startVertex;//图的起始顶点

    public void buildGraph(String[] content) {
        nonDirectedGraph = new LinkedHashMap<>();

        String startNodeLabel, endNodeLabel;
        Vertex startNode, endNode;
        for (int i = 0; i < content.length; i++) {
            String[] nodesInfo = content[i].split(" ");
            startNodeLabel = nodesInfo[0];
            endNodeLabel = nodesInfo[1];

            endNode = nonDirectedGraph.get(endNodeLabel);
            if (endNode == null) {
                endNode = new Vertex(Integer.parseInt(endNodeLabel));
                nonDirectedGraph.put(Integer.parseInt(endNodeLabel), endNode);
            }

            startNode = nonDirectedGraph.get(startNodeLabel);
            if (startNode == null) {
                startNode = new Vertex(Integer.parseInt(startNodeLabel));
                nonDirectedGraph.put(Integer.parseInt(startNodeLabel), startNode);
            }
            Edge e = new Edge(endNode, Integer.parseInt(nodesInfo[2]));
            //对于无向图而言,起点和终点都要添加边
            endNode.adjEdges.add(e);
            startNode.adjEdges.add(e);

        }
    }


    public static void main(String[] argc) {
        int[] nums={34,123,342,340,3,4};
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list1.sort((i,j)->{
            String si=String.valueOf(i),sj=String.valueOf(j);
            int ilen=si.length();
            int jlen=sj.length();
            int ie=0,je=0;
            while(ie<ilen&&je<jlen){
                if((int)si.charAt(ie)<(int)sj.charAt(je))
                    return -1;
                else if((int)si.charAt(ie)>(int)sj.charAt(je))
                    return 1;
                ie++;
                je++;
            }
            if(ie==ilen&&je==jlen) return 0;
            if(ie!=ilen) return 1;
            else return -1;

        });
            System.out.println(new sda().lengthOfLIS2(new int[]{1, 0, 1, 0, 0, 1, 1}));
    }
}
