package com.elase.demo.module.entity

import com.elase.demo.base.entity.BaseEntity
import javax.persistence.Entity

@Entity(name = "f_layer")
class LayerEntity(
    var pageId: Long = 0L,
    var name: String = "",
) : BaseEntity()