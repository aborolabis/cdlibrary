package pl.izabelak.cdlibrary;

public class TimeUtils {

    public static String getTimeToString(int seconds){
        int mins = seconds / 60;
        int secondsLeft = seconds - (mins*60);
        String secondsString = "";
        if(secondsLeft < 10){
            secondsString = "0" + secondsLeft;
        } else {
            secondsString = String.valueOf(secondsLeft);
        }
        return mins + ":" + secondsString;
    }

}
