//class LinkedList<E> {
//
//    private var head : Node<E>? = null
//
//    inner class Node<E>(
//        var data: E,
//        var next: Node<E>? = null
//    )
//    fun addFirst(item: E) {
//        head = Node(item, null)
//    }
//    fun add(item: E) {
//        if (head == null) addFirst(item)
//        else {
//            var node = head
//            while (node?.next != null) {
//                node = node?.next
//            }
//            node?.next = Node(item, null)
//        }
//    }
//    // 중간에 삽입
//    fun add(preNode: Node<E>, item: E) {
//        val newNode = Node(item, null)
//        newNode.next = preNode.next
//        preNode.next = newNode
//    }
//    fun delete(item: E) {
//        if (head == null) return println("노드가 없습니다.")
//        else {
//            if (head?.data == item) {
//                head = head?.next
//            }
//            else {
//                var node = head
//                while (node?.next?.data != item && node?.next?.data != null) {
//                    node = node?.next
//                }
//                node?.next = node?.next?.next
//            }
//        }
//    }
//    fun desc() {
//        if (head == null) return println("노드가 없습니다.")
//        else {
//            var node = head
//            while (node?.next != null) {
//                println("${node?.data}")
//                node = node?.next
//            }
//            println("${node?.data}")
//            println()
//        }
//    }
//}

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