package com.roombooker.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roombooker.Dao.RoomDao;
import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Room;

@Transactional
@Repository
public class RoomDaoImpl implements RoomDao {

	@PersistenceContext
	private EntityManager entityManager;

	/** Get All Rooms */
	public List<Room> getAll() {
		List<Room> rooms = (List<Room>) entityManager.createNamedQuery("@getAllRoom").getResultList();
		return rooms;
	}

	/** Get a Room with id */
	public Room getById(long id) {
		Room room = entityManager.find(Room.class, id);
		return room;
	}

	/** Save a new Room */
	public Room save(Room room) throws BadRequestException {
		try {
			entityManager.persist(room);
		} catch (Exception exception) {
			exception.printStackTrace();
			if (exception instanceof ConstraintViolationException) {
				throw new BadRequestException();
			}
		}
		return room;
	}

	/** Update an Existing Room with ID */
	public Room update(Room room) {
		Room roomOld = entityManager.find(Room.class, room.getId());
		roomOld.copyRoom(room);
		return roomOld;
	}

}
