import _1759.l

class _순위_검색 {
    class Solution {
        val lanBoard =
            mapOf(
                "cpp" to "1",
                "java" to "2",
                "python" to "3",
            )
        val fieldBoard = mapOf("backend" to "1", "frontend" to "2")
        val careerBoard = mapOf("junior" to "1", "senior" to "2")
        val foodBoard = mapOf("chicken" to "1", "pizza" to "2")

        val applicantScores = mutableMapOf<String, MutableList<Int>>()

        fun solution(
            info: Array<String>,
            query: Array<String>,
        ): IntArray {
            info.forEach { i ->
                val infos = i.split(" ")
                val identifier = lanBoard[infos[0]] + fieldBoard[infos[1]] + careerBoard[infos[2]] + foodBoard[infos[3]]

                applicantScores
                    .getOrPut(identifier) { mutableListOf() }
                    .add(infos[4].toInt())
            }

            applicantScores.entries.forEach { it.value.sort() }

            return query
                .map { q ->
                    val infos = q.split(" ")

                    val lan = lanBoard[infos[0]]?.let { listOf(it) } ?: lanBoard.map { it.value }
                    val field = fieldBoard[infos[2]]?.let { listOf(it) } ?: fieldBoard.map { it.value }
                    val career = careerBoard[infos[4]]?.let { listOf(it) } ?: careerBoard.map { it.value }
                    val food = foodBoard[infos[6]]?.let { listOf(it) } ?: foodBoard.map { it.value }
                    val score = infos[7].toInt()

                    var scorePassed = 0

                    lan.forEach { l ->
                        field.forEach { f ->
                            career.forEach { c ->
                                food.forEach { f2 ->
                                    val identifier = l + f + c + f2
                                    applicantScores[identifier]?.let { scores ->
                                        var low = 0
                                        var high = scores.size
                                        while (low < high) {
                                            val mid = (low + high) / 2
                                            if (scores[mid] < score) {
                                                low = mid + 1
                                            } else {
                                                high = mid
                                            }
                                        }

                                        scorePassed += (scores.size - low)
                                    }
                                }
                            }
                        }
                    }
                    scorePassed
                }.toIntArray()
        }
    }
}
