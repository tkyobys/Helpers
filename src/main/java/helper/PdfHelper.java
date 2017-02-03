package helper;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 * PDFファイルを取り扱うヘルパークラス.
 */
public class PdfHelper {

    /**
     * 外部からのインスタンスの生成を禁止する.
     */
    private PdfHelper() {
    }

    /**
     * 引数で渡されたPDFファイルのリストを結合して1つのPDFにする.
     *
     * @param pdfFileList PDFファイルリスト
     * @param outputPath 出力先
     * @return 結合済みのPDFファイル
     * @throws IOException
     */
    public static File joinPdf(List<File> pdfFileList, String outputPath) throws IOException {

        if (ValidateHelper.isEmpty(pdfFileList)) {
            throw new IllegalArgumentException("結合対象のPDFファイルリストが不正です");
        }

        if (pdfFileList.stream().anyMatch(pdfFile -> ValidateHelper.isNull(pdfFile))) {
            throw new IllegalArgumentException("結合対象のPDFファイルリストにnullが含まれています");
        }

        if (ValidateHelper.isEmpty(outputPath)) {
            throw new IllegalArgumentException("ファイルの出力先が不正です。(" + outputPath + ")");
        }

        // 事前にマージ先のファイルを作成する。
        File joinedPdf = new File(outputPath);
        joinedPdf.createNewFile();

        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        for (File file : pdfFileList) {
            pdfMerger.addSource(file);
        }

        pdfMerger.setDestinationFileName(outputPath);
        pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        return joinedPdf;

    }

}
