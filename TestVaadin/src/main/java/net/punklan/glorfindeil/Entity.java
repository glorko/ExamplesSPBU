package net.punklan.glorfindeil;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Aleksandr_Kichev on 20-Mar-17.
 */
public class Entity {
	private String field1;

	public Entity(String field1, LocalDateTime field2, Integer field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public LocalDateTime getField2() {
		return field2;
	}

	public void setField2(LocalDateTime field2) {
		this.field2 = field2;
	}

	public Integer getField3() {
		return field3;
	}

	public void setField3(Integer field3) {
		this.field3 = field3;
	}

	private LocalDateTime field2;
	private Integer field3;

}
