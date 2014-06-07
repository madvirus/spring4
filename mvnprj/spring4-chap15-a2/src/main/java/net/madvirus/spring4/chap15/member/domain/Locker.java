package net.madvirus.spring4.chap15.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "LOCKER")
public class Locker {
	@Id
	@Column(name = "LOCKER_ID")
	private Long id;

	@Column(name = "LOCKER_SIZE")
	private int size;

	@Column(name = "OCCUPIED")
	@Type(type = "yes_no")
	private boolean occupied;

	protected Locker() {
	}

	public Locker(Long id, int size) {
		this.id = id;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

}
