package io.fenelabs.ethereumkit.spv.net.connection.messages

import io.fenelabs.ethereumkit.core.toHexString
import io.fenelabs.ethereumkit.crypto.CryptoUtils.CURVE
import io.fenelabs.ethereumkit.spv.rlp.RLP
import io.fenelabs.ethereumkit.spv.rlp.RLPList
import io.fenelabs.ethereumkit.spv.core.toInt
import org.bouncycastle.math.ec.ECPoint

class AuthAckMessage(payload: ByteArray) {
    val ephemPublicKeyPoint: ECPoint
    val nonce: ByteArray
    val version: Int

    init {
        val params = RLP.decodeToOneItem(payload, 0) as RLPList
        val pubKeyBytes = params[0].rlpData ?: ByteArray(65) { 0 }
        val bytes = ByteArray(65)
        System.arraycopy(pubKeyBytes, 0, bytes, 1, 64)
        bytes[0] = 0x04
        val ephemeralPublicKey = CURVE.curve.decodePoint(bytes)
        val nonce = params[1].rlpData
        val versionBytes = params[2].rlpData
        val version = versionBytes.toInt()
        this.ephemPublicKeyPoint = ephemeralPublicKey
        this.nonce = nonce ?: ByteArray(0)
        this.version = version
    }

    override fun toString(): String {
        return "AuthAckMessage [ephemPublicKeyPoint: $ephemPublicKeyPoint; nonce: ${nonce.toHexString()}; version: $version]"
    }
}