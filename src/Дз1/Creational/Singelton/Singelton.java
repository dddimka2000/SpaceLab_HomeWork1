package Äç1.Creational.Singelton;

public class Singelton {
    private static Singelton singelton;
    private static String logfile="This is log file.\n";

    public static synchronized Singelton getSingelton() {
        if(singelton == null){
            singelton= new Singelton();
        }
        return singelton;
    }
    private Singelton(){
    }
    public void addLogInfo(String logfile){
        this.logfile+=logfile+"\n";
    }
    public void showLogFile(){
        System.out.println(logfile);
    }
}
