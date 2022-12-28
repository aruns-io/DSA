class LinkedListTest {
    public static void main(String[] args) {
        List l = new List();
        l.insertAt(0,2);
        l.insertAt(1,3);
        l.insertAt(2,4);
        l.insertAt(3,5);
        l.insertAt(4,6);
        l.insertAt(5,7);
        l.insertAt(6,8);
        l.insertAt(7,9);
        l.insertAt(8,10);
        l.print();
        l.removeAt(3);
        l.print();
    }
}

class List{
    Node head;

    public void insert(int value){
        Node node = new Node();
        node.value = value;
        node.next = null;
        if(head==null){
            head=node;
        }else{
            Node n = head;
            while(n.next!=null){
                n = n.next;
            }
            if(n.next==null){
                n.next = node;
            }
        }
    }

    public void insertAt(int index, int value){
        Node n = head;
        Node insertingNode = new Node();
        insertingNode.value = value;
        int count = 0;
        if(index==0){
            insertFirst(value);
        }
        else {
            while(n.next!=null){
                if(count==index-1){
                    Node tempNode = n.next;
                    n.next = insertingNode;
                    insertingNode.next = tempNode;
                    break;
                }
                else{
                    n = n.next;
                    count += 1;
                    if(count==index-1&&n.next==null){
                        insertLast(value);
                        break;
                    }
                }
            }
        }
        if(index>count&&n.next==null){
            System.out.println("index is out of bound, creating a new node at the end");
            insertLast(value);
        }
    }

    public void insertLast(int value){
        Node n = head;
        while(n.next!=null){
            n=n.next;
        }
        Node lastNode = new Node();
        lastNode.value = value;
        lastNode.next = null;
        n.next=lastNode;
    }

    public void insertFirst(int value){
        Node n = head;
        Node firstNode = new Node();
        firstNode.value = value;
        firstNode.next = n;
        head = firstNode;
    }

    public void removeAt(int index){
        Node n = head;
        int count = 0;
        while(n.next!=null){
            if(index==0){
                removeFirstValue();
                break;
            }else if(count==index-1){
                n.next = n.next.next;
                break;
            }else{
                n = n.next;
                count += 1;
                if(count==index&&n.next==null){
                    removeLastValue();
                    break;
                }
            }
        }
        if(index>count&&n.next==null){
            System.out.println("index out of bound; number of nodes "+count+" but the given index is "+index);
        }
    }

    public void removeFirstValue(){
        head = head.next;
    }

    public void removeLastValue(){
        Node n = head;
        while(n.next!=null){
            n=n.next;
            if(n.next.next==null){
                n.next=null;
            }
        }
    }

    public void print(){
        Node n = head;
        while(n.next!=null){
            System.out.println(n.value);
            n = n.next;
        }
        System.out.println(n.value);
    }
}

class Node{
    int value;
    Node next;
}
