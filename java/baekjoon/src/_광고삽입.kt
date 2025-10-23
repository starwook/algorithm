class _광고삽입 {
    class Solution {
        val times = Array<Long>(360002) { 0 }
        var playTime = 0

        fun solution(
            play_time: String,
            adv_time: String,
            logs: Array<String>,
        ): String {
            playTime = toInt(play_time) + 2

            for (log in logs) {
                val sNe = log.split("-")
                times[toInt(sNe[0])]++
                times[toInt(sNe[1])]--
            }

            // 동시 시청자 수 구하기
            for (i in 1..playTime) {
                times[i] = times[i] + times[i - 1]
            }

            // 누적 시청자 수 구하기
            for (i in 1..playTime) {
                times[i] = times[i] + times[i - 1]
            }

            val advTime = toInt(adv_time)
            var answer = "00:00:00"
            var maxPlayTime = times[advTime - 1]
            for (i in advTime until playTime) {
                val total = times[i] - times[i - advTime]
                if (maxPlayTime < total) {
                    maxPlayTime = total
                    answer = toStr(i - advTime + 1)
                }
            }

            return answer
        }

        fun toInt(str: String): Int {
            val times = str.split(":")
            return times[2].toInt() + times[1].toInt() * 60 + times[0].toInt() * 3600
        }

        fun toStr(time: Int): String {
            val hour = time / 3600
            val minute = (time % 3600) / 60
            val sec = time % 60
            return String.format("%02d:%02d:%02d", hour, minute, sec)
        }
    }
}
