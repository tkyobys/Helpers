package helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import helper.bean.convert.json.ToJsonBean1;
import helper.bean.convert.json.ToJsonBean2;

/**
 * {@link ConvertHelper}のテストクラス.
 */
public class ConvertHelperTest {

	@Test
	public void testToDate_正常1() {
		try {
			String text = "20170101";
			LocalDate expected = LocalDate.of(2017, 1, 1);
			LocalDate actual = ConvertHelper.toDate(text, ConvertHelper.PATTERN_YYYYMMDD);
			assertThat(actual, is(expected));
		} catch(DateTimeParseException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testToDate_正常2() {
		try {
			String text = "20170101 01:01:01";
			LocalDate expected = LocalDate.of(2017, 1, 1);
			LocalDate actual = ConvertHelper.toDate(text, ConvertHelper.PATTERN_YYYYMMDDHHMMSS);
			assertThat(actual, is(expected));
		} catch(DateTimeParseException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test(expected = DateTimeParseException.class)
	public void testToDate_存在しない日付() {
		String text = "20170132";
		ConvertHelper.toDate(text, ConvertHelper.PATTERN_YYYYMMDD);
	}

	@Test(expected = DateTimeParseException.class)
	public void testToDate_パターン不一致() {
		String text = "20170131 12:0:00";
		ConvertHelper.toDate(text, ConvertHelper.PATTERN_YYYYMMDD);
	}

	@Test
	public void toEmptyIfNull_null() {
		String actual = ConvertHelper.toEmptyIfNull(null);
		assertThat(actual, is(ConvertHelper.EMPTY));
	}

	@Test
	public void toEmptyIfNull_空文字() {
		String actual = ConvertHelper.toEmptyIfNull(ConvertHelper.EMPTY);
		assertThat(actual, is(ConvertHelper.EMPTY));
	}

	@Test
	public void toEmptyIfNull_値あり() {
		String s = "a";
		String actual = ConvertHelper.toEmptyIfNull(s);
		assertThat(actual, is(s));
	}

	@Test
	public void toJson_正常() throws JsonProcessingException {
		ToJsonBean1 obj = new ToJsonBean1();
		obj.setStringValue("a");
		obj.setIntegerValue(1);
		obj.setIntValue(2);
		obj.setBooleanValue(Boolean.FALSE);
		obj.setPrimitiveBooleanValue(true);
		obj.setLocalDateValue(LocalDate.of(2017, 1, 2));

		List<String> listValue = new ArrayList<>();
		listValue.add("x");
		listValue.add("y");
		listValue.add("z");
		obj.setListValue(listValue);

		String expected = "{\"stringValue\":\"a\",\"integerValue\":1,\"intValue\":2,\"booleanValue\":false,\"primitiveBooleanValue\":true,\"localDateValue\":\"2017/01/02\",\"listValue\":[\"x\",\"y\",\"z\"]}";
		assertThat(ConvertHelper.toJson(obj), is(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void toJson_オブジェクトがnull() throws JsonProcessingException {
		ConvertHelper.toJson(null);
	}

	@Test(expected = JsonProcessingException.class)
	public void toJson_オブジェクトにフィールドがない() throws JsonProcessingException {
		ToJsonBean2 obj = new ToJsonBean2();
		String expected = ConvertHelper.EMPTY_JSON;
		assertThat(ConvertHelper.toJson(obj), is(expected));
	}

}
