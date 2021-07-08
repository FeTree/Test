package Udemy.HashTable;

public class HashTable {

    String[] hashArray;
    int arraySize;
    int size = 0; //counter

    public HashTable(int noOfSlots) {
        if(isPrime(noOfSlots)) {
            hashArray = new String[noOfSlots];
            arraySize = noOfSlots;
        }
        else{
            int primeCount = getNextPrime(noOfSlots);
            hashArray = new String[primeCount];
            arraySize = primeCount;
            System.out.println("Hash table size is, " + noOfSlots + ", not " +
                    "a prime number.");
            System.out.println("Size changed to: " + primeCount);
            // So weak lol please work
        }
    }

    private boolean isPrime(int num){
        for(int i = 2; i*i <= num; i++ ){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int minNumber){
        for (int i = minNumber; true; i++) {
            if(isPrime(i)){
                return i;
            }
        }
    }

    private int hashFunc1(String word){
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;
        if(hashVal < 0){
            hashVal += arraySize;
        }

        return hashVal; //ideal index position
    }

    //return step size greater than 0
    private int hashFunc2(String word){
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;
        if(hashVal < 0){
            hashVal += arraySize;
        }

        return 3 - hashVal % 3; //3 is step, step has to be prime number less than array size
    }

    public void insert(String word){
        int hashVal = hashFunc1(word);
        int stepSize = hashFunc2(word);

        while(hashArray[hashVal] != null){
            hashVal = hashVal+ stepSize;
            hashVal = hashVal % arraySize;
        }

        hashArray[hashVal] = word;
        System.out.println("Inserted word: " + word);
        size++;
    }

    public String find(String word){
        int hashVal = hashFunc1(word);
        int stepSize = hashFunc2(word);

        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].equals(word)){
                return hashArray[hashVal];
            }
            hashVal = hashVal+ stepSize;
            hashVal = hashVal % arraySize;
        }
        return hashArray[hashVal];

    }


} // end class
