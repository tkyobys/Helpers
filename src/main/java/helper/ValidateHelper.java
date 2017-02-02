package helper;

import java.util.Collection;

/**
 * 各種検査処理を行うヘルパークラス.
 */
public class ValidateHelper {

	/**
	 * 外部からのインスタンスの生成を禁止する.
	 */
	private ValidateHelper() {
	}

	/**
	 * 引数のオブジェクトがnullか検査する.
	 * @param obj オブジェクト
	 * @return true:objがnull false:objがnullではない
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * 引数のStringオブジェクトがnullもしくは空文字か検査する.
	 * @param s Stringオブジェクト
	 * @return true:nullもしくは空文字 false:値がある
	 */
	public static boolean isEmpty(String s) {
		return isNull(s) || s.isEmpty();
	}

	/**
	 * 引数のコレクションがnullもしくは空か検査する.
	 * @param c コレクション
	 * @return true:nullもしくは空 false:値がある
	 */
	public static boolean isEmpty(Collection<?> c) {
		return isNull(c) || c.isEmpty();
	}

}
