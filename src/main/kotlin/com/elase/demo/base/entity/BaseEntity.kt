package com.elase.demo.base.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @GenericGenerator(name = "snowflakeId", strategy = "com.elase.demo.base.util.IdGenerator")
    @GeneratedValue(generator = "snowflakeId")
    var id: Long = 0
) {
}