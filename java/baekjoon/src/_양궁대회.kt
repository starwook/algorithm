class _양궁대회 {
    class Solution {
        lateinit var apeach: IntArray
        var maxDiff = -1
        var lion = IntArray(11)

        fun solution(
            n: Int,
            info: IntArray,
        ): IntArray {
            apeach = info
            checkEvery(0, n, IntArray(11))

            if (maxDiff == -1) {
                return intArrayOf(maxDiff)
            } else {
                return lion
            }
        }

        fun checkEvery(
            index: Int,
            remainArrow: Int,
            curLion: IntArray,
        ) {
            if (index == 10 || remainArrow == 0) {
                curLion[index] = remainArrow
                checkWinner(curLion)
                curLion[index] = 0
                return
            }

            val apeachArrow = apeach[index]
            if (apeachArrow < remainArrow) {
                val arrow = apeachArrow + 1

                curLion[index] += arrow
                checkEvery(index + 1, remainArrow - arrow, curLion)
                curLion[index] -= arrow
            }

            checkEvery(index + 1, remainArrow, curLion)
        }

        fun checkWinner(curLion: IntArray) {
            var lionScore = 0
            var apeachScore = 0
            for (i in 0 until 11) {
                val score = 10 - i
                if (curLion[i] > apeach[i]) {
                    lionScore += score
                } else if (curLion[i] < apeach[i]) {
                    apeachScore += score
                } else {
                    // 0점이 아닐 경우
                    if (curLion[i] != 0) apeachScore += score
                }
            }

            val diff = lionScore - apeachScore
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff
                    lion = curLion.clone()
                    // println("new diff : $diff list: ${lion.toList()}")
                } else if (diff == maxDiff) {
                    for (i in 10 downTo 0) {
                        if (lion[i] < curLion[i]) {
                            maxDiff = diff
                            lion = curLion.clone()
//                            println("new diff : $diff list: ${lion.toList()}")
                        } else if (lion[i] > curLion[i]) {
                            return
                        }
                    }
                }
            }
        }
    }
}
