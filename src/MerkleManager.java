public class MerkleManager {


    public static String sMerkleRoot = null;
    public static String sUserRoot;
    public static volatile String userWord;
    public static int iStrikes = 0;

    public void manage(){
        Util oUtil = new Util();
        sUserRoot = oUtil.promptUser("Enter expected merkle root (https://www.xorbin.com/tools/sha256-hash-calculator): ");

        MerkleThread oMerkle = new MerkleThread();
        Thread oMerkleThread = new Thread(oMerkle);
        oMerkleThread.start();

        RogueThread oRogue = new RogueThread();
        Thread oRogueThread = new Thread(oRogue);
        oRogueThread.start();

        MonitorThread oMonitor = new MonitorThread();
        Thread oMonitorThread = new Thread(oMonitor);
        oMonitorThread.start();

        while(true) {
            userWord = oUtil.promptUser("Enter a word: ");
        }
    }
    public static synchronized String grabWord(){
        String sTempString = userWord;
        userWord = null;
        return sTempString;
    }
}
