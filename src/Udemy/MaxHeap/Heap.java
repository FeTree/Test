package Udemy.MaxHeap;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize; //number of nodes in array

    public Heap(int size){
        this.maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    public int getMAX_SIZE(){
        return currentSize;
    }

    public boolean isEmpty(){
        return (currentSize == 0);
    }

    public boolean insert(int key){
        if(currentSize == maxSize){
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode; //next slot in array
        trickleUp(currentSize);


        currentSize++;
        return true;
    }

    public void trickleUp(int idx){
        int parentIdx = (idx-1)/2;
        Node nodeToInsert = heapArray[idx];

        //loop as long as we havent reached the root and key of nodetoinsert parent is les than new node
        while(idx>0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()){
            heapArray[idx] = heapArray[parentIdx]; //move parent down
            idx = parentIdx;
            parentIdx = (parentIdx - 1)/2; //move up parent of parent
        }
        heapArray[idx] = nodeToInsert;
    } // end trickleUp()

     public Node remove(){
        Node root = heapArray[0];
        currentSize--;
        heapArray[0] =  heapArray[currentSize];

        trickleDown(0);

        return root;
     }

     private void trickleDown(int idx){
         int largerChildIdx;
         Node top = heapArray[idx]; //save last node into top variable

         //will run as long as idx is not on the botom row(at least 1 child)
         while(idx < currentSize/2){
             //left child idx position
             int leftChildIdx = 2*idx + 1; //left child idx position
             int rightChildIdx = leftChildIdx + 1; //left child idx position

             //figure out which child is larger
             if(rightChildIdx < currentSize &&
                     heapArray[leftChildIdx].getKey()< heapArray[rightChildIdx].getKey()){
                 largerChildIdx = rightChildIdx;
             }
             else{
                 largerChildIdx = leftChildIdx;
             }
             if(top.getKey()>= heapArray[largerChildIdx].getKey()){
                 //made root largest key
                 break;
             }

             heapArray[idx] = heapArray[largerChildIdx];
             idx = largerChildIdx; //go down
         }//end loop

         heapArray[idx] = top;
     }
    public void displayHeap()
    {
        System.out.print("heapArray: ");    // array format
        for(int m=0; m<currentSize; m++)
            if(heapArray[m] != null)
                System.out.print( heapArray[m].getKey() + " ");
            else
                System.out.print( "-- ");
        System.out.println();
        // heap format
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;                          // current item
        String dots = "...............................";
        System.out.println(dots+dots);      // dotted top line

        while(currentSize > 0)              // for each heap item
        {
            if(column == 0)                  // first item in row?
                for(int k=0; k<nBlanks; k++)  // preceding blanks
                    System.out.print(' ');
            // display item
            System.out.print(heapArray[j].getKey());

            if(++j == currentSize)           // done?
                break;

            if(++column==itemsPerRow)        // end of row?
            {
                nBlanks /= 2;                 // half the blanks
                itemsPerRow *= 2;             // twice the items
                column = 0;                   // start over on
                System.out.println();         //    new row
            }
            else                             // next item on row
                for(int k=0; k<nBlanks*2-2; k++)
                    System.out.print(' ');     // interim blanks
        }  // end for
        System.out.println("\n"+dots+dots); // dotted bottom line
    }  // end displayHeap()


}
