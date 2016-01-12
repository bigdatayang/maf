/**
 * Copyright &copy; 2012-2015 <a href="https://www.allinfnt.com">allinfnt.com</a> All rights reserved.
 */
package com.allinfnt.idc.modules.gen.dao;

import com.allinfnt.idc.common.persistence.CrudDao;
import com.allinfnt.idc.common.persistence.annotation.MyBatisDao;
import com.allinfnt.idc.modules.gen.entity.GenTable;

/**
 * 业务表DAO接口
 * @author allinfnt
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTableDao extends CrudDao<GenTable> {
	
}
