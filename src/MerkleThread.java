import java.util.ArrayList;

public class MerkleThread implements Runnable {

    public static volatile ArrayList<String> lstWords;
    private int iMerkleTreeInputs = 4;

    public void run() {
        Util oUtil = new Util();
        lstWords = new ArrayList<>();
        while (true) {
            oUtil.sleepRandomTime("merkle");
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null) {
                System.out.println("Merkel grabbed word");
                lstWords.add(sNewWord);
                if (lstWords.size() == iMerkleTreeInputs) {
                    MerkleManager.sMerkleRoot = oUtil.getMerkleRoot(lstWords);
                }
            }
        }
    }
}