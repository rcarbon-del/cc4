/* Submitted by: Radge Carbonel
 * BSCS -1
 * CC4 - 1B
 * Title: My Unique Algorithm
 */

import java.util.Scanner;

public class Algorithm {
    public static int ctr = 0;
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in); ctr++;
        System.out.println("My Unique Algorithm"); ctr++;
        System.out.println("Algorithm: When choosing what to read online"); ctr++;
        System.out.println("1. I will be doing my normal routine of checking my social media accounts"); ctr++;
        System.out.println("2. I will be checking the news feed of my social media accounts"); ctr++;
        System.out.println("3. What social media app will I go?"); ctr++;
        System.out.println("    a. Facebook"); ctr++;
        System.out.println("    b. Twitter"); ctr++;
        System.out.println("    c. Instagram"); ctr++;
        System.out.println("    d. Youtube"); ctr++;
        System.out.println("    e. Tiktok"); ctr++;
        String socialMedia = ""; ctr++;
        int timeOnSocialMedia = 0; ctr++;
        ctr++;
        for (; socialMedia.equals("");) {ctr++; ctr++;
            System.out.print("Enter choice: "); ctr++;
            String choice1 = choice.nextLine(); ctr++;

            if (choice1.equals("a")) {
                socialMedia = "Facebook"; ctr++;
                timeOnSocialMedia = 10; ctr++;
            } else if (choice1.equals("b")) {
                socialMedia = "Twitter"; ctr++;
                timeOnSocialMedia = 9; ctr++;
            } else if (choice1.equals("c")) {
                socialMedia = "Instagram"; ctr++;
                timeOnSocialMedia = 8; ctr++;
            } else if (choice1.equals("d")) {
                socialMedia = "Youtube"; ctr++;
                timeOnSocialMedia = 11; ctr++;
            } else if (choice1.equals("e")) {
                socialMedia = "Tiktok"; ctr++;
                timeOnSocialMedia = 11; ctr++;
            } else {
                System.out.println("Invalid Input"); ctr++;
            }
            if (!socialMedia.equals("")) {
                choice.close(); ctr++;
            }
        }
        
        System.out.printf("4. I will be checking the news feed of %s.", socialMedia); ctr++;
        System.out.println("\n5. While scrolling down, I will be looking for a post of a manga/manhwa that will catch my attention."); ctr++;
        System.out.println("6. While finding for a manhwa/manga, I will be looking at videos and posts.");  ctr++;
        ctr++;
        for (int i = 0; i < timeOnSocialMedia; i++) {ctr++; ctr++;
            System.out.print("."); ctr++;
        }
        System.out.println("\n7. If I didn't found a post that will catch my attention, I will be going back to step 4."); ctr++;
        System.out.println("8. I will then be checking websites that has the manga/manhwa that I will be reading."); ctr++;
        System.out.println("9. If I didn't find a website that has the manga/manhwa that I will be reading, I will be going back to step 4."); ctr++;
        System.out.println("10. If I finished reading the manga/manhwa, I will be going back to step 1."); ctr++;
        System.out.println(ctr);  
    }
}
