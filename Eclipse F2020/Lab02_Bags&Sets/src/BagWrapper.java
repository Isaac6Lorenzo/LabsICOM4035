
//Consider the DynamicBag class that we implemented in this course. 
//Write a member method lessThanCount() which returns the number of 
//elements in the Bag whose count is less than a given value passed 
//as parameter.  If the Bag is empty, the method returns 0.  If an 
//element is repeated, the it is counted in the total as many times 
//as your see it. For example, if the bag B = {'Jim', 'Bob', 'Ned', 'Ned', 'Li', 'Ned'},
//then a call to B.lessThanCount(2) returns 3. Likewise, on Bag B = 
//B = {'Jim', 'Jim', 'Kim', 'Li' ,'Li', 'Li'},  B.lessThanCount(4) returns 6.

public class BagWrapper {
    public static interface Bag {

        public int size();

        public boolean isEmpty();

        public boolean isMember(Object obj);

        public void clear();

        public void add(Object obj);

        public int count(Object obj);

        public boolean remove(Object obj);

        public int removeAll(Object obj);

        public Object[] toArray();

        public int lessThanCount(int targetCount);


    }

    public static class DynamicBag implements Bag {

        private static final int INITAL_SIZE = 10; // constant to give intial size

        // space for storage element
        private Object elements[];

        // current size
        private int currentSize;

        public DynamicBag(int initialSize){
            if (initialSize < 1){
                throw new IllegalArgumentException("Initial size must be at least 1.");
            }
            this.currentSize = 0;
            this.elements = new Object[initialSize];
        }

        public DynamicBag(){
            this(INITAL_SIZE);
        }

        @Override
        public int size() {
            return this.currentSize;
        }

        @Override
        public boolean isEmpty() {
            return this.size() == 0;

//            // Not cool
//        if (this.size == 0){
//            return true;
//        }
//        else {
//            return false;
//        }
        }

        @Override
        public boolean isMember(Object obj) {
            return this.count(obj) > 0;
        }

        @Override
        public void clear() {
            for (int i =0; i < this.size(); ++i){
                this.elements[i] = null;
            }
            this.currentSize = 0;
        }

        @Override
        public void add(Object obj) {
            if (obj == null){
                throw new IllegalArgumentException("Argument to add cannot be null");
            }

            if (this.size() == this.elements.length){
                this.reAllocate();

            }
            this.elements[this.currentSize++] = obj;
            // not cool
            //this.currentSize = this.currentSize + 1;
            // not cool 2
            //this.currentSize++;
        }

        private void reAllocate(){
            int newSize  = this.size() * 2;
            Object newElements[] = new Object[newSize];

            // Copy to new array
            for (int i=0; i < this.size(); ++i){
                newElements[i] = this.elements[i];
            }
            this.elements = newElements;
        }

        @Override
        public int count(Object obj) {
            int result = 0;

            for (int i=0; i < this.size(); ++i){
                if (this.elements[i].equals(obj)){
                    ++result; // result++ is ok too - just want to increment, don't care about value
                }
            }
            return result;
        }

        @Override
        public boolean remove(Object obj) {
            for (int i=0; i < this.size(); ++i){
                if (this.elements[i].equals(obj)){
                    // found it!
                    this.elements[i] = this.elements[this.currentSize-1];
                    this.elements[this.currentSize-1] = null;
                    --this.currentSize; //this.currentSize-- is ok too -  just want to increment, don't care about value
                    return true;
                }
            }
            return false;
        }

        @Override
        public int removeAll(Object obj) {
            int result = 0;

            while(this.remove(obj)){
                ++result;
            }
            return result;
        }
        public Object[] toArray(){
            Object[] result;
            // return new independent array
            result = new Object[this.size()];
            for (int i=0; i < this.size(); ++i){
                result[i] = this.elements[i];
            }
            return result;
        }

        @Override
        public int lessThanCount(int targetCount) {
			// add your code here
        	if (this.isEmpty()) {
				return 0;
			}
        	
        	int freq =0;
        	
        	for (int i = 0; i < this.size(); i++) {
            	Object obj = this.elements[i];

        		if (this.count(obj) < targetCount) {
					freq++;
				}
			}        	
        	return freq;
        }
    }
}