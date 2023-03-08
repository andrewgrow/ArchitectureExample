package com.gahov.demo.data.repository

import com.gahov.architecture.domain.entities.Either
import com.gahov.architecture.domain.entities.failure.Failure
import com.gahov.demo.data.source.LocationSource
import com.gahov.demo.domain.entities.LocationEntity
import com.gahov.demo.domain.repository.LocationRepository

class LocationRepositoryImpl(network: LocationSource) : LocationRepository {
    override suspend fun getLocation(): Either<Failure, LocationEntity> {
        TODO("Not yet implemented")
    }
}