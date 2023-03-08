package com.gahov.demo.domain.usecase

import com.gahov.architecture.domain.entities.Either
import com.gahov.architecture.domain.entities.OperationStatus
import com.gahov.architecture.domain.entities.failure.Failure
import com.gahov.architecture.domain.usecase.AsyncUseCase
import com.gahov.architecture.domain.usecase.UseCase
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

class PreLoadingUseCase : AsyncUseCase<OperationStatus>() {

    @OptIn(ExperimentalTime::class)
    override suspend fun execute(param: UseCase.Params?): Either<Failure, OperationStatus> {
        val delay = Random.nextInt(DELAY_FROM, DELAY_UNTIL).seconds
        delay(delay)
        return Either.Right(OperationStatus.SUCCESS)
    }

    companion object {
        private const val DELAY_FROM = 3
        private const val DELAY_UNTIL = 10
    }
}