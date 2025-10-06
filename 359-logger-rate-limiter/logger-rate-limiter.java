class Logger {
    Map<String, Integer> map = new HashMap<>();

    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int allow = map.getOrDefault(message, Integer.MIN_VALUE);
        if(timestamp < allow) return false;

        map.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */