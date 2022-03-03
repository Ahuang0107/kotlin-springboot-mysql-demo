package com.elase.demo.base.exception

open class ResourceNotFoundException @JvmOverloads constructor(message: String = "未找到资源") : RuntimeException(message)