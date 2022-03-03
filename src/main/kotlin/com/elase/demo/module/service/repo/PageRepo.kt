package com.elase.demo.module.service.repo

import com.elase.demo.base.repo.BaseRepo
import com.elase.demo.module.entity.PageEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PageRepo : BaseRepo<PageEntity> {
    fun findAllByFileId(fileId: Long): List<PageEntity>
}