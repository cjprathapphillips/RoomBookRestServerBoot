package com.roombooker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roombooker.Dao.RoomDao;
import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Room;
import com.roombooker.service.RoomService;

/**
 * @author Prathap Phillips
 *
 */
/** Service Implementation for Room */
@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomDao roomDao;
	
	/** Get all the Room */
	@Override
	public List<Room> getAll() {
		return roomDao.getAll();
	}

	/** Get an existing Room with id */
	@Override
	public Room getById(long id) {
		return roomDao.getById(id);
	}

	/** Save a new Room */
	@Override
	public Room save(Room room) throws BadRequestException {
		return roomDao.save(room);
	}

	/** Update details for an existing room */
	@Override
	public Room update(Room room) {
		return roomDao.update(room);
	}
}
