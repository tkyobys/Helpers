package helper;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * {@link PdfHelper}のテストクラス.
 */
public class PdfHelperTest {

	@Test(expected = IllegalArgumentException.class)
	public void joinPdf_PDFファイルリスト_null() {
		List<File> pdfFileList = null;
		String outputPath = "Unused";
		try {
			PdfHelper.joinPdf(pdfFileList, outputPath);
		} catch(IOException e) {
			e.printStackTrace();
			fail("Exceptionをcatchしました。");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void joinPdf_PDFファイルリスト_空() {
		List<File> pdfFileList = new ArrayList<>();
		String outputPath = "Unused";
		try {
			PdfHelper.joinPdf(pdfFileList, outputPath);
		} catch(IOException e) {
			e.printStackTrace();
			fail("Exceptionをcatchしました。");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void joinPdf_出力先_null() {
		List<File> pdfFileList = new ArrayList<>();
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf1.pdf"));
		String outputPath = null;
		try {
			PdfHelper.joinPdf(pdfFileList, outputPath);
		} catch(IOException e) {
			e.printStackTrace();
			fail("Exceptionをcatchしました。");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void joinPdf_出力先_空() {
		List<File> pdfFileList = new ArrayList<>();
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf1.pdf"));
		String outputPath = ConvertHelper.EMPTY;
		try {
			PdfHelper.joinPdf(pdfFileList, outputPath);
		} catch(IOException e) {
			e.printStackTrace();
			fail("Exceptionをcatchしました。");
		}
	}

	@Test(expected = IOException.class)
	public void joinPdf_PDFファイルが存在しない() throws IOException {
		List<File> pdfFileList = new ArrayList<>();
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/not_found.pdf"));
		String outputPath = "outpu-test/java/helper/PdfHelperTest/joinedPdf.pdf";
		PdfHelper.joinPdf(pdfFileList, outputPath);
	}

	@Test(expected = IOException.class)
	public void joinPdf_出力先のフォルダが存在しない() throws IOException {
		List<File> pdfFileList = new ArrayList<>();
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf1.pdf"));
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf2.pdf"));
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf3.pdf"));
		String outputPath = "output-test/not_found/joinedPdf_出力先のフォルダが存在しない.pdf";
		PdfHelper.joinPdf(pdfFileList, outputPath);
	}

	@Test(expected = IllegalArgumentException.class)
	public void joinPdf_PDFファイルリストの一部がnull() throws IOException {
		List<File> pdfFileList = new ArrayList<>();
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf1.pdf"));
		pdfFileList.add(null);
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf3.pdf"));
		String outputPath = "output-test/java/helper/PdfHelperTest/joinedPdf_正常.pdf";
		PdfHelper.joinPdf(pdfFileList, outputPath);
	}

	@Test(expected = IOException.class)
	public void joinPdf_PDFファイルリストの一部のパスが不正() throws IOException {
		List<File> pdfFileList = new ArrayList<>();
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf1.pdf"));
		pdfFileList.add(new File(""));
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf3.pdf"));
		String outputPath = "output-test/java/helper/PdfHelperTest/joinedPdf_正常.pdf";
		PdfHelper.joinPdf(pdfFileList, outputPath);
	}

	@Test
	public void joinPdf_正常() {
		List<File> pdfFileList = new ArrayList<>();
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf1.pdf"));
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf2.pdf"));
		pdfFileList.add(new File("src/test/resources/helper/PdfHelperTest/pdf3.pdf"));
		String outputPath = "output-test/java/helper/PdfHelperTest/joinedPdf_正常.pdf";
		try {
			PdfHelper.joinPdf(pdfFileList, outputPath);
			assertTrue(FileHelper.isExists(outputPath));
			FileHelper.remove(outputPath);
		} catch(IOException e) {
			e.printStackTrace();
			fail("Exceptionをcatchしました。");
		}
	}
}
