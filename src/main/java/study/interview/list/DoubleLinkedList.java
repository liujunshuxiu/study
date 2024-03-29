package study.interview.list;

public class DoubleLinkedList<E> {
    class Node {
        private Node previous;
        private Node next;
        private E e;

        public Node(Node previous, Node next, E e) {
            this.previous = previous;
            this.next = next;
            this.e = e;
        }
    }

    private Node first;//指向第一个元素
    private Node last;//指向最后一个元素
    private int length=0;//链表长度


    public void addFirst(E e){
        if(first == null){
            Node node = new Node(null,null,e);
            this.first = node;
            this.last = node;
            length ++;
        }else {
            Node node = new Node(null,first,e);
            this.first.previous=node;//当前first的前驱设置为node
            this.first=node;//将first指针指向新节点
            length++;
        }
    }

    public void addLast(E e) {
        if (last == null) {
            Node node = new Node(null, null, e);
            this.first = node;
            this.last=node;
            length++;
        }else{
            Node node=new Node(last,null,e);
            this.last.next=node;
            this.last=node;
            length++;
        }
    }


    public void insertPrevious(E baseElement,E value){
        Node index=this.first;
        while(index!=null){
            if(index.e==baseElement)break;
            index=index.next;
        }
        Node insertValue=new Node(index.previous,index,value);
        index.previous.next=insertValue;
        index.previous=insertValue;
        length++;
    }

    public void insertNext(E baseElement,E value){
        Node index=this.first;
        while(index!=null){
            if(index.e==baseElement)break;
            index=index.next;
        }
        Node insertValue=new Node(index,index.next,value);
        index.next.previous=insertValue;
        index.next=insertValue;
        length++;
    }

    public void removeElement(E value){
        Node index=this.first;
        while(index!=null){
            if(index.e==value)break;
            index=index.next;
        }
        index.previous.next=index.next;
        index.next.previous=index.previous;
        length--;
    }

    public int getLength(){
        return length;
    }
    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        Node current=this.first;
        while(current!=null){
            sb.append(current.e+"->");
            current=current.next;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        DoubleLinkedList<String> list=new DoubleLinkedList<>();
        list.addLast("value1");
        list.addLast("value2");
        list.addLast("value3");
        list.addLast("value4");
        list.addFirst("value0");
        list.insertPrevious("value3","insertValue");
        list.insertNext("value3","insertValue2");
        System.out.println(list.toString());
        System.out.println("链表的长度是"+list.getLength());
        list.removeElement("value3");
        System.out.println(list.toString());
        System.out.println("链表的长度是"+list.getLength());
    }
}
