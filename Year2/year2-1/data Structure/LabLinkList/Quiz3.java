public class Quiz3 {
    public static MyLinkedList reverseLinkedList(MyLinkedList list) {
        if (list == null || list.size() == 0) {
            return list;
        }

        MyLinkedList result = new MyLinkedList();
        while (list.size() > 0) {
            result.add(list.remove(list.size() - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");

        System.out.printf("Original: %s\n", list);
        list = reverseLinkedList(list);
        System.out.printf("Reverse: %s\n", list);
    }
}
