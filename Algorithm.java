/* Submitted by: Radge Carbonel
 * BSCS -1
 * CC4 - 1B
 * Title: My Unique Algorithm
 */

import java.util.Scanner;

public class Algorithm {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        System.out.println("My Unique Algorithm");
        System.out.println("Algorithm: When choosing what to read online");
        System.out.println("1. I will be doing my normal routine of checking my social media accounts\n2. I will be checking the news feed of my social media accounts\n3. What social media app will I go?");
        System.out.println("    a. Facebook\n    b. Twitter\n    c. Instagram\n    d. Youtube\n    e. Tiktok");

        String socialMedia = "";

        for (; socialMedia.equals("");) {
            System.out.print("Enter choice: ");
            String choice1 = choice.nextLine();

            if (choice1.equals("a")) {
                socialMedia = "Facebook";
            } else if (choice1.equals("b")) {
                socialMedia = "Twitter";
            } else if (choice1.equals("c")) {
                socialMedia = "Instagram";
            } else if (choice1.equals("d")) {
                socialMedia = "Youtube";
            } else if (choice1.equals("e")) {
                socialMedia = "Tiktok";
            } else {
                System.out.println("Invalid Input");
            }
            if (!socialMedia.equals("")) {
                choice.close();
            }
        }
        
        System.out.printf("4. I will be checking the news feed of %s.", socialMedia);
        System.out.println("\n5. While scrolling down, I will be looking for a post of a manga/manhwa that will catch my attention.");
        System.out.println("6. While finding for a manhwa/manga, I will be looking at videos and posts.");
        System.out.println("7. If I didn't found a post that will catch my attention, I will be going back to step 4.");
        System.out.println("8. I will then be checking websites that has the manga/manhwa that I will be reading.");
        System.out.println("9. If I didn't find a website that has the manga/manhwa that I will be reading, I will be going back to step 4.");
        System.out.println("10. If I finished reading the manga/manhwa, I will be going back to step 1.");
    }
}
