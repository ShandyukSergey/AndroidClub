package com.shs.dagger.data

import com.shs.dagger.domain.UserRepository
import javax.inject.Inject

class InMemoryUserRepository @Inject constructor() : UserRepository {
	override fun getUserData(): String = "user data - shsshsshs"
}