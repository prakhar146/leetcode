class MyCalendar {
    List<int[]> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(events.size() == 0) {
            events.add(new int[]{start, end});
            return true;
        }
        int justBeforeEventIdx = getNearestBefore(start);
        int[] justBeforeEvent = new int[2];
        int[] justAfterEvent = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        if(justBeforeEventIdx > -1) {
            justBeforeEvent = events.get(justBeforeEventIdx);
            if((justBeforeEventIdx + 1) < events.size()) {
                justAfterEvent = events.get(justBeforeEventIdx + 1);
            }
        } else {
            justAfterEvent = events.get(0);
        }
        // int[] justAfterEvent = getNearestAfter(end);
        if(justBeforeEvent[1] <= start && justAfterEvent[0] >= end) {
            events.add(new int[]{start, end});
            Collections.sort(events, new Comparator<int[]>() {
                public int compare(int[] arr1, int[] arr2) {
                    if(arr1[0] == arr2[0]) {
                        return (arr1[1] - arr2[1]);
                    } else {
                        return (arr1[0] - arr2[0]);
                    }
                }
            });
            // events.stream().forEach(it -> System.out.print(Arrays.toString(it)));
            // System.out.println();
            return true;
        }
        // if(justBeforeEvent[1] > start) {
        //     System.out.println("before " + justBeforeEvent[1]);
        // }
        // if(justAfterEvent[0] < end) {
        //     System.out.println("end " + justAfterEvent[0]);
        // }
        return false;
    }
    
    int getNearestBefore(int start) {
        int S = events.size();
        int left = 0;
        int right = S;
        int mid = 0;
        int ans = -1;
        while(left < right) {
            mid = (left + right) / 2;
            int midNum = events.get(mid)[0];
            if(midNum <= start) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // if(ans == -1) {
        //     return new int[]{-1, -1};
        // }
        return ans;
    }
    
    int[] getNearestAfter(int end) {
        int S = events.size();
        int left = 0;
        int right = S;
        int mid = 0;
        int ans = -1;
        while(left < right) {
            mid = (left + right) / 2;
            int midNum = events.get(mid)[0];
            if(midNum < end) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid;
            }
        }
        if(ans == -1) {
            return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
        return events.get(ans);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */