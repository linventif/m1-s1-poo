package launaybecue_gregoire.tp1;

public class Exo03 {
    public static String convertSecsToString(long sec) {
        String rtn = "";

        long hours = sec / 3600;
        long minutes = (sec % 3600) / 60;
        long seconds = sec % 60;

        rtn += "" + (hours > 0 ? hours + "h " : "");
        rtn += "" + (minutes > 0 ? minutes + "m " : "");
        rtn += "" + seconds + "s";

        return rtn;
    }

    public static void main(String[] args) {
        System.out.println("Exo03:");
        System.out.println(convertSecsToString(1234));
        System.out.println(convertSecsToString(5678));
        System.out.println(convertSecsToString(9101112));
    }

}
