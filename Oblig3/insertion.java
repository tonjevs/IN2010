class Insertion extends Sorter {

    void sort() {

        for(int i = 1; leq(i,n-1); i++){
            int j = i;
            while(gt(j,0) && lt(A[j], A[j-1])){
                swap(j-1,j);
                j--;
            }
        }
    }

    String algorithmName() {
        return "insertion";
    }
}