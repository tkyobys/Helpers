package helper;

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

}
