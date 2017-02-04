package helper;

import java.io.File;
import java.io.IOException;

import org.zeroturnaround.zip.ZipUtil;

/**
 * zipファイルを取り扱うヘルパークラス.
 */
public class ZipHelper {

	/**
	 * 外部からのインスタンスの生成を禁止する.
	 */
	private ZipHelper() {
	}

	/**
	 * フォルダをzip圧縮する
	 * @param dirPath フォルダのパス
	 * @param zipFilePath zipファイルの出力先
	 * @throws IOException
	 */
	public static void compress(String dirPath, String zipFilePath) throws IOException {
		if(ValidateHelper.isEmpty(dirPath)) {
			throw new IllegalArgumentException("フォルダを指定してください。");
		}

		if(ValidateHelper.isEmpty(zipFilePath)) {
			throw new IllegalArgumentException("zipファイルを指定してください。");
		}
		ZipUtil.pack(new File(dirPath), new File(zipFilePath));
	}
}
