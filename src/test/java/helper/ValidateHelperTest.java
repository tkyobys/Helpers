package helper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * {@link ValidateHelper}のテストクラス.
 */
public class ValidateHelperTest {

	@Test
	public void isNull_null() {
		assertTrue(ValidateHelper.isNull(null));
	}

	@Test
	public void isNull_nullではない() {
		String obj = "";
		assertFalse(ValidateHelper.isNull(obj));
	}

	@Test
	public void isEmpty_文字列_null() {
		String s = null;
		assertTrue(ValidateHelper.isEmpty(s));
	}

	@Test
	public void isEmpty_文字列_空文字() {
		String s = "";
		assertTrue(ValidateHelper.isEmpty(s));
	}

	@Test
	public void isEmpty_文字列_値あり() {
		String s = "a";
		assertFalse(ValidateHelper.isEmpty(s));
	}

	@Test
	public void isEmpty_コレクション_null() {
		List<String> c = null;
		assertTrue(ValidateHelper.isEmpty(c));
	}

	@Test
	public void isEmpty_コレクション_空() {
		List<String> c = new ArrayList<>();
		assertTrue(ValidateHelper.isEmpty(c));
	}

	@Test
	public void isEmpty_コレクション_要素あり() {
		List<String> c = new ArrayList<>();
		c.add("");
		assertFalse(ValidateHelper.isEmpty(c));
	}

	@Test
	public void isMatch_一致する() {
		String value = "0";
		assertTrue(ValidateHelper.isMatch(value, ValidateHelper.PATTERN_NUMBER));
	}

	@Test
	public void isMatch_一致しない() {
		String value = "あ";
		assertFalse(ValidateHelper.isMatch(value, ValidateHelper.PATTERN_NUMBER));
	}

	@Test
	public void isMatch_文字列がnullである() {
		assertFalse(ValidateHelper.isMatch(null, ValidateHelper.PATTERN_NUMBER));
	}

	@Test
	public void isMatch_文字列が空白である() {
		String value = "";
		assertFalse(ValidateHelper.isMatch(value, ValidateHelper.PATTERN_NUMBER));
	}

	@Test(expected = IllegalArgumentException.class)
	public void isMatch_パターンがnullである() {
		String value = "0";
		ValidateHelper.isMatch(value, null);
	}

	@Test
	public void isMatch_パターンが空白である() {
		String value = "0";
		assertFalse(ValidateHelper.isMatch(value, ConvertHelper.EMPTY));
	}

	@Test
	public void isMatch_パターンが空白である_文字列が空白である() {
		String value = "";
		assertTrue(ValidateHelper.isMatch(value, ConvertHelper.EMPTY));
	}

	@Test
	public void isMatchTelNo_一致する() {
		String telNo = "012-3456-7890";
		assertTrue(ValidateHelper.isTelNo(telNo));
	}

	@Test
	public void isMatchTelNo_一致しない_アンダースコア() {
		String telNo = "012_3456_7890";
		assertFalse(ValidateHelper.isTelNo(telNo));
	}

	@Test
	public void isMatchTelNo_一致しない_アルファベット() {
		String telNo = "abc-defg_hijk";
		assertFalse(ValidateHelper.isTelNo(telNo));
	}

	public void isMatchTelNo_値がnull() {
		assertFalse(ValidateHelper.isTelNo(null));
	}

	@Test
	public void isMatchTelNo_値が空白() {
		ValidateHelper.isTelNo(ConvertHelper.EMPTY);
	}

}
