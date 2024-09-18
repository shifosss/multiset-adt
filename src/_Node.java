
/*
 * <description>
 * @classname   _Node
 * @params  item, next
 * @return
 * @package PACKAGE_NAME
 * @author  Alex Zhang
 * @date   16-Sep.-2024 6:17 p.m.
 * @version 1.0
 */

class _Node {

    private int items;
    private _Node next;

    public _Node(int item, _Node next) {
        this.items = item;
        this.next = next;
    }
}
