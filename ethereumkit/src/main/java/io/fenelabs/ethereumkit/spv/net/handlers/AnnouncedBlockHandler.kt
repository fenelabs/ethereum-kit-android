package io.fenelabs.ethereumkit.spv.net.handlers

import io.fenelabs.ethereumkit.spv.core.IMessageHandler
import io.fenelabs.ethereumkit.spv.core.IPeer
import io.fenelabs.ethereumkit.spv.net.IInMessage
import io.fenelabs.ethereumkit.spv.net.les.messages.AnnounceMessage

class AnnouncedBlockHandler(private var listener: Listener? = null) : IMessageHandler {

    interface Listener {
        fun didAnnounce(peer: IPeer, blockHash: ByteArray, blockHeight: Long)
    }

    override fun handle(peer: IPeer, message: IInMessage): Boolean {
        if (message !is AnnounceMessage) {
            return false
        }

        listener?.didAnnounce(peer, message.blockHash, message.blockHeight)

        return true
    }
}
