package Deutsche;

/*	Develop a program which reverses the one-way linked list.

Разработать программу, которая реверсирует односторонний связанный список.
*/

public class Node {
    private Object element;
    private Node next;

    public Node() {

    }

    public Node(Object element, Node next) {
        this.next = next;
        this.element = element;
    }

    public Object getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

class LinkedRealization {
    private Node top;
    private int size;

    public LinkedRealization() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Node getTop() {
        return top;
    }

    public boolean isEmpty() {
        if (top == null)
            return true;
        return false;
    }

    public void push(Object elm) {
        Node nod = new Node();
        nod.setElement(elm);
        nod.setNext(top);
        top = nod;
        size++;

    }

    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(0);
        }
        return top.getElement();
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(0);
        }
        Object obj = top.getElement();
        top = top.getNext();
        size--;
        return obj;
    }

    public void printAll() {
        Object a[] = new Object[size()];


        int count = 0;
        for (int i = 0; i < size(); i++) {
            Node topTemp = null;
            topTemp = top;
            for (int j = 0; j < size() - count - 1; j++) {
                topTemp = topTemp.getNext();
            }

            a[i] = topTemp.getElement();
            count++;
            System.out.println(a[i]);
        }

    }


    public Object reverseList(LinkedRealization list) {
        Object a[] = new Object[size()];

        int count = 0;
        for (int i = 0; i < size(); i++) {
            Node topTemp = null;
            topTemp = top;
            for (int j = 0; j < size() - count - 1; j++) {
                topTemp = topTemp.getNext();
            }

            a[i] = topTemp.getElement();
            count++;
        }

        count = 0;
        for (int i = 0; i < size(); i++) {
            Node top1 = null;
            top1 = top;
            for (int j = 0; j < size() - count - 1; j++) {
                top1 = top1.getNext();
            }
            top1.setElement(a[size() - 1 - i]);
            count++;
        }
        return list;
    }

    public static void main(String args[]) {
        LinkedRealization list = new LinkedRealization();
        list.push("SSSSSSSS");
        list.push("AAAAAAAAA");
        list.push("wwwwwwwww");
        System.out.println("Size of list = " + list.size);
        list.printAll();

        /* pop elements
        System.out.println(list.getTop().getElement());
        list.pop();
        System.out.println(list.getTop().getElement());
        list.pop();
        System.out.println(list.getTop().getElement());
        System.out.println();
        */
        list.reverseList(list);
        System.out.println();
        list.printAll();
    }

}