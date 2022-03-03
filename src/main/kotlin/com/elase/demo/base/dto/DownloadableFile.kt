package com.elase.demo.base.dto

import org.apache.tika.Tika
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import java.io.File
import java.io.InputStream
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class DownloadableFile(
    var fileName: String,
    var contentType: String,
    var contentLength: Long,
    var inputStream: InputStream,
)

/**
 * 转换成可下载的HTTP请求回应
 */
fun DownloadableFile.toDownloadResponse(anotherName: String? = null): ResponseEntity<Resource> {
    val fileName =
        if (anotherName.isNullOrBlank()) this.fileName
        else anotherName
    val encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name())
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_TYPE, "multipart/form-data")
        .header(HttpHeaders.CONTENT_LENGTH, this.contentLength.toString())
        .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
        .header(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"$encodedFileName\"; filename*=utf-8''$encodedFileName"
        ).body(InputStreamResource(this.inputStream))
}

/**
 * 转换成含文件流的HTTP请求回应
 */
fun DownloadableFile.toResponse(): ResponseEntity<Resource> {
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(this.contentType))
        .header(HttpHeaders.CONTENT_LENGTH, this.contentLength.toString())
        .body(InputStreamResource(this.inputStream))
}

fun File.toDownloadableFile(alternativeName: String? = null): DownloadableFile {
    return DownloadableFile(
        alternativeName ?: this.name,
        Tika().detect(this),
        this.length(),
        this.inputStream()
    )
}

fun File.toDownloadResponse(anotherName: String? = null): ResponseEntity<Resource> {
    return this.toDownloadableFile(anotherName).toDownloadResponse(anotherName)
}
