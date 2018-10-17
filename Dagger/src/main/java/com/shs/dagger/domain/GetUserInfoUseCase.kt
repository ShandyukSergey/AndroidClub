package com.shs.dagger.domain

import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val userRepository: UserRepository) : IGetUserInfoUseCase {

	override fun getInfo(): String = userRepository.getUserData()
}