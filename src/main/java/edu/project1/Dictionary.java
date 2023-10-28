package edu.project1;

final class Dictionary {
    private Dictionary() {
    }

    private final static String[] WORDS = new String[] {"java", "hangman", "tinkoff", "project"};

    public static String getRandomWord() {
        int randomWordFromDictionaryIndex = (int) (Math.random() * WORDS.length);
        return WORDS[randomWordFromDictionaryIndex];
    }
}
