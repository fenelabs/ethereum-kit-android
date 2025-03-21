package io.fenelabs.ethereumkit.spv.net.devp2p.messages

import io.fenelabs.ethereumkit.core.hexStringToByteArray
import io.fenelabs.ethereumkit.spv.net.IInMessage

class PingMessage() : IInMessage {

    constructor(payload: ByteArray) : this()

    override fun toString(): String {
        return "Ping"
    }

    companion object {
        val payload = "C0".hexStringToByteArray()
    }
}
