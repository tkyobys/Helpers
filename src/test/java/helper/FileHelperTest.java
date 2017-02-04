package helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

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

	@Test
	public void isExists_文字列_ファイルが存在する() {
		String filePath = "src/test/resources/helper/FileHelperTest/isExists_文字列.txt";
		assertTrue(FileHelper.isExists(filePath));
	}

	@Test
	public void isExists_文字列_ファイルが存在しない() {
		String filePath = "src/test/resources/helper/FileHelperTest/not_found.txt";
		assertFalse(FileHelper.isExists(filePath));
	}

	@Test(expected = IllegalArgumentException.class)
	public void isExists_文字列_ファイルパスがnullである() {
		FileHelper.isExists(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void isExists_文字列_ファイルパスが空文字である() {
		FileHelper.isExists(ConvertHelper.EMPTY);
	}

	@Test
	public void create_文字列_正常() throws IOException {
		String filePath = "output-test/java/helper/FileHelperTest/create_文字列.txt";
		try {
			assertTrue(FileHelper.create(filePath));
		} finally {
			FileHelper.remove(filePath);
		}
	}

	@Test(expected = IOException.class)
	public void create_文字列_フォルダが存在しない() throws IOException {
		String filePath = "output-test/not-found/create_文字列.txt";
		FileHelper.create(filePath);
	}

	@Test(expected = FileAlreadyExistsException.class)
	public void create_文字列_ファイルが存在する() throws IOException {
		String filePath = "output-test/java/helper/FileHelperTest/create_文字列.txt";
		try {
			FileHelper.create(filePath);
			assertFalse(FileHelper.create(filePath));
		} finally {
			FileHelper.remove(filePath);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_文字列_ファイルパスがnullである() throws IOException {
		FileHelper.create(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_文字列_ファイルパスが空白である() throws IOException {
		FileHelper.create(ConvertHelper.EMPTY);
	}

	@Test
	public void remove_文字列_ファイルが存在する() {
		String filePath = "output-test/java/helper/FileHelperTest/remove.txt";
		try {
			new File(filePath).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			fail("テストの準備に失敗しました。");
		}
		assertTrue(FileHelper.remove(filePath));
	}

	@Test
	public void remove_文字列_ファイルが存在しない() {
		String filePath = "output-test/java/helper/FileHelperTest/not-found.txt";
		assertFalse(FileHelper.remove(filePath));
	}

	@Test(expected = IllegalArgumentException.class)
	public void remove_文字列_ファイルパスがnullである() {
		FileHelper.remove(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void remove_文字列_ファイルパスが空白である() {
		FileHelper.remove(ConvertHelper.EMPTY);
	}

}
