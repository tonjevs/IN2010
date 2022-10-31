class Heapsort extends Sorter{

    void sort(){
        buildMaxHeap();
        for(int i = n - 1; geq(i,0); i--){
            swap(0,i);
            bubbleDown(0,i);
        }
    }
    
    void buildMaxHeap(){
        for(int i = n / 2; geq(i,0); i--){
            bubbleDown(i,n);
        }
    }

    void bubbleDown(int i, int n){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int tmp = largest;

        if(lt(left, n) && lt(A[largest],A[left])){
            largest = left;
            left = tmp;
            
        }
        if(lt(right, n) && lt(A[largest],A[right])){
            tmp = largest;
            largest = right;
            right = tmp;

        }
        if(i != largest){
            swap(i, largest);
            bubbleDown(largest,n);
        }
    }

    String algorithmName() {
        return "heap";
    }
}
