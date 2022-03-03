package com.elase.demo.api.dto

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer

data class LayerDto(
    @JsonSerialize(using = ToStringSerializer::class)
    var id: Long = 0L,
    @JsonSerialize(using = ToStringSerializer::class)
    var pageId: Long = 0L,
    var name: String = "",
)
