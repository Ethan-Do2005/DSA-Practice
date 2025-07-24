class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanNum = new HashMap<>();

        romanNum.put('I', 1);
        romanNum.put('V', 5);
        romanNum.put('X', 10);
        romanNum.put('L', 50);
        romanNum.put('C', 100);
        romanNum.put('D', 500);
        romanNum.put('M', 1000);

        int total = 0;
        for(int i = 0; i < s.length(); i++){
            int currentVal = romanNum.get(s.charAt(i));

            if(i + 1 < s.length() && currentVal < romanNum.get(s.charAt(i+1))){
                total -= currentVal;
            }
            else{
                total += currentVal;
            }
        }

        return total;
    }
}