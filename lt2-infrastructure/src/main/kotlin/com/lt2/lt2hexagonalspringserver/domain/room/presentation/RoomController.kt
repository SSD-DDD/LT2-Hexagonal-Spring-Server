package com.lt2.lt2hexagonalspringserver.domain.room.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rooms")
@RestController
class RoomController {

    @GetMapping
    fun getRoomList() {

    }
}