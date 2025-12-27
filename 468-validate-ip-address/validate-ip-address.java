class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.contains(".")){
            return (validateIPv4(queryIP)) ? "IPv4" : "Neither";
        }else if(queryIP.contains(":")){
            return (validateIPv6(queryIP)) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    private boolean validateIPv4(String ip){
        if(ip.startsWith(".") || ip.endsWith(".")){
            return false;
        }

        String[] arr = ip.split("\\.");

        //Checking array length
        if(arr.length != 4) return false;

        for(String idx : arr){ 

            //Empty value
            if(idx.isEmpty() || idx.length() > 3){
                return false;
            }

            //Checking leading zero
            if(idx.length() > 1 && idx.charAt(0) == '0'){
                return false;
            }

            //Checking is that number
            for(char c : idx.toCharArray()){
                if(!(c >= '0' && c <= '9')){
                    return false;
                }
            }

            //Checknig range 0-255
            int num = Integer.parseInt(idx);
            if(num < 0 || num > 255 ){
                return false;
            }
        }

        return true;
    }

    private boolean validateIPv6(String ip){
        if(ip.startsWith(":") || ip.endsWith(":")){
            return false;
        }

        String[] arr = ip.split("\\:");

        //Checking array length
        if(arr.length != 8) return false;

        for(String idx : arr){
            //Checking x(i) length
            if(idx.length() < 1 || idx.length() > 4){
                return false;
            }

            //Checking is hexadecimal string
            for(char c : idx.toCharArray()){
                if(!checkingHexa(c)){
                    return false;
                }
            }
        }

        return true;
    }

    //Helper Function
    private boolean checkingHexa(char c){
        if((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9')){
            return true;
        }

        return false;
    }
}