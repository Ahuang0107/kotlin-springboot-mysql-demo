package com.elase.demo.base.repo

import com.elase.demo.base.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface BaseRepo<E : BaseEntity> : JpaRepository<E, Long> {
    @Query("select entity from #{#entityName} entity where entity.id = :id")
    override fun findById(id: Long): Optional<E>

    @Query("select entity from #{#entityName} entity where entity.id in :idList")
    fun findAllById(idList: List<Long>): List<E>
}