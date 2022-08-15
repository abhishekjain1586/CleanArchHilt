package com.example.cleanarchhilt.home.domain.model

data class Launch(
    val mission_name: String?,
    val launch_success: Boolean?,
    val launch_year: String?,
    val links: Links?,
    val launch_date_local: String?,
)

data class Links(
    val article_link: String?,
    val video_link: String?,
    val wikipedia: String?,
    val youtube_id: String?,
)
