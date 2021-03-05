package com.vietth.gapo.domain.news.model

enum class NewsType {

    OVER_VIEW {
        override val type: String
            get() = "overview"
    },
    STORY {
        override val type: String
            get() = "story"
    },
    GALLERY {
        override val type: String
            get() = "gallery"
    },
    VIDEO {
        override val type: String
            get() = "video"
    },
    ARTICLE {
        override val type: String
            get() = "article"
    },
    LONG_FORM {
        override val type: String
            get() = "long_form"
    };

    abstract val type: String

    companion object {
        fun getByType(type: String) = values().find { type == it.type } ?: OVER_VIEW
    }
}