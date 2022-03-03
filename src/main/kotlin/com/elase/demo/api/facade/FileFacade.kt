package com.elase.demo.api.facade

import com.elase.demo.api.dto.FileDto

interface FileFacade {
    fun getFileById(id: Long): FileDto
}