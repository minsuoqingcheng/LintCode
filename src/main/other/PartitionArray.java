package main.other;

public class PartitionArray {

    /**
     * @param array:
     *        assuming that the input array is the combination of two n-sized array.
     * @return int :
     *        minimal difference of the two n-sized subsets.
     */
    public static int minimalSum (int[] array){
        int total = sum(array);
        int sum = total/2;
        int n=array.length/2;

        //dp[i][v] = true means that there's i elements added up to value v.
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0]=true;

        for(int k=1;k<=2*n;k++){
            int val = array[k-1];
            for(int i=1;i<=k&&i<=n;i++){
                for(int v=1;v<=sum;v++){
                    //try to take k as i th element
                    if(v>=val && dp[i-1][v-val])
                        dp[i][v]=true;
                }
            }
        }
        //find the answer. we need n-sized subset, so just check dp[n][*].
        for(int i=sum;i>0;i--){
            if(dp[n][i])
            /**
             * we find a subset with size=n and sum=i,another subset will have sum=total-i
             * so the difference will be (total-i)-i=total-2*i
             */
                return total-2*i;
        }
        return -1;
    }

    private static int sum(int[] array){
        int sum=0;
        for(int i:array)
            sum+=i;
        return sum;
    }


    public static void main(String[] args) {
        int differ = PartitionArray.minimalSum(new int[]{100, 99, 98, 1, 2, 3, 1, 2, 3, 4, 5, 40});
        System.out.println(differ);
    }
}
