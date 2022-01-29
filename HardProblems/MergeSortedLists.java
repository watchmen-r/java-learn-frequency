import java.util.PriorityQueue;

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

class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int endCount = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                endCount++;
            }
        }

        ListNode answer = new ListNode();
        ListNode nowNode = answer;
        while (endCount != lists.length) {
            int minimum = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minimum == Integer.MAX_VALUE) {
                    minimum = i;
                } else {
                    minimum = lists[minimum].val <= lists[i].val ? minimum : i;
                }
            }
            nowNode.next = lists[minimum];
            nowNode = nowNode.next;
            lists[minimum] = lists[minimum].next;

            if (lists[minimum] == null) {
                endCount++;
            }
        }
        return answer.next;
    }

    public ListNode anotherMergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node : lists) {
            if(node != null) {
                queue.add(node);
            }
        }

        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if(tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}