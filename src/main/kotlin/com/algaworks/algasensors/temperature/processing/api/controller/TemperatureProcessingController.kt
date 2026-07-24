package com.algaworks.algasensors.temperature.processing.api.controller

import com.algaworks.algasensors.temperature.processing.api.model.TemperatureLogOutput
import com.algaworks.algasensors.temperature.processing.common.IdGenerator
import io.hypersistence.tsid.TSID
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.OffsetDateTime

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures/data")
class TemperatureProcessingController {
    companion object {
        private val log = LoggerFactory.getLogger(TemperatureProcessingController::class.java)
    }

    @PostMapping(consumes = [MediaType.TEXT_PLAIN_VALUE])
    fun data(@PathVariable sensorId: TSID, @RequestBody input: String) {
        if (input.isBlank()) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }

        val temperature: Double
        try {
            temperature = input.toDouble()
        } catch (_: NumberFormatException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }

        val logOutput = TemperatureLogOutput(
            id = IdGenerator.generateTimeBasedUUID(),
            sensorId = sensorId,
            value = temperature,
            registeredAt = OffsetDateTime.now()
        )
        log.info(logOutput.toString())
    }

}