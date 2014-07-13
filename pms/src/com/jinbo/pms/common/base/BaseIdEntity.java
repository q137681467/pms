package com.jinbo.pms.common.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;


/**
 * Entity支持类
 * @author merlin
 *
 */
@MappedSuperclass
public abstract class BaseIdEntity implements java.io.Serializable {

	/**
	 */
	private static final long serialVersionUID = 664224518458833694L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
