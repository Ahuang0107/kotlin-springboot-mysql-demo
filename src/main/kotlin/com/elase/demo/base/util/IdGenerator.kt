package com.elase.demo.base.util

import cn.hutool.core.lang.Snowflake
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import java.io.Serializable

@Suppress("UNUSED")
class IdGenerator : IdentifierGenerator {

  companion object {
    private val snowflake = Snowflake(1, 1)

    @JvmStatic
    fun generate() = snowflake.nextId()
  }

  override fun generate(p0: SharedSessionContractImplementor?, p1: Any?): Serializable {
    return snowflake.nextId()
  }
}
