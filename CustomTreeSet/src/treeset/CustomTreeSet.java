package treeset;

import java.util.Comparator;


public class CustomTreeSet<T> implements Comparator<T>{

	protected Node<T> root;
	protected int size;
	private final Comparator<? super T> comparator; 
	
	public CustomTreeSet() {
		comparator = null;
	}
	
	public CustomTreeSet(Comparator<? super T> comparator) {
		this.comparator = comparator;
	}
	
	public static class Node<T> {
		private Node<T> left;
		private Node<T> right;
		private Node<T> parent;
		private T value;
		
		public Node(Node<T> left, Node<T> right, Node<T> parent, T value) {
			super();
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.value = value;
		}

		public Node(T value)  {
			this.value = value;
		}
		
	}

	public boolean add(T value) {
		if(value == null) return false;
		if(root == null) root = new Node<T>(null, null, null, value);
		else {
			Node<T> tmpNode = root;
			while(tmpNode != null) {
				int cmp = compare(tmpNode.value, value);
				if(cmp == 0) {
					return false;
				} else if(cmp < 0){
					if(tmpNode.left != null) {
						tmpNode = tmpNode.left;
					} else {
						tmpNode.left = new Node<>(value);
						tmpNode.left.parent = tmpNode;
						return true;
					}
					
				} else {
					if(tmpNode.right != null) {
						tmpNode = tmpNode.right;
					} else {
						tmpNode.right = new Node<>(value);
						tmpNode.right.parent = tmpNode;
						return true;
					}
					
				}
				return false;
			}
			
		}
		return true;
	}
	
	public boolean remove(T value) {
		Node<T> current = root;
        while (current != null) {
            int resOfCompare = compare(current.value, value);
            if (resOfCompare < 0) {
                current = current.left;
            } else if (resOfCompare > 0) {
                current = current.right;
            } else {
                if (current.left == null && current.right == null) {
                    if (current.parent.left == current) {
                        current.parent.left = null;
                    } else current.parent.right = null;
                } else if (current.left != null) {
                    Node<T> maxLeft = current.left;
                    while (maxLeft.right != null) {
                        maxLeft = maxLeft.right;
                    }
                    current.value = maxLeft.value;
                    if (maxLeft.parent.right == maxLeft) {
                        if (maxLeft.left != null) {
                            maxLeft.parent.right = maxLeft.left;
                        } else {
                            maxLeft.parent.right = null;
                        }
                    } else {
                        maxLeft.parent.left = maxLeft.left;
                    }
                } else {
                    Node<T> maxRight = current.right;
                    while (maxRight.left != null) {
                        maxRight = maxRight.left;
                    }
                    current.value = maxRight.value;
                    if (maxRight.parent.left == maxRight) {
                        if (maxRight.right != null) {
                            maxRight.parent.left = maxRight.right;
                        } else {
                            maxRight.parent.left = null;
                        }
                    } else {
                        maxRight.parent.right = maxRight.right;
                    }
                }
                return true;
            }
        }
        return false;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public int compare(T o1, T o2) {
		return comparator == null ? ((Comparable<? super T>)o1).compareTo(o2)
				: comparator.compare(o1, o2);
	}
	
}
