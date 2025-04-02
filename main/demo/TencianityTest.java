/**
 * TencianityTest.java
 * The testing workspace for our classes and methods for this calculator app
 * 
 * @author Tencianity
 * @version 03.24.25
 */
package demo;

import storage.FrameWork;
import storage.ArrayStack;

public class TencianityTest {
    public static void main (String[] args)  {
        openCalculator(1);
    }

    public static void openCalculator(int tabs) {

        for (int i = 0; i < tabs; i++) {
            new FrameWork();
        }
        
    } 
}
