package io.fenelabs.erc20kit.core

import io.fenelabs.erc20kit.decorations.ApproveEip20Decoration
import io.fenelabs.erc20kit.events.ApproveEventInstance
import io.fenelabs.erc20kit.events.TransferEventInstance
import io.fenelabs.ethereumkit.contracts.ContractEventInstance
import io.fenelabs.ethereumkit.core.hexStringToByteArrayOrNull
import io.fenelabs.ethereumkit.core.toRawHexString
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.TransactionLog
import java.math.BigInteger

fun TransactionLog.getErc20EventInstance(): ContractEventInstance? {
    return try {
        if (topics.size != 3) {
            return null
        }

        val signature = topics[0].hexStringToByteArrayOrNull()

        val firstParam = Address(topics[1])
        val secondParam = Address(topics[2])

        when {
            signature.contentEquals(TransferEventInstance.signature) ->
                TransferEventInstance(address, firstParam, secondParam, BigInteger(data.toRawHexString(), 16), null)
            signature.contentEquals(ApproveEip20Decoration.signature) ->
                ApproveEventInstance(address, firstParam, secondParam, BigInteger(data.toRawHexString(), 16))
            else ->
                null
        }
    } catch (error: Throwable) {
        error.printStackTrace()
        null
    }
}
