package com.webup.soa.base;


/**
 * 树结构的基类
 * @author cgb
 *
 * @param <K>
 */
public class BaseTreeEntity<K,T extends BaseTreeEntity<K,?>> extends IdEntity<K>{
	
	private static final long serialVersionUID = 1L;
	
	public static final String  NAV_SPLIT="|";
	
	public static final int ROOT_ID = 0;
	
	public static final int FIRST=1;//一
	public static final int SECOND=2;//二
	public static final int THIRD=3;//三
	public static final int ZERO=0;//零
	
	protected String code;
	
	protected String name;
	
	protected  String description;
	
	protected  Boolean leaf;
	
	protected Integer level;
	
	protected T parent;
	
	protected  Integer sortNo;
	
	//拼音
//    protected String spell;
	
	
	protected String helpCode;
	
	//拼音缩写
//    protected String spellShort;
    
    protected String navIds;//导航ids
    
    
    
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getLeaf() {
		return leaf;
	}
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public T getParent() {
		return parent;
	}
	public void setParent(T parent) {
		this.parent = parent;
	}
	
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getHelpCode() {
		return helpCode;
	}
	public void setHelpCode(String helpCode) {
		this.helpCode = helpCode;
	}
	public String getNavIds() {
		return navIds;
	}
	public void setNavIds(String navIds) {
		this.navIds = navIds;
	}
	
	
}
