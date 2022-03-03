package com.elase.demo.module.service.impl

import com.elase.demo.module.entity.FileEntity
import com.elase.demo.module.entity.LayerEntity
import com.elase.demo.module.entity.PageEntity
import com.elase.demo.module.service.repo.FileRepo
import com.elase.demo.module.service.FileService
import com.elase.demo.module.service.LayerService
import com.elase.demo.module.service.PageService
import com.elase.demo.module.service.repo.LayerRepo
import com.elase.demo.module.service.repo.PageRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class LayerServiceImpl(
    override val repo: LayerRepo,
) : LayerService {
    override fun findAllByPageId(pageId: Long): List<LayerEntity> {
        return repo.findAllByPageId(pageId)
    }
}