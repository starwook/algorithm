import kotlin.math.min

class _문자열_압축 {
    class Solution {
        var answer = 0

        fun solution(s: String): Int {
            answer = s.length

            for (size in 1..s.length - 1) {
                var len = s.length
                var i = 0
                while (i <= s.length - size) {
                    val curS = s.substring(i until i + size)
                    var count = 1

//                    println("string is $curS ")
//                    println("end index of sToCompare is ${i + (size * 2) - 1}")

                    var j = i + size
                    while (true) {
                        i += size
                        if (j + size <= s.length) {
                            val sToCompare = s.substring(i..i + size - 1)
//                        println("string to Compare is $sToCompare")
                            if (sToCompare == curS) {
                                count++
                                j += size
//                            println("$s is equal to index ${i + size} to ${i + (size * 2) - 1} with $count times")
                            } else {
                                break
                            }
                        } else {
                            val tail = s.substring(j)
                            if (tail.isNotEmpty() && curS.startsWith(tail)) {
                                // 오해 압축 방지: 3aba 같은 케이스 → 압축 취소
                                count = 1
                            }
                            break
                        }
                    }

                    i = j

                    if (count > 1) {
                        len = len - (size * count) + (count.toString().length + size)
                    }
                }

                answer = min(len, answer)
            }

            return answer
        }
    }
}
