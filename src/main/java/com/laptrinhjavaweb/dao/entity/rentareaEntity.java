package com.laptrinhjavaweb.dao.entity;

public class rentareaEntity extends BaseEntity {
	private Integer value;
	private Long buildingid;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Long getBuildingid() {
		return buildingid;
	}
	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
	}

}
