import java.util.*;
public class 베스트앨범 {
    class Song{
        int num;
        int playTime;
        Song(int x,int y){
            this.num =x;
            this.playTime =y;
        }
    }
    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();
            Map<String, List<Song>> map = new LinkedHashMap<>();
            for (int i = 0; i < genres.length; i++) {
                List<Song> newList;
                if (map.containsKey(genres[i])) {
                    newList = map.get(genres[i]);
                } else {
                    newList = new ArrayList<>();
                }
                newList.add(new Song(i, plays[i]));
                map.put(genres[i], newList);
            }
            List<String> keySet = new ArrayList<>(map.keySet());
            keySet.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    List<Song> first = map.get(o1);
                    List<Song> second = map.get(o2);
                    int firstNum = 0;
                    int secondNum = 0;
                    for (Song song : first) {
                        firstNum += song.playTime;
                    }
                    for (Song song : second) {
                        secondNum += song.playTime;
                    }
                    if (firstNum > secondNum) {
                        return -1;
                    }
                    return 0;

                }
            });

            for (String key : keySet) {

                List<Song> songs = map.get(key);
                songs.sort(new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        if (s1.playTime == s2.playTime) {
                            if (s1.num < s2.num) {
                                return -1;
                            }
                            return 0;
                        }
                        if (s1.playTime > s2.playTime) {
                            return -1;
                        }
                        return 0;
                    }
                });
                int i = 0;
                for (Song song : songs) {
                    i++;
                    answer.add(song.num);
                    if (i == 2) {
                        break;
                    }
                }

            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

    }
}
