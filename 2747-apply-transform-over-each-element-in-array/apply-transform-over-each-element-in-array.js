/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let newArr = [];

    for(let i = 0; i < arr.length; i++){
        arr[i] = fn(arr[i], i);
        newArr.push(arr[i]);
    }

    return newArr;
};