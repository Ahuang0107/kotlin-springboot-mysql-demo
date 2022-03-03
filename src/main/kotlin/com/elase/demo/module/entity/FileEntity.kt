package com.elase.demo.module.entity

import com.elase.demo.base.entity.BaseEntity
import javax.persistence.Entity

@Entity(name = "f_file")
class FileEntity(
    var name: String = "",
) : BaseEntity()