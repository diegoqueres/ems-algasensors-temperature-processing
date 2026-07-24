package com.algaworks.algasensors.temperature.processing.common

import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneId
import java.util.*

object UUIDv7Utils {

    fun extractOffsetDateTime(uuid: UUID): OffsetDateTime {
        val timestamp: Long = uuid.mostSignificantBits ushr 16
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
    }

}