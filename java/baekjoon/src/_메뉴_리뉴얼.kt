class _메뉴_리뉴얼 {
    class Solution {
        val wordToCount: MutableMap<String, Int> = mutableMapOf()

        fun solution(
            orders: Array<String>,
            course: IntArray,
        ): Array<String> {
            orders.forEach { order ->
                val sortedOrder = order.toCharArray().sorted().joinToString("")
                course.forEach { course ->
                    dfs(0, "", sortedOrder, course)
                }
            }

            val answer = mutableListOf<String>()
            val lengthToMaxCount: MutableMap<Int, Int> = mutableMapOf()

            wordToCount
                .entries
                .forEach {
                    val length = it.key.length
                    if (lengthToMaxCount[length] != null) {
                        if (lengthToMaxCount[length]!! < it.value) {
                            lengthToMaxCount[length] = it.value
                        }
                    } else {
                        lengthToMaxCount[length] = it.value
                    }
                }

            wordToCount.forEach {
                if (lengthToMaxCount[it.key.length]!! == it.value && it.value > 1) answer.add(it.key)
            }
            answer.sort()
            return answer.toTypedArray()
        }

        fun dfs(
            depth: Int,
            word: String,
            order: String,
            lengthToBe: Int,
        ) {
            if (word.length == lengthToBe) {
                if (wordToCount.containsKey(word)) {
                    wordToCount[word] = (wordToCount[word]!! + 1)
                } else {
                    wordToCount[word] = 1
                }
                return
            }

            if (depth >= order.length) return
            dfs(depth + 1, word + order[depth], order, lengthToBe)
            dfs(depth + 1, word, order, lengthToBe)
        }
    }
}
