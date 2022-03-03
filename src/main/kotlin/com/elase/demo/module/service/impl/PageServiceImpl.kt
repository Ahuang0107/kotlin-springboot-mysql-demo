package com.elase.demo.module.service.impl

import com.elase.demo.module.entity.FileEntity
import com.elase.demo.module.entity.PageEntity
import com.elase.demo.module.service.repo.FileRepo
import com.elase.demo.module.service.FileService
import com.elase.demo.module.service.PageService
import com.elase.demo.module.service.repo.PageRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class PageServiceImpl(
    override val repo: PageRepo,
) : PageService {
    override fun findAllByFileId(fileId: Long): List<PageEntity> {
        return repo.findAllByFileId(fileId)
    }
}