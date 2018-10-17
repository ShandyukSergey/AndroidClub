package com.shs.dagger.data

import android.util.Log
import com.shs.dagger.domain.Authorization
import javax.inject.Inject

class OauthAuthorization @Inject constructor() : Authorization {
	override fun authorize() {
		Log.d("shsshs", "Authorized")
	}
}