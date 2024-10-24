public class RedactTester {
    public static void main(String[] args) {

        Redactor r = new Redactor();

        // Test case 1
        String content1 = "This is a sample Text.";
        String[] redactWords1 = {"sample"};
        System.out.println(r.redact(content1, redactWords1));
        // Expected output: "This is a ****** Text."

        // Test case 2
        String content2 = "Redact These words: apple, Banana, cherry.";
        String[] redactWords2 = {"apple", "bananA", "cherry"};
        System.out.println(r.redact(content2, redactWords2));
        // Expected output: "Redact These words: *****, ******, ******."

        // Test case 3
        String content3 = "Do not redact hyphenated-words or words with apostrophes like John's.";
        String[] redactWords3 = {"hyphenated-words", "John's"};
        System.out.println(r.redact(content3, redactWords3));
        // Expected output: "Do not redact hyphenated-words or words with apostrophes like John's."

        // Test case 4 (empty redactWords)
        String content4 = "No words should be redacted here.";
        String[] redactWords4 = {};
        System.out.println(r.redact(content4, redactWords4));
        // Expected output: "No words should be redacted here."

        // Test case 5: Redaction with hyphenated words and words with apostrophes
        String content5 = "Hyphenated-word. John's word. Chris' dog is nice.";
        String[] redactWords5 = {"Hyphenated-word", "John's", "dog"};
        System.out.println(r.redact(content5, redactWords5));
        // Expected output: "Hyphenated-word. John's word. Chris' *** is nice."

        // Test case 6: Redaction with punctuation
        String content6 = "Punctuation! Remove, it. Keep colons: and semicolons;";
        String[] redactWords6 = {"Remove", "colons", "and", "semicolons"};
        System.out.println(r.redact(content6, redactWords6));
        // Expected output: "***! *****, **. Keep *****: *** *******;"

        // Test case 7: Words with mixed capitalization
        String content7 = "Mixed capitalization. upperCase, LoWErCaSE, MiXeDcAsE.";
        String[] redactWords7 = {"Mixed", "upperCase", "lowercase"};
        System.out.println(r.redact(content7, redactWords7));
        // Expected output: "***** capitalization. *********, *********, MiXeDcAsE."


        // Test case 8: Words with numbers and special characters
        String content8 = "123 Redact 456 special! characters @#$%^&*";
        String[] redactWords8 = {"123", "redact", "special", "characters"};
        System.out.println(r.redact(content8, redactWords8));
        // Expected output: "123 ****** 456 *******! ********** @#$%^&*"

        // Test case 9: Basic
        String content9 = "The quick brown fox jumps over the lazy dog!";
        String[] redactWords9 = {"Fox", "jump", "dog"};
        System.out.println(r.redact(content9, redactWords9));
        // Expected output: "The quick brown *** jumps over the lazy ***!"
    }
}