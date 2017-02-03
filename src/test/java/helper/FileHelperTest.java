package helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * {@link FileHelper}のテストクラス.
 */
public class FileHelperTest {

    @Test
    public void joinFileExtension_CSV_正常() {
        String fileName = "ファイル";
        String actual = FileHelper.joinFileExtension(fileName, FileHelper.FileExtension.CSV);
        assertThat(actual, is(fileName + ".csv"));
    }

    @Test
    public void joinFileExtension_TSV_正常() {
        String fileName = "ファイル";
        String actual = FileHelper.joinFileExtension(fileName, FileHelper.FileExtension.TSV);
        assertThat(actual, is(fileName + ".tsv"));
    }

    @Test
    public void joinFileExtension_PDF_正常() {
        String fileName = "ファイル";
        String actual = FileHelper.joinFileExtension(fileName, FileHelper.FileExtension.PDF);
        assertThat(actual, is(fileName + ".pdf"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void joinFileExtension_ファイル名がnull() {
        String fileName = null;
        FileHelper.joinFileExtension(fileName, FileHelper.FileExtension.TSV);
    }

    @Test(expected = IllegalArgumentException.class)
    public void joinFileExtension_ファイル名が空文字() {
        String fileName = ConvertHelper.EMPTY;
        FileHelper.joinFileExtension(fileName, FileHelper.FileExtension.TSV);
    }

    @Test(expected = IllegalArgumentException.class)
    public void joinFileExtension_ファイル拡張子がnull() {
        String fileName = "ファイル";
        FileHelper.joinFileExtension(fileName, null);
    }

}
