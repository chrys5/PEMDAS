public class ArrayStack<E>
{

    private E[] stack;
    private int size = 0;

    public ArrayStack()
    {
        stack = (E[]) new Object[10];
    }

    /**
     * Returns whether the stack is empty
     *
     * @return whether size of stack == 0
     */
    public boolean empty()
    {
        return size == 0;
    }

    /**
     * Returns the top, last element of the stack
     *
     * @return top element of stack
     */
    public E peek()
    {
        if(!empty())
        {
            return stack[size - 1];
        }
        return null;
    }

    /**
     * Removes the top, last element of the stack
     * @return Object that is popped
     */
    public E pop()
    {
        if(!empty())
        {
            size--;
            E o = stack[size];
            stack[size] = null;
            return o;
        }
        return null;
    }


    /**
     * Object x is added onto the top of the stack, the last element of the stack
     * @param x description of wtf x is supposed to be
     * @return x
     */
    @SuppressWarnings("unchecked")
    public E push(E x)
    {
        if((size) % 10 == 0) //if stack array is full and adding at the end is not possible
        {
            E[] temp = stack; //make copy of stack array
            stack = (E[]) new Object[temp.length + 10]; //creates blank array that expands stack by 10 elements
            for(int i = 0; i < size; i++)
            {
                stack[i] = temp[i]; //temp[] is copied into stack
            }
        }
        //Object o is added to last element in stack, as size is increased by 1
        stack[size++] = x;
        return x;
    }

    /**
     * Finds and returns the first index of o, returns -1 if o is not found
     * @param o description of wtf o is
     * @return first index of o
     */
    public int search(E o)
    {
        for(int i = size - 1; i > 0; i--) //traverses entire stack
        {
            if(stack[i].equals(o))
            {
                return i; //returns first occurrence of o
            }
        }
        return -1;
    }
}