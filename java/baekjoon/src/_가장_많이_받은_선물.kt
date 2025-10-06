class _가장_많이_받은_선물 {
    class Solution {
        val persons = mutableMapOf<String, Person>()

        fun solution(
            friends: Array<String>,
            gifts: Array<String>,
        ): Int {
            friends.forEach { persons[it] = Person() }

            gifts.forEach { g ->
                val from = g.split(" ")[0]
                val to = g.split(" ")[1]

                persons[from]!!.giftTo(to)
                persons[to]!!.giftFrom(from)
            }

            friends.forEach { p ->
                friends
                    .filter { it != p }
                    .forEach { f ->
                        val person = persons[p]!!
                        val friend = persons[f]!!

                        val score = person.friendToScore[f]
                        if (score == null || score == 0) {
                            // 0점이거나 없다면
                            if (person.giftScore > friend.giftScore) {
                                person.giftToReceive++
                            } else if (person.giftScore < friend.giftScore) {
                                friend.giftToReceive++
                            }
                        } else {
                            if (score > 0) {
                                person.giftToReceive++
                            } else {
                                friend.giftToReceive++
                            }
                        }
                    }
            }

            persons.forEach { println("${it.key}:${it.value.giftToReceive}") }

            return persons.entries
                .map { it.value.giftToReceive }
                .sorted()
                .reversed()[0] / 2
        }
    }

    class Person {
        var giftScore: Int = 0
        val friendToScore = mutableMapOf<String, Int>()

        var giftToReceive: Int = 0

        fun giftFrom(name: String) {
            val g = friendToScore.getOrDefault(name, 0)
            friendToScore[name] = g - 1
            giftScore--
        }

        fun giftTo(name: String) {
            val g = friendToScore.getOrDefault(name, 0)
            friendToScore[name] = g + 1
            giftScore++
        }
    }
}
