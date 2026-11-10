public class Main {
    public static void main(String[] args) {
        // Support running interactive terminal mode
        if (args.length > 0 && (args[0].equalsIgnoreCase("--interactive") || args[0].equalsIgnoreCase("-i"))) {
            TerminalInterface.main(args);
            return;
        }

        // Automated Integrated Tests (Professor's Reference - Slides 33 to 38)
        Person[] p = new Person[2]; // array of readers
        Book[] l = new Book[3];     // array of books

        p[0] = new Person("Marcos", 21, "M");
        p[1] = new Person("Maria", 25, "F");

        l[0] = new Book("POO na prática", "Allan Stieg", 300, p[0]);
        l[1] = new Book("Web Designer", "Marcos Pasquim", 500, p[1]);
        l[2] = new Book("A volta sem ir", "Jonas Confuso", 800, p[0]);

        // Test 1 (Slide 35): Initial book details
        System.out.println("=== TEST 1: INITIAL BOOK DETAILS (SLIDE 35) ===");
        System.out.println(l[0].details());
        System.out.println();

        // Test 2 (Slides 36 and 37): Open book and attempt to turn beyond limits (400 > 300 pages)
        System.out.println("=== TEST 2: OPEN AND TURN PAGES BEYOND LIMIT (SLIDE 37) ===");
        l[0].open();
        l[0].browse(400); // resets to 0 according to Slide 37
        System.out.println(l[0].details());
        System.out.println();

        // Test 3 (Slide 38): Page navigation with browse(200), advance twice and go back once
        System.out.println("=== TEST 3: PAGE NAVIGATION (SLIDE 38) ===");
        l[0].open();
        l[0].browse(200);
        l[0].advancePage();
        l[0].advancePage();
        l[0].backPage();
        System.out.println(l[0].details());
    }
}
