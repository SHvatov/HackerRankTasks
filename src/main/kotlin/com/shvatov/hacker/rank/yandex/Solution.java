package com.shvatov.hacker.rank.yandex;

class Solution {
    private static class ListItem {
        ListItem next;
        String value;

        public ListItem(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListItem{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    private static String nthFromEnd(final ListItem head, final int N) {
        ListItem current = head, previous = head;
        var iter = 0;
        while (current.next != null) {
            if (iter >= N) {
                previous = previous.next;
            }
            current = current.next;
            iter++;
        }

        return previous.value;
    }

    public static void main(final String[] args) {
        final var a = new ListItem("A");
        final var b = new ListItem("B");
        final var c = new ListItem("C");
        final var d = new ListItem("D");
        final var e = new ListItem("E");
        final var f = new ListItem("F");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(nthFromEnd(a, 2));
    }
}
