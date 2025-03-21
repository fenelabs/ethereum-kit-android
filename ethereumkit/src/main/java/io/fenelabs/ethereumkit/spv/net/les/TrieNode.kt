package io.fenelabs.ethereumkit.spv.net.les

import io.fenelabs.ethereumkit.core.toHexString
import io.fenelabs.ethereumkit.core.toRawHexString
import io.fenelabs.ethereumkit.crypto.CryptoUtils
import io.fenelabs.ethereumkit.spv.rlp.RLPList
import java.util.*

class TrieNode(rlpList: RLPList) {

    companion object {
        private val alphabet = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
    }

    enum class NodeType {
        NULL,
        BRANCH,
        EXTENSION,
        LEAF
    }

    var nodeType: io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType =
        io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.NULL

    val elements: MutableList<ByteArray>
    var encodedPath: String? = null
    var hash: ByteArray

    init {
        this.elements = ArrayList()
        for (element in rlpList) {
            this.elements.add(element.rlpData ?: ByteArray(0))
        }

        this.hash = CryptoUtils.sha3(rlpList.rlpData ?: ByteArray(0))

        if (rlpList.size == 17) {
            this.nodeType = io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.BRANCH
        } else {
            val first = this.elements[0]
            val nibble = ((first[0].toInt() and 0xFF) shr 4).toByte()

            when (nibble.toInt()) {
                0 -> {
                    this.nodeType = io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.EXTENSION
                    encodedPath = first.copyOfRange(1, first.size).toRawHexString()
                }

                1 -> {
                    this.nodeType = io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.EXTENSION
                    encodedPath = first.copyOfRange(1, first.size).toRawHexString()
                    val firstByte = ((((first[0].toInt() and 0xFF) shl 4) and 0xFF) shr 4).toByte()
                    val firstByteString = byteArrayOf(firstByte).toRawHexString()
                    encodedPath = firstByteString.substring(1) + encodedPath
                }

                2 -> {
                    this.nodeType = io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.LEAF
                    encodedPath = first.copyOfRange(1, first.size).toRawHexString()
                }

                3 -> {
                    this.nodeType = io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.LEAF
                    encodedPath = first.copyOfRange(1, first.size).toRawHexString()
                    val firstByte = ((((first[0].toInt() and 0xFF) shl 4) and 0xFF) shr 4).toByte()
                    val firstByteString = byteArrayOf(firstByte).toRawHexString()
                    encodedPath = firstByteString.substring(1) + encodedPath
                }
            }
        }
    }

    fun getPath(element: ByteArray?): String? {
        if (element == null && nodeType == io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.LEAF) {
            return encodedPath
        }

        for (i in elements.indices) {
            if (Arrays.equals(elements[i], element)) {
                if (nodeType == io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.BRANCH) {
                    return io.fenelabs.ethereumkit.spv.net.les.TrieNode.Companion.alphabet[i].toString()
                } else if (nodeType == io.fenelabs.ethereumkit.spv.net.les.TrieNode.NodeType.EXTENSION) {
                    return encodedPath
                }
            }
        }
        return null
    }

    override fun toString(): String {
        return "(${elements.joinToString(separator = " | ") { it.toHexString() }})"
    }
}