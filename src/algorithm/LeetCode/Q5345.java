package algorithm.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Q5345 {
    public String rankTeams(String[] votes) {
        //key是参赛团队，value是该团队每个排位获得的票数
        Map<Character, int[]> teamRankMap = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int[] rankArr = teamRankMap.getOrDefault(vote.charAt(i), new int[26]);
                rankArr[i]++;
                teamRankMap.put(vote.charAt(i), rankArr);
            }
        }

        List<Map.Entry<Character, int[]>> teamRankList = new ArrayList<>(teamRankMap.entrySet());
        Collections.sort(teamRankList, (team1, team2) -> {
            int[] ranks1 = team1.getValue();
            int[] ranks2 = team2.getValue();
            //根据投票排序
            for (int i = 0; i < 26; i++) {
                if (ranks1[i] != ranks2[i]) {
                    return ranks2[i] - ranks1[i];
                }
            }
            //字母顺序排序
            return team1.getKey() - team2.getKey();
        });

        //转换为字符串输出
        return teamRankList.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());
    }

    public String rankTeams1(String[] votes) {
        //首先建立一个hashmap来保存各个队伍每个排名的分数
        Map<Character, int[]> teamRankMa = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                //对每个投票字符串进行扫描，并且,将投票的结果添加到各个队伍对应的数组中去
                int[] oneTeamRank = teamRankMa.getOrDefault(vote.charAt(i), new int[26]);
                oneTeamRank[i]++;
                teamRankMa.put(vote.charAt(i), oneTeamRank);
            }
        }
        //将统计好的分数信息转换为list对象，用来排序
        List<Map.Entry<Character, int[]>> teamRankList = new ArrayList<>(teamRankMa.entrySet());
        Collections.sort(teamRankList, (team1, team2) -> {
            int[] team1Rank = team1.getValue();
            int[] team2Rank = team2.getValue();
            //26个排名中，从高名次开始比较，若高名次有结果，则直接返回这两个队的比较结果，若高名次票数相同，则继续向低名次票数比较，知道比出结果，若都相同，则按字母顺序比较
            for (int i = 0; i < 26; i++) {
                if (team1Rank[i] != team2Rank[i])
                    return team2Rank[i] - team1Rank[i];//按照降序
            }
            //若分数相同，则按照字母大小排序
            return team1.getKey() - team2.getKey();
        });
        return teamRankList.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());
    }
}
