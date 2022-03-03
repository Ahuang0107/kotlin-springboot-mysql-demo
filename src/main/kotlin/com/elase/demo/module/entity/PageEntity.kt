package com.elase.demo.module.entity

import com.elase.demo.base.entity.BaseEntity
import javax.persistence.Entity

@Entity(name = "f_page")
class PageEntity(
    var fileId: Long = 0L,
    var name: String = "",
) : BaseEntity()