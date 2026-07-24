package com.algaworks.algasensors.temperature.processing

import com.algaworks.algasensors.temperature.processing.common.IdGenerator
import com.algaworks.algasensors.temperature.processing.common.UUIDv7Utils
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit
import java.util.*

class UUIDV7Test {

    @Test
    fun `should generate UUID v7`() {
        val uuid1: UUID = IdGenerator.generateTimeBasedUUID()
        val uuid2: UUID = IdGenerator.generateTimeBasedUUID()
        val uuid3: UUID = IdGenerator.generateTimeBasedUUID()
        val uuid4: UUID = IdGenerator.generateTimeBasedUUID()

        println(UUIDv7Utils.extractOffsetDateTime(uuid1))
        println(UUIDv7Utils.extractOffsetDateTime(uuid2))
        println(UUIDv7Utils.extractOffsetDateTime(uuid3))
        println(UUIDv7Utils.extractOffsetDateTime(uuid4))

        val uuidDateTime = UUIDv7Utils.extractOffsetDateTime(uuid1).truncatedTo(ChronoUnit.MINUTES)
        val currentOffsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES)

        Assertions.assertThat(uuidDateTime).isEqualTo(currentOffsetDateTime)
    }

}