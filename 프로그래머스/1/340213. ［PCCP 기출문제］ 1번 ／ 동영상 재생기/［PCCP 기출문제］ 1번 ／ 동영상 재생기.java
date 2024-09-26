class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] strVideo = video_len.split(":");
        String[] strPos = pos.split(":");
        String[] strOp_start = op_start.split(":");
        String[] strOp_end = op_end.split(":");

        int intVideo = Integer.parseInt(strVideo[0]) * 60 + Integer.parseInt(strVideo[1]);
        int intPos = Integer.parseInt(strPos[0]) * 60 + Integer.parseInt(strPos[1]);
        int intOp_start = Integer.parseInt(strOp_start[0]) * 60 + Integer.parseInt(strOp_start[1]);
        int intOp_end = Integer.parseInt(strOp_end[0]) * 60 + Integer.parseInt(strOp_end[1] );

        if(intOp_start <= intPos && intOp_end >= intPos){
            intPos = intOp_end;
        }
        for (String command : commands) {
            int nextTime = intPos;
            if(command.equals("prev")){
                nextTime -= 10;
                if(nextTime < 0){
                    nextTime = 0;
                }
            }else {
                nextTime += 10;
                if(nextTime > intVideo){
                    nextTime = intVideo;
                }
            }
            if(intOp_start <= nextTime && intOp_end >= nextTime)
                nextTime = intOp_end;
            intPos = nextTime;

        }
        String minute = intPos / 60 + "";
        
        if(minute.length() == 1){
            minute = "0" + minute;
        }
        String second = intPos % 60 + "";
        
        if(second.length() == 1){
            second = "0" + second;
        }
        return minute + ":" +second;
    
    }
}