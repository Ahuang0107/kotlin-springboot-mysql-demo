package com.elase.demo.base.dto

class AppResponse<T> {
    /**
     * 错误代码
     */
    var code: Int = ResponseCode.SUCCESS.code

    /**
     * 成功标志
     */
    var success: Boolean = true

    /**
     * 错误信息
     */
    var message: String = "success"

    /**
     * 返回数据
     */
    var data: T? = null

    enum class ResponseCode constructor(val code: Int, val defaultMessage: String) {
        /**
         * 成功
         */
        SUCCESS(200, "成功"),

        /**
         * 请求有误
         */
        INVALID_REQUEST(401, "请求有误"),

        /**
         * 缺少必要请求参数
         */
        MISSING_REQUIRED_ARGS(402, "缺少必要请求参数"),

        /**
         * 权限不足
         */
        ACCESS_DENIED(403, "权限不足"),

        /**
         * 目标资源不存在
         */
        NOT_FOUND(404, "目标资源不存在"),

        /**
         * 数据冲突
         */
        CONFLICTED(405, "数据冲突"),

        /**
         * 系统异常
         */
        SYSTEM_ERROR(500, "系统异常"),

        /**
         * 业务异常
         */
        FAILED(501, "业务异常")
    }

    companion object {

        @JvmStatic
        fun success(): AppResponse<Any> {
            return AppResponse<Any>().apply {
                this.success = true
            }
        }

        /**
         * 返回成功数据
         */
        @JvmStatic
        fun <T> success(data: T): AppResponse<T> {
            return AppResponse<T>().apply {
                this.code = ResponseCode.SUCCESS.code
                this.success = true
                this.message = ResponseCode.SUCCESS.defaultMessage
                this.data = data
            }
        }

        /**
         * 返回错误数据
         * @param code 错误代码
         */
        @JvmStatic
        @JvmOverloads
        fun failed(code: ResponseCode, message: String? = null, data: Any? = null): AppResponse<Any> {
            return AppResponse<Any>().apply {
                this.code = code.code
                this.success = false
                this.message = message ?: code.defaultMessage
                this.data = data
            }
        }

        /**
         * 返回错误数据
         * @param exception 业务异常
         */
        @JvmStatic
        fun failed(code: ResponseCode, exception: Throwable, message: String? = null): AppResponse<*> {
            return failed(code).apply {
                this.message = message ?: exception.message ?: code.defaultMessage
                this.data = exception.message
            }
        }

        /**
         * 返回错误数据
         * @param exception 业务异常
         */
        @JvmStatic
        fun failed(exception: Throwable): AppResponse<*> {
            return failed(ResponseCode.FAILED).apply {
                this.message = exception.message ?: this.message
                this.data = exception.toString()
            }
        }
    }
}

fun <T> T.successResult() = AppResponse.success(this)