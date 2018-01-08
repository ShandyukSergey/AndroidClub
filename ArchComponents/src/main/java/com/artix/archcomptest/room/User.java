package com.artix.archcomptest.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by User on 07.01.2018.
 */
@Entity
public class User {
	@PrimaryKey(autoGenerate = true)
	public int id;

	public final String name;

	public User(String name) {
		this.name = name;
	}
}
