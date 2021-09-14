//utility class
//This class is something to use in project1
//class used to create the nodes

import java.security.SecureRandom; //needed for the sleep method (cpoy code 2/2)
import java.util.ArrayList; //needed for the arrayList of strings
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

public class Util
{

    public String getMerkleRoot(ArrayList<String> firstItems){//Method that is expecting to take in an ArrayList of Strings
        MerkleNode oNode1 = new MerkleNode(); //item 1
        MerkleNode oNode2 = new MerkleNode(); // item 2
        MerkleNode oNode3 = new MerkleNode(); // item 3
        MerkleNode oNode4 = new MerkleNode(); // item 4
        MerkleNode oNode5 = new MerkleNode(); // item 5
        MerkleNode oNode6 = new MerkleNode(); // item 6
        MerkleNode oNode7 = new MerkleNode(); // item 7

        oNode1.sHash = generateHash(firstItems.get(0)); //building merkle tree
        oNode2.sHash = generateHash(firstItems.get(1)); //building merkle tree
        oNode3.sHash = generateHash(firstItems.get(2)); //building merkle tree
        oNode4.sHash = generateHash(firstItems.get(3)); //building merkle tree


        populateMerkleNode(oNode5, oNode1, oNode2);
        populateMerkleNode(oNode6, oNode3, oNode4);
        populateMerkleNode(oNode7, oNode5, oNode6);

        return oNode7.sHash;

    }


    private void populateMerkleNode(MerkleNode oNode, MerkleNode oLeftNode, MerkleNode oRightNode){

        oNode.oLeft = oLeftNode;
        oNode.oRight = oRightNode;
        oNode.sHash = generateHash(oNode.oLeft.sHash + oNode.oRight.sHash);

    }

    public synchronized String generateHash(String sOriginal){ //method that generates the hash

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(
                    sOriginal.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception ex){

            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }
    public String promptUser(String sQuestion){

        JOptionPane oQuestion  = new JOptionPane();
        String sAnswer = oQuestion.showInputDialog(sQuestion);
        return sAnswer;
    }


    public void sleepRandomTime(String sThreadName){


        int iSleepTime = new SecureRandom().nextInt(5) + 3;

        System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
        sleep(iSleepTime);
    }



    public void sleep(int iSeconds){

        try{
            Thread.sleep(iSeconds * 1000);
        }
        catch(Exception ec){

        }
    }
}
