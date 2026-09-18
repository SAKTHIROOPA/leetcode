class Solution {
   public int[] numberOfPairs(int[] nums) {
    int cnt[] = new int[101], pairs = 0;
    for (int n : nums)
        pairs += ++cnt[n] % 2 == 0 ? 1 : 0;
    return new int[] { pairs, nums.length - pairs * 2 };
}
}