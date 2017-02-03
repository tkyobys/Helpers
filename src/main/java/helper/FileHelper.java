package helper;

import java.io.File;

/**
 * ファイルを取り扱うヘルパークラス.
 */
public class FileHelper {

    /**
     * 外部からのインスタンスの生成を禁止する.
     */
    private FileHelper() {
    }

    /** ファイル拡張子 */
    public enum FileExtension {
        // CSVファイルの拡張子
        CSV(".csv"),
        // TSVファイルの拡張子
        TSV(".tsv"),
        // PDFファイルの拡張子
        PDF(".pdf");

        private String fileExtension;

        FileExtension(String fileExtension) {
            this.fileExtension = fileExtension;
        }

        public String getValue() {
            return fileExtension;
        }
    }

    /**
     * ファイル名と拡張子を結合した文字列を生成する.
     *
     * @param fileName ファイル名
     * @param fileExtension 拡張子
     * @return ファイル名と拡張子を結合した文字列
     */
    public static String joinFileExtension(String fileName, FileExtension fileExtension) {

        if (ValidateHelper.isEmpty(fileName)) {
            throw new IllegalArgumentException("ファイル名を指定してください。");
        }

        if (ValidateHelper.isNull(fileExtension)) {
            throw new IllegalArgumentException("ファイル拡張子を指定してください。");
        }

        return fileName + fileExtension.getValue();
    }

    /**
     * 引数で渡されたファイルパス文字列に相当するファイルが存在するか検査する.
     *
     * @param filePath ファイルパス
     * @return true:ファイルが存在する false:ファイルが存在しない
     */
    public static boolean isExists(String filePath) {
        if (ValidateHelper.isEmpty(filePath)) {
            throw new IllegalArgumentException("ファイルパスを指定してください。");
        }
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * 引数で渡されたファイルパス文字列に相当するファイルを削除する.
     *
     * @param filePath ファイルパス
     * @return true：ファイルの削除に成功 false：ファイルの削除に失敗
     */
    public static boolean remove(String filePath) {
        if (ValidateHelper.isEmpty(filePath)) {
            throw new IllegalArgumentException("ファイルパスを指定してください。");
        }
        return new File(filePath).delete();
    }

}
