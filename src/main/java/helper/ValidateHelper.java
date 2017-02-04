package helper;

import java.util.Collection;
import java.util.regex.Pattern;

/**
 * 各種検査処理を行うヘルパークラス.
 */
public class ValidateHelper {

	/**
	 * 外部からのインスタンスの生成を禁止する.
	 */
	private ValidateHelper() {
	}

	/** パターン 数字のみ */
	public static final String PATTERN_NUMBER = "[0-9]";
	/** パターン 電話番号 */
	public static final String PATTERN_TEL_NO = "[0-9-]+";

	/**
	 * 引数のオブジェクトがnullか検査する.
	 *
	 * @param obj オブジェクト
	 * @return true:objがnull false:objがnullではない
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * 引数のStringオブジェクトがnullもしくは空文字か検査する.
	 *
	 * @param s Stringオブジェクト
	 * @return true:nullもしくは空文字 false:値がある
	 */
	public static boolean isEmpty(String s) {
		return isNull(s) || s.isEmpty();
	}

	/**
	 * 引数のコレクションがnullもしくは空か検査する.
	 *
	 * @param c コレクション
	 * @return true:nullもしくは空 false:値がある
	 */
	public static boolean isEmpty(Collection<?> c) {
		return isNull(c) || c.isEmpty();
	}

	/**
	 * 指定のパターンに一致する文字列かどうか検査する.
	 *
	 * @param value 検証対象の文字列
	 * @param pattern 正規表現文字列
	 * @return true:入力値がパターンと一致する false:入力値がパターンと一致しない
	 */
	public static boolean isMatch(String value, String pattern) {

		if (isNull(pattern)) {
			throw new IllegalArgumentException("パターンを指定してください。");
		}

		if (isNull(value)) {
			return false;
		}
		return Pattern.compile(pattern).matcher(value).matches();
	}

	/**
	 * 電話番号のパターンに一致する文字列かどうか検査する.
	 *
	 * @param telNo 電話番号
	 * @return true:電話番号のパターンと一致する false:電話番号ノパターンと一致しない
	 */
	public static boolean isTelNo(String telNo) {
		return isMatch(telNo, PATTERN_TEL_NO);

	}

}
