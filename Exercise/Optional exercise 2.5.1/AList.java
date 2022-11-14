/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    /** Creates an empty list. */
    private int []array;
    private int size;
    public AList() {
      array=new int[100];
      size=0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(size<=99){
            array[size]=x;
            size=size+1;
        }
        else {
            int[] a = new int[size + 1];
            System.arraycopy(array, 0, a, 0, size);
            a[size] = 11;
            array = a;
            size = size + 1;
        }
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return array[size-1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return array[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int x=getLast();
        size=size-1;
        return x;
    }
} 
