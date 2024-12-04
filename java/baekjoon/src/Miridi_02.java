public class Miridi_02 {
    public static void main(String[] args) {
        int[][] printerGrid = {
                {0, 3},
                {2, 1}
        };
        int[][] paperGrid = {
                {0, 3, 2, 1},
                {0, 0, 0, 3},
                {2, 1, 2, 1}
        };

        int result = countStops(printerGrid, paperGrid);
        System.out.println("정지 횟수: " + result);  // 정지 횟수 출력
    }

    // 프린터가 이동하면서 겹치는 부분을 비교하여 정지 횟수를 계산하는 함수
    public static int countStops(int[][] printerGrid, int[][] paperGrid) {
        int n = printerGrid.length;      // 프린터 행 크기
        int m = printerGrid[0].length;   // 프린터 열 크기
        int row = paperGrid.length;      // 용지 행 크기
        int col = paperGrid[0].length;   // 용지 열 크기

        int stopCount = 0;  // 정지 횟수
        int answer =0;

        // 프린터가 이동할 수 있는 범위를 탐색 (초기 위치는 오른쪽 아래 모서리 한 칸만 겹침)
        for (int startX = 0; startX <= row - n; startX++) {
            if (startX % 2 == 0) {  // 오른쪽으로 이동
                for (int startY = 0; startY <= col - m; startY++) {
                    answer+=checkOverlap(printerGrid, paperGrid, startX, startY);

                }
            } else {  // 왼쪽으로 이동
                for (int startY = col - m; startY >= 0; startY--) {
                    answer+=checkOverlap(printerGrid, paperGrid, startX, startY);
                }
            }
        }

        return stopCount;
    }

    // 프린터와 용지의 겹치는 부분을 모두 검사하는 함수
    public static int checkOverlap(int[][] printerGrid, int[][] paperGrid, int startX, int startY) {
        int n = printerGrid.length;
        int m = printerGrid[0].length;
        int stopCount=0;

        // 프린터와 용지의 겹치는 모든 칸을 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (printerGrid[i][j] == paperGrid[startX + i][startY + j]) {
                    stopCount++;
                }
            }
        }
        return stopCount;
    }
}
