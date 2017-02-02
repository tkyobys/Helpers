package helper;

import static org.junit.Assert.*;

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
}
