package com.jinbo.pms.common.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
/**
 * 数据Entity类
 * @author merlin
 *
 */
@MappedSuperclass
public abstract class BaseDataEntity extends BaseIdEntity implements java.io.Serializable{
	
	/**
	 */
	private static final long serialVersionUID = -7235849358914111098L;
	// 创建日期
	protected Date createDate;
	// 更新日期
	protected Date modifyDate;
	// 创建人
	protected Integer createUserId;
	// 更新人
	protected Integer modifyUserId;
	// 版本号
	protected Integer version;
	// 是否删除
	protected String deleted = "N";

	/**
	 * @return the createDate
	 */
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the modifyDate
	 */
	@Column(name = "MODIFY_DATE")
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate
	 *            the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return the createUserId
	 */
	@Column(name = "CREATE_USER_ID")
	public Integer getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId
	 *            the createUserId to set
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return the modifyUserId
	 */
	@Column(name = "MODIFY_USER_ID")
	public Integer getModifyUserId() {
		return modifyUserId;
	}

	/**
	 * @param modifyUserId
	 *            the modifyUserId to set
	 */
	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	/**
	 * @return the version
	 */
	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the deleted
	 */
	@Column(name = "DELETED")
	public String getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set
	 */
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
}
