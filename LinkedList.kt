class LinkedList<E> {
    private var head : Node<E>? = null

    class Node<E>(
        var data: E,
        var next: Node<E>? = null
        )
    // 앞쪽에 노드 추가
    fun push(item: E) {
        if (head == null) {
            head = Node(item, null)
            return
        }
        val newNode = Node(item, head)
        head =  newNode
    }
    // 특정 노드 다음에 추가
    fun insertAfter(prevNode: Node<E>?, item: E) {
        if (prevNode == null) return println("이전 노드가 null 이 아니어야 합니다.")

        var nextNode = prevNode.next
        var newNode = Node(item, nextNode)
        prevNode.next = newNode
    }

    // 끝 쪽에 노드 추가
    fun append(item: E) {
        if (head == null) {
            head = Node(item, null)
            return
        }
        var newNode = Node(item, null)
        var thisNode = head
        while (thisNode?.next != null) {
            thisNode = thisNode?.next
        }
        thisNode?.next = newNode

    }
    fun getNode(idx: Int) : Node<E>? {
        if (head == null) {
            return null
        }
        var thisNode = head
        for (i in 0 until idx) {
            thisNode = thisNode?.next
        }
        return thisNode
    }

    // 출력
    fun desc() {
        if (head == null) return println("값이 존재하지 않습니다.")
        var thisNode = head
        while (thisNode?.next != null) {
            println(thisNode.data)
            thisNode = thisNode.next
        }
        println(thisNode?.data)
    }
}




fun main(args: Array<String>) {
    val linkedList = LinkedList<Int>()
    for (i in 0 until 5) {
        linkedList.push(i)
    }
    var node = linkedList.getNode(3)
    linkedList.append(5)
    linkedList.insertAfter(node, 10)
    linkedList.desc()
}
