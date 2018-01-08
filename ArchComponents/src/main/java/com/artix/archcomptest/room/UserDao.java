package com.artix.archcomptest.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by User on 07.01.2018.
 */
@Dao
public interface UserDao {

	@Query("SELECT * FROM User")
	List<User> getAll();

	@Insert
	long insert(User users);
}
