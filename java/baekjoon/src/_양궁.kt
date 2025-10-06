class _양궁 {
    class Solution {
        var enemyScore = 0
        var enemyBoard: IntArray = intArrayOf()
        val score = 0
        val board = IntArray(11)

        fun solution(
            n: Int,
            info: IntArray,
        ): IntArray {
            enemyScore = info.sum()
            enemyBoard = info

            if (dfs(0, 10, n)) {
                return board
            } else {
                return intArrayOf(-1)
            }
        }

        fun dfs(
            curScore: Int,
            curIndex: Int,
            curArrow: Int,
        ): Boolean {
            if (curArrow > enemyBoard[curIndex]) {
                val arrowDecreased = curArrow - (enemyBoard[curIndex] + 1)
                val scoreIncreased = curScore + 10 - curIndex
                board[curIndex] = 0
                if (curScore > enemyScore) {
                    score
                    return true
                } else {
                    return false
                }
            } else {
                return false
            }
        }
    }
}
