import kotlin.math.abs

class 미로탈출명령어 {
    class Solution {
        // 아 왼 오 위
        val poses: Array<Pos> = arrayOf(Pos(1, 0, "d"), Pos(0, -1, "l"), Pos(0, 1, "r"), Pos(-1, 0, "u"))
        var answer: String? = null
        var maxR = 0
        var maxC = 0
        var len = 0

        class Pos(
            val r: Int,
            val c: Int,
            val s: String,
        )

        fun solution(
            n: Int,
            m: Int,
            x: Int,
            y: Int,
            r: Int,
            c: Int,
            k: Int,
        ): String {
            len = k
            maxR = n
            maxC = m
            val distance = abs(x - r) + abs(y - c) - k
            if (distance > 0 || distance % 2 != 0) return "impossible"
            dfs(x - 1, y - 1, r - 1, c - 1, "")
            return answer!!
        }

        fun dfs(
            r: Int,
            c: Int,
            er: Int,
            ec: Int,
            s: String,
        ) {
            // println(s)
            if (answer != null) return
            if (s.length == len) {
                if (r == er && c == ec) {
                    answer = s
                }
                return
            }

            if (abs(r - er) + abs(c - ec) > len - s.length) return

            for (i in 0 until 4) {
                val nr = r + poses[i].r
                val nc = c + poses[i].c

                if (nr >= 0 && nr < maxR && nc >= 0 && nc < maxC) {
                    dfs(nr, nc, er, ec, s + poses[i].s)
                }
            }
        }
    }
}
