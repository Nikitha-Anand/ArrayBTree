public class ArrayBTree {
    static int[][] ArrayNodes = new int[20][3];
    public static int SearchValue(int root, int ValueToFind){
        if(root == -1){
            return -1;
        }else{
            if(ArrayNodes[root][1] == ValueToFind){
                return root;
            }else{
                if(ArrayNodes[root][1] == -1){
                    return -1;
                }
            }
        }
        if(ArrayNodes[root][1] > ValueToFind){
            return SearchValue(ArrayNodes[root][0],ValueToFind);
        }
        if(ArrayNodes[root][1] < ValueToFind){
            return SearchValue(ArrayNodes[root][2],ValueToFind);
        }
        return -1;
    }

    public static void PostOrder(int root){
        if(ArrayNodes[root][0] != -1){
            PostOrder(ArrayNodes[root][0]);
        }
        if (ArrayNodes[root][2] != -1) {
            PostOrder(ArrayNodes[root][2]);
        }
        System.out.println(ArrayNodes[root][1]);
    }

    public static void main(String[] args){
        for (int i = 0; i < 19; i++) {
            ArrayNodes[i][0] = -1;
            ArrayNodes[i][1] = -1;
            ArrayNodes[i][2] = -1;
        }

        ArrayNodes[0][0] = 1;
        ArrayNodes[0][1] = 20;
        ArrayNodes[0][2] = 5;

        ArrayNodes[1][0] = 2;
        ArrayNodes[1][1] = 15;
        ArrayNodes[1][2] = -1;

        ArrayNodes[2][0] = -1;
        ArrayNodes[2][1] = 3;
        ArrayNodes[2][2] = 3;

        ArrayNodes[3][0] = -1;
        ArrayNodes[3][1] = 9;
        ArrayNodes[3][2] = 4;

        ArrayNodes[4][0] = -1;
        ArrayNodes[4][1] = 10;
        ArrayNodes[4][2] = -1;

        ArrayNodes[5][0] = -1;
        ArrayNodes[5][1] = 58;
        ArrayNodes[5][2] = -1;

        int FreeNode = 6;
        int RootPointer = 0;

        int a = SearchValue(RootPointer, 15);
        if(a == -1){
            System.out.println("Value not found in the tree");
        }else{
            System.out.println("Value found at index: "+ a);
        }
        PostOrder(RootPointer);
    }
}
