class _튜플 {
    class Solution {
        fun solution(s: String): IntArray {
            var tempS: List<List<Int>> =
                s.substring(2 until s.length - 2).split("},{").map { eachNumbers ->
                    val numbers = eachNumbers.split(",").map { it -> it.toInt() }
                    numbers.toList()
                }

            val sortedNumbers = tempS.sortedWith { o1, o2 -> o1.size - o2.size }

            var answer = mutableListOf<Int>()
            for (nums in sortedNumbers) {
                for (num in nums) {
                    if (!answer.contains(num)) answer.add(num)
                }
            }

            return answer.toIntArray()
        }
    }
}
