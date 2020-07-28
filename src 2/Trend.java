public class Trend {
    //*
    //  A city skyline can be represented as a 2-D list with 1s representing buildings.
    // In the example below, the height of the tallest building is 4 (second-most right column). 
    // [[0, 0, 0, 0, 0, 0], 
    // [0, 0, 0, 0, 1, 0], 
    // [0, 0, 1, 0, 1, 0], 
    // [0, 1, 1, 1, 1, 0],
    // [1, 1, 1, 1, 1, 1]] 
    //  Create a function that takes a skyline (2-D list of 0's and 1's) and returns the height of the tallest skyscraper.  
    // Examples  tallest_skyscraper([ 
    // [0, 0, 0, 0], 
    //  [0, 1, 0, 0], 
    //  [0, 1, 1, 0], 
    // [1, 1, 1, 1] ]) ➞ 3  
    // tallest_skyscraper([ 
    // [0, 1, 0, 0], 
    //  [0, 1, 0, 0], 
    // [0, 1, 1, 0], 
    //  [1, 1, 1, 1] ]) ➞ 4  tallest_skyscraper([ 
    //  [0, 0, 0, 0],   [0, 0, 0, 0],   [1, 1, 1, 0],   [1, 1, 1, 1] ]) ➞ 2 
    // */
    public static int tallest(int[][] nums){
        int max=0;
        for(int i=0;i<nums[0].length;i++){
            int temp_height=0;
            for(int j=0;j<nums.length;j++){
                temp_height+=nums[j][i];
            }
            max=max>temp_height?max:temp_height;
        }
        return max;
    }
    public static void main(String[] argc){
        int[][] heights={{0,1,0,0},{0,1,0,0},{0,1,1,0},{1,1,1,1}};
        System.out.println(tallest(heights));
    }
}
