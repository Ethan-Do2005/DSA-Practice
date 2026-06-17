class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        dict = {}
        for idx, val in enumerate(nums):
            complement = target - val

            if complement in dict:
                return [dict[complement], idx]
            
            dict[val] = idx