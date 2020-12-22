package com.lora.firebase

import com.google.firebase.Timestamp

class Note {
    var text: String? = null
    var completed = false
    var created: Timestamp? = null
    var userId: String? = null

    constructor() {}
    constructor(
        text: String?,
        completed: Boolean,
        created: Timestamp?,
        userId: String?
    ) {
        this.text = text
        this.completed = completed
        this.created = created
        this.userId = userId
    }

    override fun toString(): String {
        return "Note{" +
                "text='" + text + '\'' +
                ", completed=" + completed +
                ", created=" + created +
                ", userId='" + userId + '\'' +
                '}'
    }
}