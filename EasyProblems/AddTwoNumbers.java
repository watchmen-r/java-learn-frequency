public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int advance = 0;
        ListNode firstNode = new ListNode();
        ListNode nowNode = firstNode;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int addVal = (val1 + val2 + advance) / 10;

            if (val1 + val2 > 10) {
                advance = 1;
            } else {
                advance = 0;
            }

            ListNode node = new ListNode(addVal);
            nowNode.next = node;
            nowNode = nowNode.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (advance == 1) {
            ListNode node = new ListNode(1);
            nowNode.next = node;
        }
        return firstNode.next;
    }
}