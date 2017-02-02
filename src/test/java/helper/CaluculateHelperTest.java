package helper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * {@link CaluculateHelper}のテストクラス.
 */
public class CaluculateHelperTest {

	@Test
	public void round_整数() {
		BigDecimal bd = BigDecimal.valueOf(0.845);
		BigDecimal expected = BigDecimal.ONE;
		BigDecimal actual = CaluculateHelper.round(bd, 0);
		assertThat(actual, comparesEqualTo(expected));
	}

	@Test
	public void round_小数点下1桁() {
		BigDecimal bd = BigDecimal.valueOf(0.845);
		BigDecimal expected = BigDecimal.valueOf(0.8);
		BigDecimal actual = CaluculateHelper.round(bd, 1);
		assertThat(actual, comparesEqualTo(expected));
	}

	@Test
	public void round_四捨() {
		BigDecimal bd = BigDecimal.valueOf(0.4);
		BigDecimal expected = BigDecimal.ZERO;
		BigDecimal actual = CaluculateHelper.round(bd, 0);
		assertThat(actual, comparesEqualTo(expected));
	}

	@Test
	public void round_五入() {
		BigDecimal bd = BigDecimal.valueOf(0.5);
		BigDecimal expected = BigDecimal.ONE;
		BigDecimal actual = CaluculateHelper.round(bd, 0);
		assertThat(actual, comparesEqualTo(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void round_マイナス値() {
		BigDecimal bd = BigDecimal.valueOf(0.5);
		CaluculateHelper.round(bd, -1);
	}

}
