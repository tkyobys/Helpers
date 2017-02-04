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
	public void compress_正常() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest";
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compress(dirPath, zipFilePath);
		assertTrue(FileHelper.isExists(zipFilePath));
		FileHelper.remove(zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compress_ファイルパスがnullである() throws IOException {
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compress(null, zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compress_ファイルパスが空白である() throws IOException {
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compress(ConvertHelper.EMPTY, zipFilePath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compress_zipファイルパスがnullである() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest";
		ZipHelper.compress(dirPath, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void compress_zipファイルパスが空白である() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest";
		ZipHelper.compress(dirPath, ConvertHelper.EMPTY);
	}

	@Test(expected = ZipException.class)
	public void compress_フォルダが存在しない() throws IOException {
		String dirPath = "src/test/resources/helper/not-found";
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compress(dirPath, zipFilePath);
	}

	@Test(expected = ZipException.class)
	public void compress_zipファイルの出力先が存在しない() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest";
		String zipFilePath = "output-test/java/helper/not-found/test.zip";
		ZipHelper.compress(dirPath, zipFilePath);
	}

	@Test(expected = ZipException.class)
	public void compress_ファイルを指定() throws IOException {
		String dirPath = "src/test/resources/helper/ZipHelperTest/test.txt";
		String zipFilePath = "output-test/java/helper/ZipHelperTest/test.zip";
		ZipHelper.compress(dirPath, zipFilePath);
	}

}
