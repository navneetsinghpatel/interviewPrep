public class LinkedList {

    Node headNode;

    public void add(int val){

        Node newNode = new Node();
        newNode.value= val;
        newNode.nextNode= null;

        if(headNode == null){
            headNode= newNode;
        }else {

            Node n = headNode;
            while (n.nextNode!=null){
                n = n.nextNode;
            }
            n.nextNode = newNode;
        }
    }

    public void addAtFirst(int val){

        Node newNode = new Node();
        newNode.value= val;
        newNode.nextNode= headNode;
        headNode = newNode;
    }
    public void addAt(int index, int val){

        Node newNode = new Node();
        newNode.value= val;
        newNode.nextNode= null;
        int i = 0;
        boolean added = false;
        Node n = headNode;
        while (n.nextNode!=null){
            if(i==index){
                addAtFirst(val);
                System.out.println("Added at the start");
                added = true;
                break;
            }else if(i==index-1){
                newNode.nextNode = n.nextNode;
                n.nextNode = newNode;
                added = true;
                break;
            }else {
                n = n.nextNode;
            }
            i++;
        }
        if(!added && i == index-1){
            add(val);
            System.out.println("Added at the End");
        }else if(!added && index > i){
            System.out.println("Invalid Index");
        }
    }

    public void delete(int val){
        Node n = headNode;
        Node temp;
        boolean deleted = false;
        if(headNode.value == val){
            temp = headNode.nextNode;
            headNode.nextNode = null;
            headNode = temp;
            deleted = true;
            System.out.println("Deleted Value at the head");
        }else{
            while (n.nextNode!=null){
                if(n.nextNode.value==val){
                    temp = n.nextNode;
                    n.nextNode = temp.nextNode;
                    temp = null;
                    deleted = true;
                    break;
                }else {
                    n = n.nextNode;
                }
            }
        }
        if(!deleted){
            System.out.println("Value is not Present in the List");
        }
    }

    public void show(){
        Node node = headNode;
        while (node.nextNode!=null){
            System.out.print(node.value+", ");
            node = node.nextNode;
        }
        System.out.println(node.value);
    }

}
