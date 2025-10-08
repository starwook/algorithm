import java.util.PriorityQueue

class _합승택시요금 {
    class Solution {
        val inf = 100000000
        lateinit var cost: Array<IntArray>
        val globalFares: MutableMap<Int, MutableList<Node>> = mutableMapOf()

        fun solution(
            n: Int,
            s: Int,
            a: Int,
            b: Int,
            fares: Array<IntArray>,
        ): Int {
            cost = Array(n + 1) { IntArray(n + 1) { inf } }
            for (i in 1..n) {
                cost[i][i] = 0
            }

            for (i in 1..n) this.globalFares[i] = mutableListOf()
            fares.forEach {
                val from = it[0]
                val to = it[1]
                val cost = it[2]
                globalFares[from]!!.add(Node(to, cost))
                globalFares[to]!!.add(Node(from, cost))
            }

            for (i in 1..n) {
                dijkstra(i)
            }

            var answer = inf
            for (i in 1..n) {
                val totalCost = cost[s][i] + cost[i][a] + cost[i][b]
                if (answer > totalCost) answer = totalCost
            }
            return answer
        }

        fun dijkstra(node: Int) {
            val pq = PriorityQueue<Node> { o1, o2 -> o1.cost - o2.cost }
            pq.add(Node(node, 0))
            val tmpDist = cost[node]

            while (pq.isNotEmpty()) {
                val n = pq.poll()

                if (tmpDist[n.num] < n.cost) continue

                val nodesCanGo = globalFares[n.num]!!

                for (nextNode in nodesCanGo) {
                    if (tmpDist[nextNode.num] > tmpDist[n.num] + nextNode.cost) {
                        tmpDist[nextNode.num] = tmpDist[n.num] + nextNode.cost
                        pq.add(Node(nextNode.num, tmpDist[nextNode.num]))
                    }
                }
            }
        }

        class Node(
            val num: Int,
            val cost: Int,
        )
    }
}
