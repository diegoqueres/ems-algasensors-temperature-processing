package com.algaworks.algasensors.temperature.processing

import com.fasterxml.uuid.Generators
import com.fasterxml.uuid.impl.TimeBasedEpochRandomGenerator
import java.util.*

object IdGenerator {

    private val timeBasedEpochRandomGenerator: TimeBasedEpochRandomGenerator =
        Generators.timeBasedEpochRandomGenerator()

    fun generateTimeBasedUUID(): UUID = timeBasedEpochRandomGenerator.generate()

}