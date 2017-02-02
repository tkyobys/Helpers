package helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 各種変換処理を行うヘルパークラス.
 */
public class ConvertHelper {

	/**
	 * 外部からのインスタンスの生成を禁止する.
	 */
	private ConvertHelper() {
	}

	/** 空白文字 */
	public static final String EMPTY = "";
	/** 日付文字列のパターン yyyyMMdd 例:20170130 */
	public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
	/** 日付文字列のパターン yyyyMMdd HH:mm:SS 例:20170130 01:05:09*/
	public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMdd HH:mm:SS";

	/**
	 * 日付文字列を{@link LocalDate}型に変換する.
	 * @param text 変換対象の日付文字列
	 * @param pattern 変換対象の日付文字列のパターン
	 * @return 変換後の{@link Date}型オブジェクト
	 */
	public static LocalDate toDate(String text, String pattern) {
		return LocalDate.parse(text, DateTimeFormatter.ofPattern(pattern));
	}

	/**
	 * 引数で与えられた文字列がnullの場合は空白文字列に変換して返却する。
	 * @param value 文字列
	 * @return 文字列
	 */
	public static String toEmptyIfNull(String value) {
		return ValidateHelper.isNull(value) ? EMPTY : value;
	}

}
