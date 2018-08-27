package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		this.head.next = new LLNode<E>(null);
		this.tail.prev = new LLNode<E>(null);
		this.head.next.next = this.tail.prev;
		this.tail.prev.prev = this.head.next;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = tail.prev;
		newNode.prev = tail.prev.prev;
		tail.prev.prev.next = newNode;
		tail.prev.prev = newNode;
		this.size ++;
//		add(0,element);
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> currNode = head.next;
		if(index <0 || index > size-1)	// out of range
			throw new IndexOutOfBoundsException();
		
		for(int i=0; i<=index; i++) {
			currNode = currNode.next;
		}
		return currNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		if(index > 0 && index > this.size)
			throw new IndexOutOfBoundsException();
		if(index == 0 && this.size==0)
			add(element);
		
		LLNode<E> currNode = head.next;
		for(int i=0; i<=index; i++) {
			currNode = currNode.next;
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		if(index < this.size) {
			newNode.next = currNode;
			newNode.prev = currNode.prev;
			currNode.prev.next = newNode;
			currNode.prev = newNode;
		}
		else{//index == this.size
			newNode.next = currNode.next;
			newNode.prev = currNode;
			currNode.next.prev = newNode;
			currNode.next = newNode;		
		}
		this.size ++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> currNode = head.next;
		for(int i=0; i<=index; i++) {
			currNode = currNode.next;
		}
		currNode.prev.next = currNode.next;
		currNode.next.prev = currNode.prev;
		currNode.next = null;
		currNode.prev = null;
		this.size --;
		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		if(index<0 || index >size-1)
			throw new IndexOutOfBoundsException();
		
		LLNode<E> currNode = head.next;
		for(int i=0; i<=index; i++) {
			currNode = currNode.next;
		}
		currNode.data = element;
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
