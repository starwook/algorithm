class 거리두기_확인하기 {
    class Solution {
        val size = 5
        val rDiff = intArrayOf(-1, 0, 1, 0)
        val cDiff = intArrayOf(0, 1, 0, -1)
        lateinit var answer: IntArray
        var visited = Array(5) { Array(5) { false } }

        fun solution(places: Array<Array<String>>): IntArray = places.map { place -> checkEachPlace(place) }.toIntArray()

        fun checkEachPlace(place: Array<String>): Int {
            println("newPlace")
            for (r in 0 until 5) {
                for (c in 0 until 5) {
                    if (place[r][c] == 'P') {
                        println("newP : $r, $c")
                        visited = Array(5) { Array(5) { false } }
                        visited[r][c] = true
                        if (!isSocialDistancing(place, r, c, 0))return 0
                    }
                }
            }
            return 1
        }

        fun isSocialDistancing(
            place: Array<String>,
            r: Int,
            c: Int,
            distance: Int,
        ): Boolean {
            // 현재 도착한 곳까지만 확인하면 된다
            if (distance == 2) {
                return true
            }
            // println("$r,$c")
            for (i in 0..3) {
                val newR = r + rDiff[i]
                val newC = c + cDiff[i]

                if (newR >= 0 && newR < 5 && newC >= 0 && newC < 5) {
                    if (place[newR][newC] == 'P' && !visited[newR][newC]) {
                        // println("p found $newR,$newC")
                        return false
                    }
                    if (place[newR][newC] == 'O') {
                        if (!visited[newR][newC]) {
                            // println("can go $newR,$newC")
                            visited[newR][newC] = true
                            val isGood = isSocialDistancing(place, newR, newC, distance + 1)
                            if (!isGood) return false
                        }
                    }
                }
            }

            return true
        }
    }
}
