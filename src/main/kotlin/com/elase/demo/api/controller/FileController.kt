package com.elase.demo.api.controller

import com.elase.demo.api.dto.FileDto
import com.elase.demo.api.facade.FileFacade
import com.elase.demo.base.property.SystemConst
import com.elase.demo.base.dto.AppResponse
import com.elase.demo.base.dto.successResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(SystemConst.API_PREFIX + "/file")
class FileController(
    private val facade: FileFacade,
) {

    @GetMapping("/{id}")
    fun getFileById(@PathVariable id: Long): AppResponse<FileDto> {
        return facade.getFileById(id).successResult()
    }
}