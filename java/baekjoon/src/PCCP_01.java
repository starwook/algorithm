import java.time.Duration;

public class PCCP_01 {
    class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            int currentTime = new Time(pos).totalTime;
            int videoLength = new Time(video_len).totalTime;
            int opStart = new Time(op_start).totalTime;
            int opEnd = new Time(op_end).totalTime;


            for(int i=0;i<commands.length;i++){
                if(currentTime>=opStart&&currentTime<=opEnd){
                    currentTime = opEnd;
                }
                System.out.println(currentTime);
                String command = commands[i];
                if(command.equals("next")){
                    currentTime +=10;
                    if(currentTime > videoLength){
                        currentTime = videoLength;
                    }
                }
                if(command.equals("prev")){
                    currentTime -= 10;
                    if(currentTime<0){
                        currentTime = 0;
                    }
                }
                if(currentTime>=opStart&&currentTime<=opEnd){
                    currentTime = opEnd;
                }
            }

            Duration duration = Duration.ofSeconds(currentTime);
            long minutes = duration.toMinutes();
            long seconds = duration.minusMinutes(minutes).toSeconds();

            return String.format("%02d:%02d", minutes, seconds);
        }
    }
    class Time{
        int totalTime;

        public Time(String timeString) {
            String[] arr = timeString.split(":");
            int minute = Integer.parseInt(arr[0]);
            int second = Integer.parseInt(arr[1]);
            this.totalTime = minute * 60 + second;
        }


        public void setTotalTime(int totalTime) {
            this.totalTime = totalTime;
        }
    }
}
