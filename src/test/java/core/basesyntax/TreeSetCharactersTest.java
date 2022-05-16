package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TreeSetCharactersTest {
    private static final String FIVE_CHARACTERS = "abdhi";
    private static final String FOUR_CHARACTERS = "ejlo";
    private static final String WITHOUT_CHARACTERS = "";

    @Test
    public void getFiveUniqueCharacters() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file1.txt");
        Assert.assertEquals("Test failed with result: " + actualResult,
                FIVE_CHARACTERS, actualResult);
    }

    @Test
    public void getLessThenFiveUniqueCharacters() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file2.txt");
        Assert.assertEquals("Test failed with result: " + actualResult,
                FOUR_CHARACTERS, actualResult);
    }

    @Test
    public void getEmptyUniqueCharacters() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file3.txt");
        Assert.assertEquals("Test failed with result: " + actualResult,
                WITHOUT_CHARACTERS, actualResult);
    }

    @Test
    public void getEmptyUniqueCharactersFromNumbers() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file4.txt");
        Assert.assertEquals("Test failed with result: " + actualResult,
                WITHOUT_CHARACTERS, actualResult);
    }

    @Test
    public void getExceptionWhenFileNotExist() {
        TreeSetCharacters characters = new TreeSetCharacters();
        try {
            characters.getUniqueCharacters("file");
        } catch (FileNotFoundException e) {
            return;
        } catch (IOException e) {
            Assert.fail("FileNotFoundException should be thrown");
        }
        Assert.fail("FileNotFoundException should be thrown");
    }
}
