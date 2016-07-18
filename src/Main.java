public class Main {

    public static void main(String[] args) {

        int[] condition1 = {1,2,2};
        int[] condition2 = {2,4,2,6,1,7,8,9,2,1};
        int[] condition3 = {3,2,1};
        int[] condition4 = {1,7,9,2,3,1,5,4,2,1,5,3,9};


        System.out.println("# 1st Solution");
        System.out.println("condition1 : 4 " + ", result :" + new Solution1(condition1).getCandyCount() + "\n");
        System.out.println("condition2 : 19 " + ", result :" +new Solution1(condition2).getCandyCount() + "\n");
        System.out.println("condition3 : 6 " + ", result :" + new Solution1(condition3).getCandyCount()+ "\n");
        System.out.println("condition4 : 25 " + ", result :" + new Solution1(condition4).getCandyCount() + "\n");

        System.out.println("# 2nd Solution");
        System.out.println("condition1 : 4 " + ", result :" + new Solution2(condition1).getTotal() + "\n");
        System.out.println("condition2 : 19 " + ", result :" + new Solution2(condition2).getTotal() + "\n");
        System.out.println("condition3 : 6 " + ", result :" + new Solution2(condition3).getTotal() + "\n");
        System.out.println("condition4 : 25 " + ", result :" + new Solution2(condition4).getTotal()  + "\n");

    }


}
