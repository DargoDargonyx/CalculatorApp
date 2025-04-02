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
        /*              Test Stacks                 */
        // ArrayStack<Integer> s = new ArrayStack<>();
        // s.push(2);
        // s.push(5);
        // s.push(2);
        // System.out.println("Stack 1: " + s);
        // s.pop();
        // System.out.println("Stack 1: " + s);
        // s.pop();
        // s.pop();
        // s.pop();
        // System.out.println("Stack 1: " + s);

        // ArrayStack<String> str = new ArrayStack<>();
        // str.push("One");
        // str.push("Two");
        // str.push("Three");
        // System.out.println("Stack 2: " + str);
        /*                                          */

        openCalculator(1);
    }

    public static void openCalculator(int tabs) {

        for (int i = 0; i < tabs; i++) {
            new FrameWork();
        }
        
    } 
}
