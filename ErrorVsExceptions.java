public class ErrorVsExceptions {
    public static void main(String[] args) {

        // ------------------------------
        // 1. Exception Example (Recoverable)
        // ------------------------------
        try {
            int[] marks = {90, 80, 70};
            System.out.println("Mark: " + marks[5]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("⚠️ Exception handled: " + e);
        }

        System.out.println("Program continues after handling exception ✅");

        // ------------------------------
        // 2. Error Example (Non-Recoverable)
        // ------------------------------
        try {
            causeError();  // recursive call -> StackOverflowError
        } catch (StackOverflowError e) {
            System.out.println("❌ Error caught: " + e);
        }

        System.out.println("This line may not execute after Error ❌");
    }

    // recursive method to create StackOverflowError
    static void causeError() {
        causeError();
    }
}

