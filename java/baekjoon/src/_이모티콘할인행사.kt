class _이모티콘할인행사 {
    class Solution {
        val discountRate = intArrayOf(0, 10, 20, 30, 40)
        var emoticonCount = 0
        lateinit var globalEmoticons: IntArray
        val answer = IntArray(2)
        lateinit var gUsers: Array<IntArray>

        fun solution(
            users: Array<IntArray>,
            emoticons: IntArray,
        ): IntArray {
            gUsers = users
            emoticonCount = emoticons.size
            globalEmoticons = emoticons

            checkDiscountedEmoticons(mutableListOf<Emoticon>(), 0)
            return answer
        }

        fun checkDiscountedEmoticons(
            discountedEmoticons: MutableList<Emoticon>,
            index: Int,
        ) {
            if (index == emoticonCount) {
                checkEveryUser(discountedEmoticons)
                return
            }

            for (rate in discountRate) {
                val e = globalEmoticons.get(index)
                val discountedEmoticon = Emoticon(e - e * rate / 100, rate)

                discountedEmoticons.add(discountedEmoticon)
                checkDiscountedEmoticons(discountedEmoticons, index + 1)
                discountedEmoticons.removeLast()
            }
        }

        class Emoticon(
            val price: Int,
            val discountRate: Int,
        )

        // 유저마다 체크
        fun checkEveryUser(discountedE: MutableList<Emoticon>) {
            var totalPayed = 0L
            var emoticonPlusCount = 0
            for (user in gUsers) {
                val rateForBuying = user[0]
                val minPrice = user[1]

                var payed = 0L
                for (e in discountedE) {
                    if (e.discountRate >= rateForBuying) {
                        payed += e.price
                    }
                }

                if (payed >= minPrice) {
                    payed = 0
                    emoticonPlusCount++
                }
                totalPayed += payed
            }

            if (answer[0] < emoticonPlusCount) {
                answer[0] = emoticonPlusCount
                answer[1] = totalPayed.toInt()
                // println("new ${answer[0]} - ${answer[1]}")
                discountedE.forEach {
                    // println("${it.price} / ${it.discountRate}")
                }
            } else if (answer[0] == emoticonPlusCount) {
                answer[1] = max(answer[1], totalPayed.toInt())
                // println("new ${answer[0]} - ${answer[1]}")
                discountedE.forEach {
                    // println("${it.price} / ${it.discountRate}")
                }
            }
        }
    }
}
