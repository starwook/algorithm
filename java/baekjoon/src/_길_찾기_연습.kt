class _길_찾기_연습 {
    class Solution {
        var nodes = mutableListOf<Node>()
        var yLevels = listOf<Int>()
        var nodeSize: Int = 0

        fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
            nodeSize = nodeinfo.size
            val yL = mutableListOf<Int>()
            nodeinfo.indices.forEach {
                nodes.add(
                    Node(
                        it,
                        nodeinfo[it][0],
                        nodeinfo[it][1],
                    ),
                )
                yL.add(nodeinfo[it][1])
            }

            yL.sort()
            yLevels = yL.reversed().distinct()

            nodes.sortWith { o1, o2 ->
                if (o2.y == o1.y) {
                    o1.x - o2.x
                } else {
                    o2.y - o1.y
                }
            }

            return arrayOf()
        }

        fun makeTree(
            currentIndex: Int,
            currentYLevelIndex: Int,
        ) {
            // 마지막 노드라면 return
            if (currentIndex + 1 == nodeSize) return
            val currentNode = nodes[currentIndex]
            val currentY

            for (i in currentIndex + 1..nodeSize - 1) {
                val nextNode = nodes[i]
                if (nextNode.y == currentNode.y) {
                    continue
                } // 바로 아래 자식이라면
                else if (nextNode.y < currentNode.y) {
                    if (nextNode.x < currentNode.x) {
                        // 왼쪽 자식
                        currentNode.leftChild = nextNode
                        makeTree(i, currentYLevelIndex)
                    } else {
                        // 오른쪽 자식
                        currentNode.rightChild = nextNode
                        makeTree(i, currentYLevelIndex + 1)
                    }
                }
            }
        }

        class Node(
            val number: Int,
            val x: Int,
            val y: Int,
            var parent: Node? = null,
            var leftChild: Node? = null,
            var rightChild: Node? = null,
        ) {
            fun setLeftChild(node: Node) {
                this.leftChild = node
                node.parent = this
            }

            fun setRightChild(node: Node) {
                this.rightChild = node
                node.parent = this
            }
        }
    }
}
