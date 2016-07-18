/**
 * Created by babosamo on 2016. 7. 18..
 */
public class Solution1 {

    int total;
    private int[] scores;
    private int[] candyArray;

    public Solution1(int[] values){
        scores = values;
        candyArray = new int[values.length];

        int candy = 1;
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

        for(int value : candyArray){
            total += value;
        }
    }

    public int getCandyCount(){
        printScore(scores);
        printCandy(candyArray);
        return total;
    }


    public void printScore(int[] array){
        System.out.print("scores  --> ");
        for(int value : array){
            System.out.print(value + ", ");
        }
        System.out.println();

    }

    public void printCandy(int[] array){
        System.out.print("candies --> ");
        for(int value : array){
            System.out.print(value + ", ");
        }
        System.out.println();
    }
}
