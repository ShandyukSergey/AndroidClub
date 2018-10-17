package com.shs.dagger.domain

import javax.inject.Inject

class AuthorizationUseCase @Inject constructor(private val authorization: Authorization) : IAuthorizationUseCase {

	override fun authorize() = authorization.authorize()
}