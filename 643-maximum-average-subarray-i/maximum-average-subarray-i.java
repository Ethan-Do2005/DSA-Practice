public class Solution {
    public double findMaxAverage(int[] num, int k){
        double sum = 0 ;

        for(int i =0; i<k; i++){
            sum+=num[i];
        }

        double max = sum;
        for(int i = k ;  i < num.length ;i++){
            sum = sum - num[i-k] + num[i];
            max = Math.max(max, sum);
        }

        return max/k;
    }
}



// public class Solution {
//     public double findMaxAverage(int[] nums, int k) {
//         double sum=0;
//         for(int i=0;i<k;i++)
//             sum+=nums[i];
//         double res=sum;
//         for(int i=k;i<nums.length;i++){
//             sum+=nums[i]-nums[i-k];
//                 res=Math.max(res,sum);
//         }
//         return res/k;
//     }
// }
