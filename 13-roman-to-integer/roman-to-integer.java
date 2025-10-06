class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for(int i =0; i < s.length(); i++){
            int curr = map.get(s.charAt(i));
            int next;
            if(i + 1 < s.length()){
                next = map.get(s.charAt(i+1));
            }else{
                next = 0;
            }

            if(curr < next){
                sum -= curr;
            }else{
                sum += curr;
            }
        }


        return sum;
    }
}
/*
My idea
Using hashset
For each character in the string
    if satisfy condition (in the symbol and i > i+1)
        convert into that number
    else if i < i+1
        take i+1 - i
    else
*/