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
            .select { filter { eq("id", id) } }
            .decodeSingle()
    }

    suspend inline fun <reified T : Any> insert(t: T) {
        client.postgrest.from(TableNameGetter.get<T>())
            .insert(t)
    }

    suspend inline fun <reified T : Any> update(t: T) {
        client.postgrest.from(TableNameGetter.get<T>())
            .update(t)
    }

    suspend inline fun <reified T : Any> upsert(t: T) {
        client.postgrest.from(TableNameGetter.get<T>())
            .upsert(t)
    }

    suspend inline fun <reified T : Any> delete(id: Long) {
        client.postgrest.from(TableNameGetter.get<T>())
            .delete { filter { eq("id", id) } }
    }
}

