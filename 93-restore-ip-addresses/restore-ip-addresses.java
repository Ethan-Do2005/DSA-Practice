class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if(!(s.length() >=4 && s.length() <= 12)){
                return result;
            }

        backtrack(0, s, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int idx, String s, List<String> segments, List<String> result){
        
        //Condition: valid for 4 parts AND for all char in string
        if(segments.size() == 4  && idx >= s.length()){
            result.add(String.join(".", segments));
            return;
        }

        //Condition: valid for 4 parts OR go through all char in string
        if(segments.size() == 4 || idx >= s.length()){
            return;
        }

        //Taking 1,2,3 digit
        for(int lenString = 1; lenString <= 3; lenString++){
            if(idx + lenString > s.length()) break;

            String segment = s.substring(idx, idx + lenString);
            if(isValid(segment)){
                segments.add(segment);
                backtrack(idx + lenString, s, segments, result);
                segments.remove(segments.size() - 1);
            }
        }
    }

    private boolean isValid(String segment){
        if(segment.length() > 1 && segment.charAt(0) == '0'){
            return false;
        }

        int num = Integer.parseInt(segment);
        return (num >= 0 && num <= 255);
    }
}
/*
Key constraints:
Requirement:
1.Exactly 4 parts: 3 dots for an length     
Condition
3.Limit number: 0 to 255 (3 digtis)
4.Not leading zero:

*/