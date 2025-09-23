public class StarFiller {
    public static void main(String[] args) {
        String input = "I am Greet";
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == ' ') {
                result = result + "**";  // Add two stars for each space
            } else {
                result = result + ch;   // Add the character itself
            }
        }

        System.out.println(result);
    }
}

