package helper;

import java.math.BigDecimal;

/**
 * 各種計算を行うヘルパークラス.
 */
public class CaluculateHelper {

	/**
	 * 外部からのインスタンスの生成を禁止する.
	 */
	private CaluculateHelper() {
	}

	/**
	 * 引数で与えられたBigDecimal型の値を任意の桁数で四捨五入する.
	 * @param value BigDecimal型の数値
	 * @param digit 四捨五入したい桁数
	 * @return 四捨五入した値
	 */
	public static BigDecimal round(BigDecimal value, int digit) {
		if(ValidateHelper.isLessThanZero(digit)) {
			throw new IllegalArgumentException("digitは0以上の値を入力してください。");
		}
		return value.setScale(digit, BigDecimal.ROUND_HALF_UP);
	}
}
