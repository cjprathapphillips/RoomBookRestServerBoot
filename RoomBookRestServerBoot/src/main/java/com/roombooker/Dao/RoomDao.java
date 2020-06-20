package com.roombooker.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;

import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Room;
import com.roombooker.service.RoomBookStautusResponce;



/**
 * @author Prathap Phillips
 *
 */
/** Room Dao Interface for CRUDE Operation */
public interface RoomDao {
	/**
	 * @return
	 */
	public List<Room> getAll();
	/**
	 * @param id
	 * @return
	 */
	public Room getById(long id);
	/**
	 * @param room
	 * @return
	 * @throws BadRequestException
	 */
	public Room save(Room room)throws BadRequestException;
	/**
	 * @param room
	 * @return
	 */
	public Room update(Room room);
}
