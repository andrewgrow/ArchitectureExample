package com.gahov.demo.domain.usecase

import com.gahov.architecture.domain.entities.Either
import com.gahov.architecture.domain.entities.failure.Failure
import com.gahov.architecture.domain.usecase.AsyncUseCase
import com.gahov.architecture.domain.usecase.UseCase
import com.gahov.demo.domain.entities.LocationEntity
import com.gahov.demo.domain.repository.LocationRepository

class GetLocation(private val repository: LocationRepository) : AsyncUseCase<LocationEntity>() {

    override suspend fun execute(param: UseCase.Params?): Either<Failure, LocationEntity> {
        return repository.getLocation()
    }
}