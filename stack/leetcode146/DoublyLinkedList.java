package stack.leetcode146;


class DoublyLinkedList{
    private final head, tail;

    public DoublyLinkedList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    //head <-> node <-> A <-> B <-> tail
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    public org.w3c.dom.Node removeTail(){
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
}