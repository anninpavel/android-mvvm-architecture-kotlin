/*
 * Copyright 2018 Pavel Annin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:JvmMultifileClass

package com.github.anninpavel.androidarchitecture.presentation.common

/** @author Pavel Annin (https://github.com/anninpavel). */
@Suppress(names = ["unused"])
sealed class Response<out T> {
    companion object
}

data class Success<out T>(val value: T) : Response<T>()

data class Failure<out T>(val error: Throwable) : Response<T>()

class Progress<out T> : Response<T>()

fun <T> Response.Companion.success(value: T) = Success(value)

fun <T> Response.Companion.failure(error: Throwable) = Failure<T>(error)

fun <T> Response.Companion.loading() = Progress<T>()