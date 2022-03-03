package com.elase.demo.api.dto

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer

data class FileDto(
    @JsonSerialize(using = ToStringSerializer::class)
    var id: Long = 0L,
    var name: String = "",
    var pages: List<PageDto> = emptyList(),
)
