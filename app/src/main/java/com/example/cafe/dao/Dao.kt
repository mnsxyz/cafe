package com.example.cafe.dao

import com.example.cafe.BuildConfig
import com.example.cafe.util.TableNameGetter
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest

class Dao {
    val client = createSupabaseClient(
        supabaseUrl = BuildConfig.SUPA_URL,
        supabaseKey = BuildConfig.SUPA_KEY
    ) { install(Postgrest) }

    suspend inline fun <reified T : Any> findAll(): List<T> {
        return client.postgrest.from(TableNameGetter.get<T>())
            .select()
            .decodeList<T>()
    }

    suspend inline fun <reified T : Any> findOne(id: Long): T {
        return client.postgrest.from(TableNameGetter.get<T>())
            .select() {
                filter { eq("id", id) }
            }
            .decodeSingle()
    }
}

