package com.elase.demo.module.service.impl

import com.elase.demo.module.entity.FileEntity
import com.elase.demo.module.service.repo.FileRepo
import com.elase.demo.module.service.FileService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FileServiceImpl(
    override val repo: FileRepo,
) : FileService {
}