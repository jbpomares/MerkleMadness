public class RogueThread implements Runnable {

    public void run(){
        Util oUtil = new Util();
        while (true){ 
            oUtil.sleepRandomTime("rogue");
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null){
                MerkleManager.iStrikes++;
                System.out.println("Strike");
            }
        }
    }

}
