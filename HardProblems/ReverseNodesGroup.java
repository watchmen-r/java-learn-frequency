class ListNode {
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

class ReverseNodesGroup {
    public ListNode reverseLinkedList(ListNode head, int k) {
        // reverse k node of the given linked list
        // This function assumes that the list contains at least k nodes
        ListNode newHead = null;
        ListNode ptr = head;

        while(k > 0) {
            ListNode nextNode = ptr.next;

            ptr.next = newHead;
            newHead = ptr;

            ptr = nextNode;

            k--;
        }

        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;

        ListNode newHead = null;

        while(ptr != null) {
            int count = 0;
            
            // Start counting nodes from the head
            ptr = head;
            // find the head of the next k nodes
            while(count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }

            // If I counted k nodes, reverse them
            if(count == k) {
                // reverse k node and get the new head
                ListNode revHead = reverseLinkedList(head, k);

                if(newHead == null) {
                    newHead = revHead;
                }

                // ktail is the tail of the previous block of reversed k nodes
                if(ktail != null) {
                    ktail.next = revHead;
                }

                ktail = head;
                head = ptr;
            }
        }

        // attach the final, possible un-reversed portion
        if(ktail != null) {
            ktail.next = head;
        }

        return newHead == null ? head: newHead;
    }
}