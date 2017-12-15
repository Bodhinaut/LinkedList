public class LinkedList {
    private class Node {
        int data;
        Node next;
        
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node head;
    private Node tail;
    private int count;
    
    
    public LinkedList() {
        head = tail = null;
        count = 0;
    }
    
    public int size() { 
        return count;
    }
    
    public void insertFront(int data) {
        if ( count == 0 ) {
            // empty.
          head = tail = new Node(data, null);
          
        } else {
            // not empty
            head = new Node(data, head);
        }
        count += 1;
    }
    
    public void insertBack(int data) {
        if ( count == 0 ) {
            // empty.
          head = tail = new Node(data, null);
  
        } else {
            // not empty
            tail = tail.next = new Node(data, null);
        }
        count += 1;
    }
    
    public void insertAt(int index, int data) {
        if ( index >= 0 && index <= count) {
            if ( count == 0 ) {
                // list is empty
                head = tail = new Node(data, null);
                
            } else if ( index == 0 ) {
                // insert at the front
                head = new Node(data, head);
                
            } else if ( index == count) {
                // insert at the back
                tail = tail.next = new Node(data, null);
                
            } else {
                // insert within
                Node before = head;
                for (int beforeIndex = 1; beforeIndex <= index - 1; beforeIndex++) {
                    before = before.next;
                }
                Node after = before.next;
                
                before.next = new Node(data, after);
                
            }
            count += 1;
        }
    }
    
    public int removeFront() {
        int dataRemoved = head.data;
        
        if (count == 1) {
            // removing only node left
            head = tail = null;
            
        } else {
            head = head.next;
        }   
        count -= 1;
        return dataRemoved;
    }
    
    public int removeBack() {
        int dataRemoved = tail.data;
        
        if (count == 1) {
            // removing only node left
            head = tail = null;
            
        } else {
            Node before = head;
            
            while ( before.next != tail ) {
                before = before.next;
            }
            tail = before;
            tail.next = null;
        }   
        count -= 1;
        return dataRemoved;
    }
    
    public int removeAt(int index) {
        int dataRemoved = -99;
        
        if ( index >= 0 && index <= count - 1) {
            if ( count == 1 ) {
                // list becomes empty
                dataRemoved = head.data;
                head = tail = null;
                
            } else if ( index == 0 ) {
                // remove front node
                dataRemoved = removeFront();
                
            } else if ( index == count - 1) {
                // remove back node
                dataRemoved = removeBack();
                
            } else {
                // remove a within node
                Node before = head;
                for (int beforeIndex = 1; beforeIndex <= index - 1; beforeIndex++) {
                    before = before.next;
                }
                Node del = before.next;
                Node after = del.next;
                
                before.next = after;
                dataRemoved = del.data;
            }
            count -= 1;
        }
        
        return dataRemoved;
    }
    
    public int front() {
        return head.data;
    }
    
    public int back() {
        return tail.data;
    }
    
    public int get(int index) {
        int valueFound = -99;
        
        if (index >= 0 && index <= count - 1) {
            Node iter = head;
            for (int beforeIndex = 1; beforeIndex <= index; beforeIndex++) {
                iter = iter.next;
            }
            valueFound = iter.data;
        }
        return valueFound;
    }
    
    @Override
    public String toString() {
        String str = "[ ";
        
        Node iter = head;
        
        while ( iter != null ) {
            str += iter.data + " ";
            iter = iter.next;
        }
        
        return str + "]";
    }
}