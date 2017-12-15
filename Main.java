public class Main {
    public static void main(String[] args) {
        
        // below I run scenarios testing my linked list
        LinkedList ll = new LinkedList();
        
        System.out.println("Original list: " + ll);
        
        ll.insertBack(1);
        ll.insertBack(2);
        
        System.out.println("Insert to back list: " + ll);
        
        ll.insertFront(1);
        ll.insertFront(0);
        System.out.println("Insert to front list: " + ll);
        
        int fd = ll.removeFront();
        System.out.println("Removed front value: " + fd);
        System.out.println("Remove front list: " + ll);
        
        fd = ll.removeBack();
        System.out.println("Removed backed value: " + fd);
        System.out.println("Remove back list: " + ll);
        
        ll.insertAt(0, 100);
        System.out.println("Insert at 0 list: " + ll);
        
        ll.insertAt(2, 200);
        System.out.println("Insert at 2 list: " + ll);
        
        int size = ll.size();
        ll.insertAt(size, size * 100);
        System.out.println("Insert at " + size + " list: " + ll);
    }
}