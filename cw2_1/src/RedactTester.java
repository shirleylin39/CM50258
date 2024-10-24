public class RedactTester {
    public static void main(String[] args) {

        // Test case 1
        String content1 = "This is a sample Text.";
        String[] redactWords1 = {"sample"};
        System.out.println(redact(content1, redactWords1));
        // Expected output: "This is a ****** Text."

        // Test case 2
        String content2 = "Redact These words: apple, Banana, cherry.";
        String[] redactWords2 = {"apple", "bananA", "cherry"};
        System.out.println(redact(content2, redactWords2));
        // Expected output: "Redact These words: *****, ******, ******."

        // Test case 3
        String content3 = "Do not redact hyphenated-words or words with apostrophes like John's.";
        String[] redactWords3 = {"hyphenated-words", "John's"};
        System.out.println(redact(content3, redactWords3));
        // Expected output: "Do not redact hyphenated-words or words with apostrophes like John's."

        // Test case 4 (empty redactWords)
        String content4 = "No words should be redacted here.";
        String[] redactWords4 = {};
        System.out.println(redact(content4, redactWords4));
        // Expected output: "No words should be redacted here."

        // Test case 5: Redaction with hyphenated words and words with apostrophes
        String content5 = "Hyphenated-word. John's word. Chris' dog is nice.";
        String[] redactWords5 = {"Hyphenated-word", "John's", "dog"};
        System.out.println(redact(content5, redactWords5));
        // Expected output: "***. ***** word. Chris' *** is nice."

        // Test case 6: Redaction with punctuation
        String content6 = "Punctuation! Remove, it. Keep colons: and semicolons;";
        String[] redactWords6 = {"Remove", "colons", "and", "semicolons"};
        System.out.println(redact(content6, redactWords6));
        // Expected output: "***! *****, **. Keep *****: *** *******;"

        // Test case 7: Words with mixed capitalization
        String content7 = "Mixed capitalization. upperCase, LoWErCaSE, MiXeDcAsE.";
        String[] redactWords7 = {"Mixed", "upperCase", "lowercase"};
        System.out.println(redact(content7, redactWords7));
        // Expected output: "*** *******. ********, ********, *******."


        // Test case 8: Words with numbers and special characters
        String content8 = "123 Redact 456 special! characters @#$%^&*";
        String[] redactWords8 = {"123", "redact", "special", "characters"};
        System.out.println(redact(content8, redactWords8));
        // Expected output: "123 ****** 456 *******! ********** @#$%^&*"

        // Test case 9: Basic
        String content9 = "The quick brown fox jumps over the lazy dog!";
        String[] redactWords9 = {"Fox", "jump", "dog"};
        System.out.println(redact(content9, redactWords9));
    }



/*
    public static String redact(String content, String[] redactWords) {
        String[] contentWords = content.split("\\s+");
        for (int i = 0; i < contentWords.length; i++) {
            if (!(contentWords[i].contains("'") || contentWords[i].contains("-"))) {
                String contentWord_NoPunctuation = contentWords[i].replaceAll("[^a-zA-Z'-]", "");
                for (String redactWord : redactWords) {
                    if (redactWord.equalsIgnoreCase(contentWord_NoPunctuation)) {
                        StringBuilder wordRedacted = new StringBuilder();
                        for (int j = 0; j < contentWords[i].length(); j++) {
                            char letters = contentWords[i].charAt(j);
                            if (Character.isLetter(letters)) {
                                wordRedacted.append('*');
                            }
                            else {
                                wordRedacted.append(letters);
                            }
                        }
                        contentWords[i] = wordRedacted.toString();
                        break;
                    }
                }
            }
        }
        return String.join(" ", contentWords);
    }
}
*/



    public static String redact(String content, String[] redactWords) {
    String[] contentWords = content.split("\\s+");
    for (int i = 0; i < contentWords.length; i++) {
        contentWords[i] = redactWord(contentWords[i], redactWords);
    }
    return String.join(" ", contentWords);
    }

    private static String redactWord(String contentWord, String[] redactWords) {
        if (contentWord.contains("'") || contentWord.contains("-")) {
            return contentWord;
        }

        String contentWord_NoPunctuation = contentWord.replaceAll("[^a-zA-Z'-]", "");
        for (String redactWord : redactWords) {
            if (redactWord.equalsIgnoreCase(contentWord_NoPunctuation)) {
                StringBuilder redactedWord = new StringBuilder();
                for (int i = 0; i < contentWord.length(); i++) {
                    char letters = contentWord.charAt(i);
                    if (Character.isLetter(letters)) {
                        redactedWord.append('*');
                    } else {
                        redactedWord.append(letters);
                    }
                }
                return redactedWord.toString();
            }
        }
        return contentWord;
    }
}