/**
 * Copyright &copy; 2012-2015 <a href="https://www.allinfnt.com">allinfnt.com</a> All rights reserved.
 */
package com.allinfnt.idc.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.allinfnt.idc.common.persistence.DataEntity;

/**
 * 主子表生成Entity
 * @author allinfnt
 * @version 2015-01-16
 */
public class TestDataChild extends DataEntity<TestDataChild> {
	
	private static final long serialVersionUID = 1L;
	private TestDataMain testDataMain;		// 业务主表 父类
	private String name;		// 名称
	
	public TestDataChild() {
		super();
	}

	public TestDataChild(String id){
		super(id);
	}

	public TestDataChild(TestDataMain testDataMain){
		this.testDataMain = testDataMain;
	}

	@Length(min=0, max=64, message="业务主表长度必须介于 0 和 64 之间")
	public TestDataMain getTestDataMain() {
		return testDataMain;
	}

	public void setTestDataMain(TestDataMain testDataMain) {
		this.testDataMain = testDataMain;
	}
	
	@Length(min=0, max=100, message="名称长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}