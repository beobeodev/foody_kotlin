package com.beo.foody.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

// use annotation @ActivityRetainedScoped to Hilt provides the same instance of Repository throughout the life of the corresponding activity
// Use the @Inject annotation on the constructor of a class to tell Hilt how to provide instances of that class
@ActivityRetainedScoped
class Repository @Inject constructor(remoteDataSource: RemoteDataSource) {
    val remote = remoteDataSource
}