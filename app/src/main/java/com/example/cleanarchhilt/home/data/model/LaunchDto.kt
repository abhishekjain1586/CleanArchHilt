package com.example.cleanarchhilt.home.data.model

data class LaunchDto(
    val mission_name: String?,
    val launch_success: Boolean?,
    val launch_year: String?,
    val links: LinksDto?,
    val launch_date_local: String?,
)

data class LinksDto(
    val article_link: String?,
    val video_link: String?,
    val wikipedia: String?,
    val youtube_id: String?,
)