import _1261.r
import jdk.internal.foreign.PlatformLayouts.pick
import jdk.internal.org.jline.utils.Colors.s

class _후보키 {
    class Solution {
        var columnSize = 0
        var rowSize = 0
        lateinit var rel: Array<Array<String>>
        val candidates = mutableListOf<List<Int>>()
        var answer = 0

        fun solution(relation: Array<Array<String>>): Int {
            columnSize = relation[0].size
            rowSize = relation.size
            rel = relation

            for (i in 1..columnSize) {
                makeEveryColumnComb(i, columnSize)
            }

            return answer
        }

        fun makeEveryColumnComb(
            colCombSize: Int,
            colSize: Int,
        ) {
            fun dfs(
                start: Int,
                pick: MutableList<Int>,
            ) {
                if (colCombSize == pick.size) {
                    makeEveryComb(pick)
                }
                for (i in start until colSize) {
                    pick.add(i)
                    dfs(i + 1, pick)
                    pick.removeAt(pick.size - 1)
                }
            }
            dfs(0, mutableListOf())
        }

        fun makeEveryComb(pick: List<Int>) {
            val curS = mutableSetOf<String>()
//            println("pick : $pick")
            if (!isUniqueComb(pick)) return
            for (r in 0..rowSize - 1) {
                var s = ""
                for (i in 0 until pick.size) {
                    s += ((rel[r][pick[i]]) + ",")
                }
                if (curS.contains(s)) {
                    return
                } else {
                    curS.add(s)
                }

//                println("curS : $curS")
            }
            answer++
            candidates.add(pick.toList())
//            println("added pick :$pick")
//            println("//")
        }

        fun isUniqueComb(pick: List<Int>): Boolean {
            if (candidates.any {
                    pick.containsAll(it)
                }
            ) {
                return false
            } else {
                return true
            }
        }
    }
}
