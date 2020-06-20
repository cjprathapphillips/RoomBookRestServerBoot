package com.roombooker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author Prathap Phillips
 *
 */
/** All Db operation for a Room with be done with this Entity */
@Entity
@Table(name = "rooms", schema = "roombook")
@NamedQueries({ @NamedQuery(name = "@getAllRoom", query = "From Room") })
public class Room{
	/* Unique id per room for bookkeeping */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/* ‘Q’ for queen bed; ‘K’ for king bed */
	@Column
	@Size(min = 1, max = 1, message = "Room Type : Q(Queen) or K(King)")
	@Pattern(regexp = "^[Q|K]{1}$", message ="Room Type : Q(Queen) or K(King)")
	private String roomtype;
	/* Amount fixed as rent for the room */
	@Column
	@Min(value=3000, message="must be equal or greater than 3000")  
    @Max(value=30000, message="must be equal or less than 30000")  
	private Integer rent;

	public Room() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomtype=" + roomtype + ", rent=" + rent + "]";
	}
	
	public void copyRoom(Room room) {
		this.id=room.getId();
		this.roomtype=room.getRoomtype();
		this.rent=room.getRent();
	}



}
