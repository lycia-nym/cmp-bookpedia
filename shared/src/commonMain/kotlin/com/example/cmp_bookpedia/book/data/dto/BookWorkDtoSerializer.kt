package com.example.cmp_bookpedia.book.data.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

object BookWorkDtoSerializer : KSerializer<BookWorkDto> {

    // Outline which field to serialize
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(
        BookWorkDto::class.simpleName!!
    ) {
        // index = 0 **
        element<String?>("description")
    }

    override fun deserialize(decoder: Decoder): BookWorkDto = decoder.decodeStructure(descriptor) {
        var description: String? = null

        while (true) {
            // index is order of element *
            when (val index = decodeElementIndex(descriptor)) {
                0 -> {
                    // Try to cast to json, if not castable -> Response was not json
                    val jsonDecoder = decoder as? JsonDecoder ?: throw SerializationException(
                        "This decoder only work with JSON."
                    )
                    val element = jsonDecoder.decodeJsonElement()
                    description = if (element is JsonObject) {
                        decoder.json.decodeFromJsonElement<DescriptionDto>(
                            element = element,
                            deserializer = DescriptionDto.serializer()
                        ).value
                    } else if (element is JsonPrimitive && element.isString) {
                        element.content
                    } else null
                }

                CompositeDecoder.DECODE_DONE -> break
                else -> throw SerializationException("Unexpected index $index")
            }
        }

        return@decodeStructure BookWorkDto(description)
    }

    // not needed for now
    override fun serialize(
        encoder: Encoder,
        value: BookWorkDto
    ) = encoder.encodeStructure(descriptor) {
        value.description?.let {
            encodeStringElement(descriptor, 0, it)
        }
    }
}