class InsertionSort {
    enum Order {
        ORDER_ASC, ORDER_DESC
    }

    static String[] sortInsertion(String[] strArr, Order order) {
        for(int i = 1; i < strArr.length; i++){
            String currElem = strArr[i];
            int prevKey = i - 1;
            while(order == Order.ORDER_ASC ? (prevKey >= 0 &&
                    (strArr[prevKey].compareTo(currElem) > 0)) :
                    (prevKey >= 0 && (strArr[prevKey].compareTo(currElem) < 0))){
                strArr[prevKey+1] = strArr[prevKey];
                prevKey--;
            }
            strArr[prevKey+1] = currElem;
        }
        return strArr;
    }

    static String[] sortInsertion(int[] intArr, Order order) {
        for(int i = 1; i < intArr.length; i++){
            int currElem = intArr[i];
            int prevKey = i - 1;
            while(order == Order.ORDER_ASC ? (prevKey >= 0 && intArr[prevKey] > currElem) :
                    (prevKey >= 0 && intArr[prevKey] < currElem)) {
                intArr[prevKey+1] = intArr[prevKey];
                prevKey--;
            }
            intArr[prevKey+1] = currElem;
        }
        String[] sortStrArr = new String[intArr.length];
        for (int i = 0; i < intArr.length; i++) {
            sortStrArr[i] = String.valueOf(intArr[i]);
        }
        return sortStrArr;
    }
}