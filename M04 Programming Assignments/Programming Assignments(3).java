import java.util.ListIterator;

public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    public TwoWayLinkedList() {
    }

    public ListIterator<E> listIterator() {
        return new TwoWayLinkedListIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        return new TwoWayLinkedListIterator(index);
    }

    // Implement other methods defined in MyLinkedList...

    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) {
            element = e;
        }
    }

    private class TwoWayLinkedListIterator implements ListIterator<E> {
        private Node<E> current;
        private int index;

        public TwoWayLinkedListIterator(int index) {
            this.index = index;
            current = (index == size) ? null : getNode(index);
        }

        // Implement methods defined in ListIterator...

        private Node<E> getNode(int index) {
            Node<E> node = head;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        }
    }
}
