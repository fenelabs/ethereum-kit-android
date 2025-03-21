package io.fenelabs.ethereumkit.spv.net.connection.messages

import io.fenelabs.ethereumkit.core.toHexString
import io.fenelabs.ethereumkit.spv.rlp.RLP
import org.bouncycastle.math.ec.ECPoint

class AuthMessage(val signature: ByteArray, val publicKeyPoint: ECPoint, val nonce: ByteArray) {

    fun encoded(): ByteArray {
        val publicKey = ByteArray(64)
        System.arraycopy(publicKeyPoint.getEncoded(false), 1, publicKey, 0, publicKey.size)
        val sigBytes = RLP.encode(signature)
        val publicBytes = RLP.encode(publicKey)
        val nonceBytes = RLP.encode(nonce)
        val versionBytes = RLP.encodeInt(4)

        return RLP.encodeList(sigBytes, publicBytes, nonceBytes, versionBytes)
    }

    override fun toString(): String {
        return "AuthMessage [signature: ${signature.toHexString()}; ephemPublicKeyPoint: $publicKeyPoint; nonce: ${nonce.toHexString()}]"
    }
}