package com.elase.demo.module.service

import com.elase.demo.base.service.BaseService
import com.elase.demo.module.entity.FileEntity
import com.elase.demo.module.entity.PageEntity
import java.util.*

interface PageService : BaseService<PageEntity>{
    fun findAllByFileId(fileId: Long): List<PageEntity>
}