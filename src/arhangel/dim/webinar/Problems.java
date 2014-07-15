package arhangel.dim.webinar;

/**
 *
 */
public class Problems {

    public static class List {
        int val;
        List next;

        public List(int val, List next) {
            this.val = val;
            this.next = next;
        }
    }

    static List reverse(List head) {
        List currentHead = head;
        List next = head.next;
        currentHead.next = null;

        while (next != null) {
            List tmp = next.next;
            next.next = currentHead;
            currentHead = next;
            next = tmp;
        }
        return currentHead;
    }

    static void printList(List head) {
        System.out.print("(");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(")");
    }


    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        } else {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                    return false;
            }
        }
        return true;
    }

}
