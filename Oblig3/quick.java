class Quick extends Sorter {

    void sort() {
        quickSort(0, n-1);
    }

    int choosePivot(int low, int high){
        return (low+high)/2;
    }
    
    void quickSort(int low, int high){
        if(geq(low, high)){
            return;
        }
        int p = partition(low,high);
        quickSort(low, p-1);
        quickSort(p+1, high);
        return;
    }

    int partition(int low, int high){
        int p = choosePivot(low, high);
        swap(p, high);
        int pivot = A[high];
        int left = low;
        int right = high-1;

        while(leq(left, right)){
            while(leq(left, right) && leq(A[left], pivot)){
                left += 1;
            }
            while(geq(right, left) && geq(A[right], pivot)){
                right -= 1;
            }

            if(lt(left, right)){
                swap(left, right);
            }
        }
        swap(left,high);
        return left;
    }

    String algorithmName() {
        return "quick";
    }
}