package ds.imp;

public class StackImp <D> {
	private Object[] stack;
	private int size, top;
	private static final int INITIAL_CAPACITY = 10,  RESIZE_FACTOR = 2;
	private static final float LOAD_FACTOR = 0.9f;

	
	public StackImp(){
		size = 0;
		top=0;
		stack = new Object[INITIAL_CAPACITY];
	}
	
	public void push(D value) {
		if(top/(float)stack.length==LOAD_FACTOR) {
			resize();
		}
		stack[top++] = value;
		size++;
	}
	
	public Object pop() {
		top--;
		size--;
		return stack[top];
	}
	
	public Object peek() {
		return stack[top-1];
	}
	
	public int size() {
		return size;
	}
	
	public void resize() {
		Object[] temp = new Object[stack.length*RESIZE_FACTOR];
		for(int i=0;i<size;i++)
			temp[i] = stack[i];
		stack = temp;
	}
	
	public String toString() {
		String list ="[";
		for(int i=0 ; i<size ; i++) {
			list+=stack[i];
			if(i<size-1)
				list+=", ";
		}
		return list+"]";
	}
	
}
