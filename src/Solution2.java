import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by babosamo on 2016. 7. 18..
 */
public class Solution2 {

    private ArrayList<ListNode> list;

    public Solution2(int[] scores){
        list = new ArrayList<ListNode>();
        initArray(scores);
        printList(list);
        doReverse();
        printCandies(list);
    }

    private void initArray(int[] scores){

        int index = 0;
        for(int i = 0; i < scores.length ; i ++){
            if(i == (scores.length -1) || scores[i] >= scores[i +1]){
                list.add(new ListNode(Arrays.copyOfRange(scores, index, i + 1)));
                index = i + 1;
            }
        }
    }

    private void printList(ArrayList<ListNode> list){
        System.out.println("--- sliced score --");
        if(list != null){
            for(ListNode node : list){
                int[] array = node.scores;
                for(int i = 0; i < array.length ; i ++){
                    System.out.print(String.valueOf(array[i]) + ", ");
                }
                System.out.println();
            }
        }
    }

    private void printCandies(ArrayList<ListNode> list){
        System.out.println("--- candy count --" );
        if(list != null){
            for(ListNode node : list){
                int[] array = node.candies;
                for(int i = 0; i < array.length ; i ++){
                    System.out.print(String.valueOf(array[i]) + ", ");
                }
                System.out.println();
            }
        }
    }


    private void doReverse(){
        int size = list.size();

        // n 번째 array 의 index 0 가 n-1 번째 array의 마지막 index 아이템 보다 작으면 안된다.
        int minCandy = 0;
        for(int index = size -1 ; index > -1 ; index--){
            ListNode listNode = list.get(index);
            listNode.setCandies(minCandy);
            minCandy = listNode.getMinCandy();
        }
    }

    public int getTotal(){
        int total = 0;
        for(ListNode node : list){
            total += node.getTotal();
        }
        return total;
    }

     private class ListNode {
         int[] scores;
         int[] candies;
         int total;

         ListNode(int[] scores){
             this.scores = scores;
             this.candies = new int[scores.length];
         }

         private void setCandies(int minCandy){
             int candy = 1;
             for(int i = 0; i < scores.length; i++){
                 if(i == scores.length -1){
                     candies[i] = Math.max(candy, minCandy +1);
                 }else {
                     candies[i] = candy;
                 }
                 total += candies[i];
                 candy++;
             }
         }

         public int getMinCandy(){
             return candies[0];
         }

         public int getTotal(){
             return total;
         }
     }
}
