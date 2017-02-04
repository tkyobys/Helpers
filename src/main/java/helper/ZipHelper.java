package helper;

import java.io.File;

import org.zeroturnaround.zip.ZipUtil;

/**
 * zipファイルを取り扱うヘルパークラス.
 * zipファイルの取り扱いにはzt-zipを利用している。<br>
 * 参考：https://github.com/zeroturnaround/zt-zip
 */
public class ZipHelper {

	/**
	 * 外部からのインスタンスの生成を禁止する.
	 */
	private ZipHelper() {
	}

	/**
	 * フォルダをzip圧縮する.
	 * @param dirPath 圧縮するフォルダのパス
	 * @param zipFilePath zipファイルの出力先
	 */
	public static void compressDir(String dirPath, String zipFilePath) {
		if(ValidateHelper.isEmpty(dirPath)) {
			throw new IllegalArgumentException("フォルダを指定してください。");
		}
		if(ValidateHelper.isEmpty(zipFilePath)) {
			throw new IllegalArgumentException("zipファイルを指定してください。");
		}
		ZipUtil.pack(new File(dirPath), new File(zipFilePath));
	}

	/**
	 * ファイルをzip圧縮する.
	 * @param filePath 圧縮するファイルのパス
	 * @param zipFilePath zipファイルの出力先
	 */
	public static void compressFile(String filePath, String zipFilePath) {
		if(ValidateHelper.isEmpty(filePath)) {
			throw new IllegalArgumentException("ファイルを指定してください。");
		}
		if(ValidateHelper.isEmpty(zipFilePath)) {
			throw new IllegalArgumentException("zipファイルを指定してください。");
		}
		ZipUtil.packEntry(new File(filePath), new File(zipFilePath));
	}

}
