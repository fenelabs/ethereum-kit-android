package io.fenelabs.ethereumkit.api.storage

import androidx.room.*
import io.fenelabs.ethereumkit.api.models.AccountState

@Dao
interface AccountStateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(accountState: AccountState)

    @Query("SELECT * FROM AccountState LIMIT 1")
    fun getAccountState(): AccountState?

}
