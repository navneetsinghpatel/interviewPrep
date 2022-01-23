public class Main extends Node{


    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(1);
        list.add(9);
        System.out.println("Original List: ");
        list.show();
        list.addAtFirst(100);
        System.out.println("List after Adding at First position: ");
        list.show();

        list.addAt(4,25);
        System.out.println("List after Adding at Index 4 position: ");
        list.show();

        list.addAt(8,65);
        System.out.println("List after Adding at Index 8 position: ");
        list.show();

        list.addAt(8,50);
        System.out.println("List after Adding at Index 8 position: ");
        list.show();

        list.addAt(0,200);
        System.out.println("List after Adding at Index 0 position: ");
        list.show();

        list.addAt(15,500);
        System.out.println("List after Adding at Invalid Index position: ");
        list.show();

        list.delete(65);
        System.out.println("List after Deleting 65: ");
        list.show();

        list.delete(200);
        System.out.println("List after Deleting 200: ");
        list.show();

        list.delete(25);
        System.out.println("List after Deleting 25: ");
        list.show();

        list.delete(21731);
        System.out.println("List after Deleting 21731: ");
        list.show();

    }
}
