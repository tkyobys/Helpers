package helper.bean.convert.json;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import helper.ConvertHelper;
import helper.ConvertHelperTest;

/**
 * {@link ConvertHelperTest}で利用するBean.
 * JSONへの変換処理で利用する。
 */
public class ToJsonBean1 {

	/** String型. */
	private String stringValue;
	/** Integer型. */
	private Integer integerValue;
	/** int型. */
	private int intValue;
	/** Boolean型. */
	private Boolean booleanValue;
	/** boolean型. */
	private boolean primitiveBooleanValue;
	/** LocalDate型. */
	@JsonFormat(pattern = ConvertHelper.PATTERN_YYYYMMDD_DIVIDE_SLASH)
	private LocalDate localDateValue;
	/** List型. */
	private List<String> listValue;

	public String getStringValue() {
		return this.stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Integer getIntegerValue() {
		return this.integerValue;
	}

	public void setIntegerValue(Integer integerValue) {
		this.integerValue = integerValue;
	}

	public int getIntValue() {
		return this.intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public Boolean getBooleanValue() {
		return this.booleanValue;
	}

	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public boolean isPrimitiveBooleanValue() {
		return this.primitiveBooleanValue;
	}

	public void setPrimitiveBooleanValue(boolean primitiveBooleanValue) {
		this.primitiveBooleanValue = primitiveBooleanValue;
	}

	public LocalDate getLocalDateValue() {
		return this.localDateValue;
	}

	public void setLocalDateValue(LocalDate localDateValue) {
		this.localDateValue = localDateValue;
	}

	public List<String> getListValue() {
		return this.listValue;
	}

	public void setListValue(List<String> listValue) {
		this.listValue = listValue;
	}

}
