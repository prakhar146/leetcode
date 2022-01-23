class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> sequence = new ArrayList<>();
        int nod = getNumberOfDigits(low);
        long maxCap = Math.min(high, (int) Math.pow(10, nod));
        int base = (int) Math.pow(10, nod - 1);
        int startNum = getStartNum(nod);
        int incrementNumber = getIncrementNumber(nod);

        int currentNum;
        while(maxCap > 0 && maxCap <= high) {
            currentNum = startNum;
            while(currentNum <= maxCap  && base > 0 && (currentNum > 0) &&  ((currentNum / base) <= (9 - (nod - 1)))) {
                // System.out.println(currentNum);
                if (currentNum >= low) {
                    sequence.add(currentNum);
                }
                currentNum += incrementNumber;
            }
            nod++;
            maxCap = maxCap == high ? maxCap * 10 : Math.min(maxCap * 10, high);
            base = base * 10;
            startNum = startNum * 10 + ((startNum % 10) + 1);
            incrementNumber = incrementNumber * 10 + 1;
        }

        return sequence;
    }
    
    int getNumberOfDigits(int n) {
        int nod = 0;
        int tmp = n;

        while (tmp != 0) {
            tmp /= 10;
            nod++;
        }
        return nod;
    }


    int getStartNum(int nod) {
        int startNum = 0;
        while (nod > 0) {
            startNum = (startNum * 10) + ((startNum % 10) + 1);
            nod--;
        }

        return startNum;
    }

    int getIncrementNumber(int nod) {
        int sum = 0;
        int tens = 1;
        while (nod > 0) {
            sum += tens;
            tens *= 10;
            nod--;
        }
        return sum;
    }
}