package com.gahov.demo.domain.repository

import com.gahov.architecture.domain.entities.Either
import com.gahov.architecture.domain.entities.failure.Failure
import com.gahov.architecture.domain.repository.Repository
import com.gahov.demo.domain.entities.LocationEntity

interface LocationRepository : Repository {
    suspend fun getLocation(): Either<Failure, LocationEntity>
}