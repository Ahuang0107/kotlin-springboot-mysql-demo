package com.elase.demo.api.facade.impl

import com.elase.demo.api.dto.FileDto
import com.elase.demo.api.dto.LayerDto
import com.elase.demo.api.dto.PageDto
import com.elase.demo.api.dto.converter.toDto
import com.elase.demo.api.facade.FileFacade
import com.elase.demo.module.service.FileService
import com.elase.demo.module.service.LayerService
import com.elase.demo.module.service.PageService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FileFacadeImpl(
    private val service: FileService,
    private val pageService: PageService,
    private val layerService: LayerService,
) : FileFacade {
    override fun getFileById(id: Long): FileDto {
        return service.getById(id).toDto().also { fileDto ->
            fileDto.pages = getAllPageByFileId(fileDto.id).map {
                it.layers = getAllLayerByPageId(it.id)
                it
            }
        }
    }

    private fun getAllPageByFileId(fileId: Long): List<PageDto> {
        return pageService.findAllByFileId(fileId).map { it.toDto() }
    }

    private fun getAllLayerByPageId(pageId: Long): List<LayerDto> {
        return layerService.findAllByPageId(pageId).map { it.toDto() }
    }
}