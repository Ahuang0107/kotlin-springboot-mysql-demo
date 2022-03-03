package com.elase.demo.module.service.repo

import com.elase.demo.base.repo.BaseRepo
import com.elase.demo.module.entity.LayerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LayerRepo : BaseRepo<LayerEntity> {
    fun findAllByPageId(pageId: Long): List<LayerEntity>
}