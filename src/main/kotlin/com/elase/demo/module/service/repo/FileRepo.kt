package com.elase.demo.module.service.repo

import com.elase.demo.base.repo.BaseRepo
import com.elase.demo.module.entity.FileEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FileRepo : BaseRepo<FileEntity>