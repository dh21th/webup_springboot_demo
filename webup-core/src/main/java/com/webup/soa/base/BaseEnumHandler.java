package com.webup.soa.base;

import com.webup.soa.utils.BaseEnumUtil;
import com.webup.soa.web.GenericsUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author ethan
 *
 * @param <E> 枚举具体对象
 * @param <K> 枚举数据库保存值
 */
@SuppressWarnings("unchecked")
public class BaseEnumHandler<E extends Enum<E>& BaseEnum<K>, K> extends BaseTypeHandler<E> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		if (jdbcType == null) {
			ps.setObject(i, parameter.getId());
		} else {
			ps.setObject(i, parameter.getId(), jdbcType.TYPE_CODE);
		}
	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		K index = (K)rs.getObject(columnName);
		return valueToEnum(index);

	}

	
	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		K index = (K)rs.getObject(columnIndex);
		return valueToEnum(index);

	}

	
	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		K index = (K)cs.getObject(columnIndex);
		return valueToEnum(index);
	}
	
	private E valueToEnum(K index) {
		
		Class<E> clazz = GenericsUtils.getSuperClassGenricType(this.getClass());
		//Class<K> indexClazz = GenericsUtils.getSuperClassGenricType(this.getClass(), 1);
		if (index == null)
			return null;
		E e = BaseEnumUtil.indexOf(clazz, (K) index);;
		/*if (indexClazz.equals(String.class)) {
			e = BaseEnumUtils.indexOf(clazz, (K) index);
		} else if (indexClazz.equals(Integer.class)) {

			e = BaseEnumUtils.indexOf(clazz, Integer.valueOf(index));
		} else {
			throw new ApplicationException("enum index type is not correct");
		}*/

		return e;
	}

}
