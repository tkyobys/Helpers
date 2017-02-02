package helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.junit.Test;

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
		} catch (DateTimeParseException e) {
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
		} catch (DateTimeParseException e) {
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

}
