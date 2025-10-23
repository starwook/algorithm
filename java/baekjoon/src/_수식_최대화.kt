class _수식_최대화 {
    class Solution {
        val operators = mutableSetOf<Char>()
        var answer: Long = 0
        lateinit var exp: String

        fun solution(expression: String): Long {
            exp = expression
            for (i in expression) {
                when (i) {
                    '*', '-', '+' -> operators.add(i)
                }
            }

            makeEveryComb(emptyList())

            return answer
        }

        fun makeEveryComb(ops: List<Char>) {
            if (ops.size == operators.size) {
                makeEveryTotal(ops)

                return
            }

            for (operator in operators) {
                if (!ops.contains(operator)) {
                    makeEveryComb(ops + listOf(operator))
                }
            }
        }

        fun makeEveryTotal(ops: List<Char>) {
            var numAndOp = mutableListOf<String>()
            println(ops)
            var i = 0
            while (i < exp.length) {
                // op라면 그냥 추가
                if (ops.contains(exp[i])) {
                    numAndOp.add(exp[i].toString())
                    i++
                } else {
                    var numStr = "" + exp[i]
                    i++
                    while (i < exp.length) {
                        if (ops.contains(exp[i])) {
                            break
                        } else {
                            numStr += exp[i]
                        }
                        i++
                    }

                    numAndOp.add(numStr)
                }
            }

            // println("origin : $numAndOp")

            var tmpAnswer = mutableListOf<String>()
            for (op in ops) {
                // println("new: $numAndOp")
                tmpAnswer = mutableListOf<String>()
                i = 0
                while (i < numAndOp.size) {
                    if (numAndOp[i][0] == op) {
                        val newNumber: Long =
                            if (op == '*') {
                                tmpAnswer.last().toLong() * numAndOp[i + 1].toLong()
                            } else if (op == '-') {
                                tmpAnswer.last().toLong() - numAndOp[i + 1].toLong()
                            } else {
                                tmpAnswer.last().toLong() + numAndOp[i + 1].toLong()
                            }
                        tmpAnswer.removeLast()
                        tmpAnswer.add(newNumber.toString())
                        i++
                    } else {
                        tmpAnswer.add(numAndOp[i])
                    }
                    i++
                }
                numAndOp = tmpAnswer
            }
            answer = max(answer, abs(tmpAnswer.get(0).toLong()))

            // println("last : $tmpAnswer")
        }
    }
}
