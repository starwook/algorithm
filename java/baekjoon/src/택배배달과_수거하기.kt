import kotlin.math.max

class 택배배달과_수거하기 {
    class Solution {
        var boxToDeliverI = 0
        var boxToPickI = 0

        fun solution(
            cap: Int,
            n: Int,
            deliveries: IntArray,
            pickups: IntArray,
        ): Long {
            val a = Int.MAX_VALUE
            var answer: Long = 0L
            for (i in 0 until n) {
                if (deliveries[i] != 0) boxToDeliverI = i
                if (pickups[i] != 0) boxToPickI = i
            }
            if (boxToDeliverI == 0 && boxToPickI == 0) return answer

            while (boxToPickI >= 0 || boxToDeliverI >= 0) {
                val maxDi = boxToDeliverI
                val maxPi = boxToPickI
                var boxCapForDeliver = cap

                while (boxToDeliverI >= 0) {
                    if (boxCapForDeliver <= 0) break
                    // 가져갈 수 있는 박스가 더 많을 때
                    if (deliveries[boxToDeliverI] < boxCapForDeliver) {
                        boxCapForDeliver -= deliveries[boxToDeliverI]
                        deliveries[boxToDeliverI] = 0
                    }
                    // 가져가야하는 박스가 남았을 때
                    else if (deliveries[boxToDeliverI] >= boxCapForDeliver) {
                        deliveries[boxToDeliverI] -= boxCapForDeliver
                        boxCapForDeliver = 0
                    }

                    // 다음 가져가야하는 박스 위치 찾기
                    while (boxToDeliverI >= 0 && deliveries[boxToDeliverI] == 0) boxToDeliverI--
                }

                var boxCapForPick = cap

                while (boxToPickI >= 0) {
                    if (boxCapForPick <= 0) break
                    // 가져갈 수 있는 박스가 더 많을 때
                    if (pickups[boxToPickI] < boxCapForPick) {
                        boxCapForPick -= pickups[boxToPickI]
                        pickups[boxToPickI] = 0
                    } else if (pickups[boxToPickI] >= boxCapForPick) {
                        pickups[boxToPickI] -= boxCapForPick
                        boxCapForPick = 0
                    }

                    // 다음 가져가야하는 박스 위치 찾기
                    while (boxToPickI >= 0 && pickups[boxToPickI] == 0) boxToPickI--
                }

                // println(deliveries.toList())
                // println(pickups.toList())
                answer += (max(maxDi, maxPi) + 1).toLong()
            }

            return answer * 2
        }
    }
}
