package com.gahov.demo.data.remote.source.location

import com.gahov.architecture.domain.entities.Either
import com.gahov.architecture.domain.entities.failure.Failure
import com.gahov.demo.data.source.LocationSource
import com.gahov.demo.domain.entities.LocationEntity

class LocationSourceImpl : LocationSource {
     override suspend fun fetchLocation(): Either<Failure, LocationEntity> {

    }

}