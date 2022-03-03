package com.elase.demo.api.dto

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer

data class PageDto(
    @JsonSerialize(using = ToStringSerializer::class)
    var id: Long = 0L,
    @JsonSerialize(using = ToStringSerializer::class)
    var fileId: Long = 0L,
    var name: String = "",
    var layers: List<LayerDto> = emptyList(),
)
