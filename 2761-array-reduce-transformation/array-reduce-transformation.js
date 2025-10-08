/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let accum = init;
    for(const index in nums){
        accum = fn(accum, nums[index]);
    }
    return accum;
};