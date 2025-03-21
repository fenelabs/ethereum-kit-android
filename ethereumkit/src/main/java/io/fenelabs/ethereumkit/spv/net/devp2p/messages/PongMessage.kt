package io.fenelabs.ethereumkit.spv.net.devp2p.messages

import io.fenelabs.ethereumkit.core.hexStringToByteArray
import io.fenelabs.ethereumkit.spv.net.IInMessage
import io.fenelabs.ethereumkit.spv.net.IOutMessage

class PongMessage() : IInMessage, IOutMessage {

    constructor(payload: ByteArray) : this()

    override fun encoded(): ByteArray {
        return payload
    }

    override fun toString(): String {
        return "Pong"
    }

    companion object {
        val payload = "C0".hexStringToByteArray()
    }
}
