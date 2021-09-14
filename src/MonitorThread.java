public class MonitorThread implements Runnable {
    public void run() {
        Util sleep = new Util();

        while(true){
            if (MerkleManager.sMerkleRoot != null){
                if (MerkleManager.sMerkleRoot.equals(MerkleManager.sUserRoot)){
                    System.out.println("You win: " + MerkleManager.sMerkleRoot);
                    System.exit(0);
                }
                else if (!MerkleManager.sMerkleRoot.equals(MerkleManager.sUserRoot)){
                    System.out.println("Merkle root does not match. You lost!");
                    System.exit(0);
                }

            }
            else if (MerkleManager.iStrikes == 3){
                System.out.println("3 strikes your out.");
                System.exit(0);
            }
            sleep.sleep(1);
        }

    }
}
