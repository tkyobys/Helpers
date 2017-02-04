package helper;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.zeroturnaround.zip.ZipException;

/**
 * {@link ZipHelper}のテストクラス.
 */
public class ZipHelperTest {

	@Test
	public void compressDir_正常() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest";
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressDir(dirPath, zipFilePath);
		assertTrue(FileHelper.isExists(zipFilePath));
		FileHelper.remove(zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compressDir_ファイルパスがnullである() throws IOException {
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressDir(null, zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compressDir_ファイルパスが空白である() throws IOException {
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressDir(ConvertHelper.EMPTY, zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compressDir_zipファイルパスがnullである() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest";
		ZipHelper.compressDir(dirPath, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compressDir_zipファイルパスが空白である() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest";
		ZipHelper.compressDir(dirPath, ConvertHelper.EMPTY);
	}

	@Test(expected = ZipException.class)
	public void compressDir_フォルダが存在しない() throws IOException {
		String dirPath = "src/test/resources/helper/not-found";
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressDir(dirPath, zipFilePath);
	}

	@Test(expected = ZipException.class)
	public void compressDir_zipファイルの出力先が存在しない() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest";
		String zipFilePath = "output-test/java/helper/not-found/test.zip";
		ZipHelper.compressDir(dirPath, zipFilePath);
	}

	@Test(expected = ZipException.class)
	public void compressDir_ファイルを指定() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest/test.txt";
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressDir(dirPath, zipFilePath);
	}

	@Test
	public void compressFile_正常() {
		String filePath = "src/test/resources/helper/ZipHelperTest/test.txt";
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressFile(filePath, zipFilePath);
		assertTrue(FileHelper.isExists(zipFilePath));
		FileHelper.remove(zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compressFile_ファイルパスがnullである() {
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressFile(null, zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compressFile_ファイルパスが空白である() {
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressFile(ConvertHelper.EMPTY, zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compressFile_zipファイルパスがnullである() {
		String filePath = "src/test/resources/helper/ZipHelperTest/test.txt";
		ZipHelper.compressFile(filePath, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compressFile_zipファイルパスが空白である() {
		String filePath = "src/test/resources/helper/ZipHelperTest/test.txt";
		ZipHelper.compressFile(filePath, ConvertHelper.EMPTY);
	}

	@Test(expected = ZipException.class)
	public void compressFile_ファイルが存在しない() {
		String filePath = "src/test/resources/helper/ZipHelperTest/not-found.txt";
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compressFile(filePath, zipFilePath);
	}

	@Test(expected = ZipException.class)
	public void compressFile_zipファイルの出力先が存在しない() {
		String filePath = "src/test/resources/helper/ZipHelperTest/test.txt";
		String zipFilePath = "output-test/java/helper/not-found/test.zip";
		ZipHelper.compressFile(filePath, zipFilePath);
	}
}
