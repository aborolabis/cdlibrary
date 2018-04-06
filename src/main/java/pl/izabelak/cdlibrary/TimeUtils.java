package pl.izabelak.cdlibrary;

public class TimeUtils {

    public static String getTimeToString(int seconds){
        int mins = seconds / 60;
        int hours = mins / 60;
        int secondsLeft = seconds - (mins*60) - (hours*60*60);
        int minLeft = mins - (hours*60);

        if(hours>0) {
            return String.format("%02d:%02d:%02d", hours, minLeft, secondsLeft);
        } else {
            return String.format("%02d:%02d", minLeft, secondsLeft);
        }
    }

}
