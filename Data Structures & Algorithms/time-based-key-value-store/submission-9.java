class TimeMap {
    Map<String, Map<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<>());
        } 
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        int mostRecentTime = 0;
        for (int time : map.get(key).keySet()) {
            if (time <= timestamp) {
                mostRecentTime = Math.max(mostRecentTime, time);
            }
        }
        if (mostRecentTime == 0) return "";
        return map.get(key).get(mostRecentTime);
    }
}
