package com.example.foody.data

import com.example.foody.data.RemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class Repository @Inject constructor(
    private val remoteDataSource:RemoteDataSource
) {
    val remote = remoteDataSource
}