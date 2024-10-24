/**public static String redact(String content, String[] redactWords) {
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
**/