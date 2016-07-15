public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] condition1 = {1,2,2};
        int[] condition2 = {2,4,2,6,1,7,8,9,2,1};
        int[] condition3 = {3,2,1,};

        printScore(condition1);
        int result = getCandyCount(condition1);
        System.out.println("condition1 : 4 " + ", result :" + result);
        printScore(condition2);
        result = getCandyCount(condition2);
        System.out.println("condition2 : 19 " + ", result :" + result);
        printScore(condition3);
        result = getCandyCount(condition3);
        System.out.println("condition3 : 6 " + ", result :" + result);

    }

    public static int getCandyCount(int[] values){

        int candy = 1;

        int[] candyArray = new int[values.length];
        for(int i = 0; i < candyArray.length ; i ++){
            candyArray[i] = 1;
        }

        for(int i = 0; i < values.length-1  ; i++ ){

            int value = values[i];
            int rvalue = values[i + 1];
            candyArray[i] = candy;

            if(value >= rvalue){ // 오른쪽 값이 작으면 1로 셋
                candy = 1;
            }else{  // 증가 중
                candy ++;
            }
            if(i == values.length - 1){
                candyArray[i+1] = candy;
            }
        }


        for(int i = values.length-1 ; i > 0  ; i-- ){

            int value = values[i];
            int lvalue = values[i - 1];

            candyArray[i] = Math.max(candyArray[i], candy);
            if(value >= lvalue){ // 왼쪽 값이 작으면 값이 작으면 1로 셋
                candy = 1;
            }else{  // 증가 중
                candy ++;
            }
            if(i == 1){
                candyArray[0] = Math.max(candyArray[0], candy);
            }
        }

        printCandy(candyArray);

        int total = 0;
        for(int value : candyArray){
            total += value;
        }
        return total;
    }


    public static void printScore(int[] array){
        for(int value : array){
            System.out.print(value + ", ");
        }
        System.out.println();

    }

    public static void printCandy(int[] array){
        for(int value : array){
            System.out.print(value + ", ");
        }
        System.out.println();

    }
}
