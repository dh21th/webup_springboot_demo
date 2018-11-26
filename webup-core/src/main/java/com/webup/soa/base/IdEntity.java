package com.webup.soa.base;

import java.io.Serializable;

/**
 * 统一定义id的entity基类.
 * @author cgb
 */

public abstract class IdEntity<K> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4484292372543050196L;
	
	protected K id;
	protected IdEntity() {
	}

	protected IdEntity(K id) {
		this.id = id;
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}else if (obj == null || getClass() != obj.getClass()){
			return false;
		}
		IdEntity other = (IdEntity) obj;
		return id == null && other.id == null || id != null && id.equals(other.id);
	}
}
