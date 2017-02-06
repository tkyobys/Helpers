package helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * 各種変換処理を行うヘルパークラス.
 */
public class ConvertHelper {

	/**
	 * 外部からのインスタンスの生成を禁止する.
	 */
	private ConvertHelper() {
	}

	/** 空白文字. */
	public static final String EMPTY = "";
	/** 空白JSON. */
	public static final String EMPTY_JSON = "{}";
	/** 日付文字列のパターン yyyyMMdd 例:20170130. */
	public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
	/** 日付文字列のパターン yyyyMMdd 例:2017/01/30. */
	public static final String PATTERN_YYYYMMDD_DIVIDE_SLASH = "yyyy/MM/dd";
	/** 日付文字列のパターン yyyyMMdd HH:mm:SS 例:20170130 01:05:09. */
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
	 * 引数で与えられた文字列がnullの場合は空白文字列に変換して返却する.
	 * @param value 文字列
	 * @return 文字列
	 */
	public static String toEmptyIfNull(String value) {
		return Objects.toString(value, EMPTY);
	}

	/**
	 * オブジェクトをjsonに変換する.
	 * @param obj 変換対象のオブジェクト
	 * @return json json形式の文字列
	 * @throws JsonProcessingException
	 */
	public static String toJson(Object obj) throws JsonProcessingException {
		if(ValidateHelper.isNull(obj)) {
			throw new IllegalArgumentException("オブジェクトを指定してください。");
		}

		// LocalDate型の値のシリアライズを明示的に指定する。
		// これによりBeanのフィールドにアノテーションを付与することでフォーマットを任意の形式にすることも可能である。
		// 参考：http://stackoverflow.com/questions/28802544/java-8-localdate-jackson-format
		SimpleModule module = new SimpleModule();
		module.addSerializer(new LocalDateSerializer(DateTimeFormatter.ofPattern(PATTERN_YYYYMMDD)));

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(module);
		return objectMapper.writeValueAsString(obj);
	}

}
