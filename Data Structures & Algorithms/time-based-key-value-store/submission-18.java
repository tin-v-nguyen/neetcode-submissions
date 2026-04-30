class TimeMap {
    class TVPair {
        int time;
        String value;
        public TVPair(Integer time, String value) {
            this.time = time;
            this.value = value;
        }
        
    }
    Map<String, List<TVPair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        } 
        map.get(key).add(new TVPair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        TVPair mostRecent = new TVPair(-1 , null);
        List<TVPair> timeArray = map.get(key);
        int l = 0;
        int r = timeArray.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (timeArray.get(m).time <= timestamp) {
                mostRecent = timeArray.get(m).time > mostRecent.time ? timeArray.get(m) : mostRecent;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (mostRecent.time == -1) return "";
        return mostRecent.value;
    }
}
