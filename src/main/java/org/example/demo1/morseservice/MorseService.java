package org.example.demo1.morseservice;

public class MorseService {

    // Morse-Code für jedes Zeichen im Alphabet
    static String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..","/"
    };

    // Alphabet mit den Zeichen 'a' bis 'z'
    static char[] abc = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',' '
    };

    // Methode, die das Alphabet als String zurückgibt
    public static String abc() {
        return new String(abc); // Macht aus dem char-Array einen String
    }

    // Methode, die das Alphabet in Morse-Code übersetzt
    public static String abcToMorse() {
        String morseText = ""; // Speichert den Morse-Code-Text

        // Schleife durch jedes Zeichen im Alphabet
        for (int i = 0; i < abc.length; i++) {
            morseText += morse[i] + " "; // Hängt das Morse-Zeichen und ein Leerzeichen an
        }

        return morseText.trim(); // Entfernt das letzte Leerzeichen und gibt den Text zurück
    }
    public static String letterToMorse(char letter) {
        for (int i = 0; i < abc.length; i++) {
            if (String.valueOf(abc[i]).equalsIgnoreCase(String.valueOf(letter))) {
                return morse[i];
            }
        }
        return null;
    }
    // Methode, die ein Morse-Code-Zeichen in den entsprechenden Buchstaben übersetzt
    public static Character morseToLetter(String morseCode) {
        for (int i = 0; i < morse.length; i++) {
            if (morse[i].equals(morseCode)) { // Vergleicht den Morse-Code mit dem aktuellen Array-Eintrag
                return abc[i]; // Gibt den entsprechenden Buchstaben zurück
            }
        }
        return null; // Gibt null zurück, wenn der Morse-Code nicht gefunden wird
    }
    public static String morseToWord(String morseword) {
        StringBuilder wordMorse = new StringBuilder();
        String[] morseLetters = morseword.split(" "); // Split by space to get each Morse letter

        for (String morseLetter : morseLetters) {
            // Überprüfen, ob der Morse-Code im Array vorhanden ist
            Character letter = morseToLetter(morseLetter); // Diese Methode gibt den entsprechenden Buchstaben zurück

            if (letter != null) {
                wordMorse.append(letter); // Füge den entsprechenden Buchstaben zur Wort-Konstruktion hinzu
            } else {
                wordMorse.append('?'); // Falls der Morse-Code ungültig ist, füge ein Fragezeichen hinzu
            }
        }

        return wordMorse.toString(); // Gib das gesamte Wort als String zurück
    }



    public static String wordToMorse(String word) {
        StringBuilder morseWord = new StringBuilder(); // Zum Speichern des Morse-Codes für das ganze Wort

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i); // Nimmt den aktuellen Buchstaben
            String morseCode = letterToMorse(letter); // Konvertiert den Buchstaben in Morse-Code

            if (morseCode != null) { // Falls ein gültiger Morse-Code existiert
                morseWord.append(morseCode).append(" "); // Fügt den Morse-Code und ein Leerzeichen hinzu
            } else {
                morseWord.append("? "); // Falls der Buchstabe nicht im Morse-Code verfügbar ist, fügt ein Fragezeichen hinzu
            }
        }

        return morseWord.toString().trim(); // Entfernt das letzte Leerzeichen und gibt das Ergebnis zurück
    }
    public static String sentenceToMorse(String sentence){
        String [] words = sentence.split(" ");
        StringBuilder morseCode = new StringBuilder();
        for (String word: words){
            morseCode.append(wordToMorse(word));
            morseCode.append("/");

        }

        return morseCode.toString();
    }
    public static String morseToSentence(String sentence) {
        StringBuilder morseSentence = new StringBuilder(); // Zum Speichern des gesamten Morse-Satzes
        String[] morsewords = sentence.split("/");
        // Gehe durch jedes Zeichen im Satz
        for (String morseword: morsewords) {
            morseSentence.append(morseToWord(morseword));
            morseSentence.append(" ");
        }
        // Gib den Morse-Satz als String zurück
        return morseSentence.toString().trim(); // Entfernt das letzte Leerzeichen
    }

    // Nach und vor den Slashes keine Leerzeichen machen
    // MorseLetter to AbcLetter schreiben
    public static void main(String[] args) {
        System.out.println("Alphabet: " + abc());
        System.out.println("Morse-Code: " + abcToMorse());
        System.out.println("morseToLetter: " + morseToLetter(".-"));
        System.out.println("wordToMorse: "+ wordToMorse("Hallo"));
        System.out.println("morseToWord: "+ morseToWord(".... .- .-.. .-.. ---"));
        System.out.println("sentenceToMorse: "+ sentenceToMorse("ich bin oli"));
        System.out.println("morseToSentence: "+ morseToSentence(".. -.-. ..../-... .. -./--- .-.. ../"));
    }
}