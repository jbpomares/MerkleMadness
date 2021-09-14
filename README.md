# MerkleMadness
Game that creates merkle root and compares to users entry
Allows user to enter in the merkle root of four words that are generated via SHA-256 Calculator. 
User then enters four strings via a multithreaded portion of the program. 
Each string is either grabbed by the merkle thread or the rogue thread. 
Once all four strings have been grabbed by the merkle thread, the merkle root created is compared to the initial merkle root entered. 
If the roots match, the user wins. If they do not, the user loses. 
Meanwhile, each word captured by the rogue thread produces a "Strike" output. 
The two background threads sleep for random seconds of time which challenges the user to time their entry so the 
merkle thread grabs the word as opposed to the rogue. 
A third monitor thread checks on the progress to tell whether the game has been lost or won. 
