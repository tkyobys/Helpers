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
}
