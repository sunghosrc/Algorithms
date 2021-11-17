class TimeMap {
    Map<String,Map<Integer,String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<Integer,String>());
        }
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key)==null)
            return "";
        TreeMap<Integer,String> tmap = (TreeMap)map.get(key);
        Integer floor = tmap.floorKey(timestamp);
        if(floor==null)
            return "";
        else
            return map.get(key).get(floor);
    }
}
