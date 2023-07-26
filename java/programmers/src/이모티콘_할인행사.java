public class 이모티콘_할인행사 {
    class TmpPrice{
        int price;
        int percent;
        TmpPrice(int x,int y){
            this.price = x;
            this.percent = y;
        }
    }
    class Solution {
        int[] percent = {10, 20, 30, 40};
        int[] cloneEmoticons;
        TmpPrice[] tmpPrice;
        int[] answer = new int[2];

        public int[] solution(int[][] users, int[] emoticons) {
            answer[0] = 0;
            answer[1] = 0;
            tmpPrice = new TmpPrice[emoticons.length];
            cloneEmoticons = emoticons.clone();
            bf(0, users);

            return answer;
        }

        public void bf(int index, int[][] users) {
            if (index == cloneEmoticons.length) {
                checkUser(users);
                return;
            }
            for (int i = index; i < cloneEmoticons.length; i++) {
                for (int j = 0; j < 4; j++) {
                    tmpPrice[i] = new TmpPrice(cloneEmoticons[i] -
                            cloneEmoticons[i] * percent[j] / 100, (j + 1) * 10);
                    bf(i + 1, users);
                }
            }
        }

        public void checkUser(int[][] users) {
            int totalPrice = 0;
            int totalPlus = 0;
            for (int i = 0; i < users.length; i++) {
                int userPrice = 0;
                for (int j = 0; j < tmpPrice.length; j++) {
                    if (tmpPrice[j].percent >= users[i][0]) {
                        userPrice += tmpPrice[j].price;
                        if (userPrice >= users[i][1]) {
                            userPrice = 0;
                            totalPlus++;
                            break;
                        }
                    }
                }
                totalPrice += userPrice;
            }
            if (totalPlus > answer[0]) {
                answer[0] = totalPlus;
                answer[1] = totalPrice;
                return;
            }
            if (totalPlus == answer[0] && totalPrice > answer[1]) {
                answer[1] = totalPrice;
            }


        }
    }
}


