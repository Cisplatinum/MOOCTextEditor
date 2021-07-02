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
		head = new LLNode<>(null);
		tail = new LLNode<>(null);
		head.setNext(tail);
		tail.setPrev(head);
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}

		LLNode<E> newNode = new LLNode<>(element);
		newNode.setPrev(tail.prev);
		newNode.setNext(tail);
		tail.prev.setNext(newNode);
		tail.setPrev(newNode);

		size++;
//		System.out.println(newNode.data);
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bound");
		}
		LLNode<E> curr = head;
		for (int i = 0; i <= index; i++) {
			curr = curr.next;
		}
		return curr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param \The index where the element should be added
	 * @param \element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is out of bound");
		} else if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}

		LLNode<E> curr = head;
		for (int i = 0; i <= index; i++) {
			curr = curr.next;
		}
		LLNode<E> newNode = new LLNode<>(element);
		newNode.setPrev(curr.prev);
		newNode.setNext(curr);
		curr.prev.setNext(newNode);
		curr.setPrev(newNode);

		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
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
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		LLNode<E> curr = head;
		for (int i = 0; i <= index; i++) {
			curr = curr.next;
		}

		curr.prev.setNext(curr.next);
		curr.next.setPrev(curr.prev);
		curr.setNext(null);
		curr.setPrev(null);

		size--;
		return curr.data;
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
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index is out of bounds");

		if (element == null)
			throw new NullPointerException("Element cannot be null!");

		LLNode<E> curr = head;
		for (int i = 0; i <= index; i++) {
			curr = curr.next;
		}
		E data = curr.data;
		curr.data = element;
		return data;
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

	public void setNext(LLNode<E> next) {
		this.next = next;
	}

	public void setPrev(LLNode<E> prev) {
		this.prev = prev;
	}
}
