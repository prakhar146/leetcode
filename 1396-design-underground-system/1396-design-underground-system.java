class UndergroundSystem {
    class Ticket {
        int customerId;
        String station;
        int time;
        
        Ticket(int id, String stationName, int t) {
            this.customerId = id;
            this.station = stationName;
            this.time = t;
        }
    }
    
    class TimePair {
        int total;
        int count;
        
        TimePair() {
            total = 0;
            count = 0;
        }
    }
    
    Map<Integer, Ticket> checkedIn;
    Map<String, TimePair> averages;

    public UndergroundSystem() {
        checkedIn = new HashMap<>();
        averages = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if(checkedIn.containsKey(id)) {
            return;
        }
        checkedIn.put(id, new Ticket(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Ticket checkinTicket = checkedIn.get(id);
        String sStation = checkinTicket.station;
        String dStation = stationName;
        String stationKey = getStationKey(sStation, dStation);
        if(!averages.containsKey(stationKey)) {
            averages.put(stationKey, new TimePair());
        }
        
        TimePair tp = averages.get(stationKey);
        int travelTime = t - checkinTicket.time;
        tp.total += travelTime;
        tp.count++;
        averages.put(stationKey, tp);
        checkedIn.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String stationKey = getStationKey(startStation, endStation);
        TimePair tp = averages.get(stationKey);
        double avg = ((double) tp.total / (double) tp.count);
        return avg;
    }
    
    private String getStationKey(String startStation, String endStation) {
        return startStation + "," + endStation;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */