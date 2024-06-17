package com.example.routes.files

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.fileRoutes() {
    routing {
        route("/file") {
            post ("/upload") {
                // retrieve all multipart data (suspending)
                val multipart = call.receiveMultipart()
                multipart.forEachPart { part ->
                    // if part is a file (could be form item)
                    if(part is PartData.FileItem) {
                        // retrieve file name of upload
                        //val name = part.originalFileName!!
                        //val name = "file_$index" // Puedes asignar un nombre personalizado al archivo basado en el índice
                        val name = part.originalFileName ?: return@forEachPart
                        val root = call.application.environment.rootPath
                        val folderName = name.substringBefore("_")
                        val folder = File(root, "uploads/$folderName")
                        if (!folder.exists()) {
                            folder.mkdirs() // Create directory if it doesn't exist
                        }

                        val file = File(folder, name)

                        // use InputStream from part to save file
                        part.streamProvider().use { its ->
                            // copy the stream to the file with buffering
                            file.outputStream().buffered().use {
                                // note that this is blocking
                                its.copyTo(it)
                            }
                        }
                    }
                    // make sure to dispose of the part after use to prevent leaks
                    part.dispose()
                }
            }

            get("/{product}/{name}") {
                // get filename from request url
                val filename = call.parameters["name"]!!
                val fileProduct = call.parameters["product"]!!
                // construct reference to file
                // ideally this would use a different filename
                val file = File("/uploads/$fileProduct/${fileProduct}_${filename}_image.png")
                if(file.exists()) {
                    call.respondFile(file)
                }
                else call.respond(HttpStatusCode.NotFound)
            }
        }
    }
}