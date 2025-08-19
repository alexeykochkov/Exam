public class While {
    public static void main(String[] args) {
        String text = "Hellow";
        System.out.println(whileReverse(text));
    }

    public static char[] whileReverse(String string) {
        char[] newChars = string.toCharArray();
        int clengh = newChars.length - 1;
        int start = 0;
        while (start < clengh) {
            char stash = newChars[start];
            newChars[start] = newChars[clengh];
            newChars[clengh] = stash;
            start++;
            clengh--;
        }
        return newChars;
    }
}
