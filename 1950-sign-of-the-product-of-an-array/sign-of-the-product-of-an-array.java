class Solution {
    public int arraySign(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = sgn(nums[0]);
        if (res[0] == 0) return 0;

        for (int i = 1; i < n; i++) {
            int si = sgn(nums[i]);
            if (si == 0) return 0;          // zero anywhere ⇒ sign 0
            res[i] = res[i - 1] * si;       // stays in {-1, +1}
        }
        return res[n - 1];                   // already -1 or +1
    }

    private int sgn(int x) { return x > 0 ? 1 : (x < 0 ? -1 : 0); }
}
