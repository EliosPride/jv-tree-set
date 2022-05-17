package core.basesyntax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeSet;

/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 *
 * <p>Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків.
 * Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку
 * про відсутність файлу.</p>
 *
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 *
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {
    private final static int MAX_LENGTH = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> charSet = new TreeSet<>();
        StringBuilder charBuilder = new StringBuilder();
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File doesn't exist.");
        }
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (fileInputStream.available() > 0) {
                char alphabetChar = (char) fileInputStream.read();
                if (Character.isLetter(alphabetChar)) {
                    charSet.add(Character.toLowerCase(alphabetChar));
                }
            }
            for (Character nextCharacter : charSet) {
                charBuilder.append(nextCharacter);
                if (charBuilder.length() == MAX_LENGTH) {
                    break;
                }
            }
            return charBuilder.toString();
        }
    }
}
