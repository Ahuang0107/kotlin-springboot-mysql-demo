package com.elase.demo.api.dto.converter

import com.elase.demo.api.dto.FileDto
import com.elase.demo.api.dto.LayerDto
import com.elase.demo.api.dto.PageDto
import com.elase.demo.module.entity.FileEntity
import com.elase.demo.module.entity.LayerEntity
import com.elase.demo.module.entity.PageEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.factory.Mappers

@Mapper
interface FileConverter {
    companion object {
        val INSTANCE: FileConverter = Mappers.getMapper(FileConverter::class.java)
    }

    @Mappings(
        Mapping(target = "pages", ignore = true),
    )
    fun toDto(source: FileEntity): FileDto

    @Mappings(
        Mapping(target = "layers", ignore = true),
    )
    fun toDto(source: PageEntity): PageDto

    fun toDto(source: LayerEntity): LayerDto
}

fun FileEntity.toDto(): FileDto =
    FileConverter.INSTANCE.toDto(this)

fun PageEntity.toDto(): PageDto =
    FileConverter.INSTANCE.toDto(this)

fun LayerEntity.toDto(): LayerDto =
    FileConverter.INSTANCE.toDto(this)