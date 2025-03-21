package io.fenelabs.nftkit.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import io.fenelabs.ethereumkit.core.toHexString
import io.fenelabs.ethereumkit.models.Address
import java.math.BigInteger

@Entity
data class Eip1155Event(
    val hash: ByteArray,
    val blockNumber: Long,
    val contractAddress: Address,
    val from: Address,
    val to: Address,
    val tokenId: BigInteger,
    val tokenValue: Int,
    val tokenName: String,
    val tokenSymbol: String,

    @PrimaryKey(autoGenerate = true) val id: Long = 0
) {

    @delegate:Ignore
    val hashString: String by lazy {
        hash.toHexString()
    }

}
