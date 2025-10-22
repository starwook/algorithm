import jdk.internal.org.jline.utils.Colors.s
import kotlin.math.max

class _양과늑대 {
    class Solution {
        lateinit var globalEdges: Array<MutableList<Int>>
        lateinit var globalInfo: IntArray
        var answer = 0

        fun solution(
            info: IntArray,
            edges: Array<IntArray>,
        ): Int {
            globalEdges = Array(info.size) { mutableListOf() }
            globalInfo = info

            edges.forEach {
                globalEdges[it[0]].add(it[1])
            }

            visitIfCan(0, 0, 0, setOf(0))

            return answer
        }

        fun visitIfCan(
            index: Int,
            sheepCount: Int,
            wolfCount: Int,
            nodesToVisit: Set<Int>,
        ) {
            var s = sheepCount
            var w = wolfCount
            if (globalInfo[index] == 0) {
                s += 1
            } else {
                w += 1
            }

            val currentSheep = s - w

            if (currentSheep <= 0) return
            println("$index")
            answer = max(answer, s)

            val nextToVisit = HashSet(nodesToVisit)
            nextToVisit.remove(index)

            globalEdges[index].forEach { nextIndex ->
                nextToVisit.add(nextIndex)
            }

            nextToVisit.forEach { i ->
                val nodes = HashSet(nextToVisit)
                visitIfCan(i, s, w, nodes)
            }
        }
    }
}
