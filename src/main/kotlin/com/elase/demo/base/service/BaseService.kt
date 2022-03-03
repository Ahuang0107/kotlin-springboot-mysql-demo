package com.elase.demo.base.service

import com.elase.demo.base.entity.BaseEntity
import com.elase.demo.base.exception.ResourceNotFoundException
import com.elase.demo.base.repo.BaseRepo
import org.springframework.transaction.annotation.Transactional

@Transactional
interface BaseService<E : BaseEntity> {
    val repo: BaseRepo<E>

    fun findById(id: Long): E? =
        repo.findById(id).orElse(null)

    fun getById(id: Long): E =
        findById(id) ?: throw notFoundException

    fun save(entity: E): E =
        repo.save(entity)

    fun delete(entity: E) =
        repo.delete(entity)

    val notFoundException
        get() = ResourceNotFoundException()
}