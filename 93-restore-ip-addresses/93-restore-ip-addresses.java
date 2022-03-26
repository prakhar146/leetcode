class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> validIps = new ArrayList();
        // if(s.length() < 4 || s.length() > 12) {
        //     return new ArrayList();
        // }
        int[] dots = new int[3];
        storeValidIps(s, 0, dots, 0, validIps);
        return validIps;
    }
    
    void storeValidIps(String s, int idx, int[] dots, int dotsIdx, List<String> ips) {
        // System.out.println("idx " + idx + " dots " + Arrays.toString(dots) + " dIdx " + dotsIdx);
        if(dotsIdx == dots.length) {
            if(!isValid(s, dots[dotsIdx - 1], s.length())) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb = sb.append(s.substring(0, dots[0]));
            sb.append('.');
            sb = sb.append(s.substring(dots[0], dots[1]));
            sb.append('.');
            sb = sb.append(s.substring(dots[1], dots[2]));
            sb.append('.');
            sb = sb.append(s.substring(dots[2]));
            ips.add(sb.toString());
            // System.out.println("*************** Adding string " + sb.toString());
            return;
        }
        if((((s.length() - idx) / (4 - dotsIdx)) < 1) || (((s.length() - idx) / (4 - dotsIdx)) > 3)) {
            // System.out.println("---- IMBALANCE ----- num -> " + (s.length() - idx) + " denom -> " + (4 - dotsIdx) +  " ratio -> " + (s.length() - idx) / (4 - dotsIdx));
            return;
        }
        if(idx == s.length()) {
            // System.out.println("---- EOS -----");
            return;
        }
        // op1
        if(isValid(s, dotsIdx > 0 ? dots[dotsIdx - 1] : 0, idx + 1)) {
            dots[dotsIdx] = idx + 1;
            // int op1 = 
            storeValidIps(s, idx + 1, dots, dotsIdx + 1, ips);   
        }
        // int op2 = 
        storeValidIps(s, idx + 1, dots, dotsIdx, ips); 
    }
    
    boolean isValid(String s, int startIdx, int endIdx) {
        String sub = s.substring(startIdx, endIdx);
        
        if(sub.length() < 1 || sub.length() > 3 ) {
            // System.out.println(sub + " --> INVALID");
            return false;
        }
        int num = stringToNum(sub);
        // System.out.println("num " + num + " char " + s.charAt(0));
        if(num < 0 || num > 255) {
            // System.out.println(sub + " --> INVALID");
            return false;
        }
        if(num == 0 && sub.length() > 1) {
            return false;
        }
        if(num != 0 && sub.charAt(0) == '0') {
            // System.out.println(sub + " --> INVALID");
            return false;
        }
        // System.out.println(sub + " --> VALID");
        return true;
    }
    
    int stringToNum(String s) {
        int p = s.length() - 1;
        int tenPower = 1;
        int sum = 0;
        while(p >= 0) {
            int digit = s.charAt(p) - '0';
            sum += (digit * tenPower);
            tenPower *= 10;
            p--;
        }
        return sum;
    }
}
/*
 s >= 4
 4 / 4 = 1
 5 / 4 = 1, 2
 8 / 4 = 2
 s <= 12
 
 ----------------
 0000
 ----------------
 storeValidIps(0000, 0, [0,0,0,0], 0, [])
 
 // op1
 isValid(0000, 0, 1)  --> true
 dots[0] = 1;
 storeValidIps(0000, 1, [1,0,0,0], 1, [])
 
 // op1
 isValid(0000, 1, 2)
 dots[1] = 2;
 storeValidIps(0000, 2, [1,2,0,0], 2, [])
 
 // op1
 isValid(0000, 2, 3)
 dots[2] = 3
 storeValidIps(0000, 3, [1,2,3,0], 3, [])
 
 // op2
 isValid(0000, 3, 4)
 dots[3] = 4
 storeValidIps(0000, 4, [1,2,3,4], 4, [])
 
 if(dotsIdx == dots.length) {
    StringBuilder sb = new StringBuilder();
    sb = sb.append(s.substring(s, 0, dots[0]));
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 -----------------
 
 op1 = 0.000
 op2 = 0000
 if()
 
*/