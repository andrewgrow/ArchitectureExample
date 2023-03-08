package com.gahov.demo.data.source

import com.gahov.architecture.domain.entities.Either
import com.gahov.architecture.domain.entities.failure.Failure
import com.gahov.architecture.domain.source.Source
import com.gahov.demo.domain.entities.LocationEntity

interface LocationSource : Source {
    suspend fun fetchLocation(): Either<Failure, LocationEntity>
}