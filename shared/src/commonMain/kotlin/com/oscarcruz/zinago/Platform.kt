package com.oscarcruz.zinago

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform