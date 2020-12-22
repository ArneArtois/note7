package com.lora.firebase

class Information {
    var email: String? = null
    var name: String? = null

    constructor() {}
    constructor(email: String?, name: String?) {
        this.email = email
        this.name = name
    }

}