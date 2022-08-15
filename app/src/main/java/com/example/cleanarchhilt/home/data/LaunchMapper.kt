package com.example.cleanarchhilt.home.data

import com.example.cleanarchhilt.home.data.model.CompanyDetailDto
import com.example.cleanarchhilt.home.data.model.HeadquartersDto
import com.example.cleanarchhilt.home.data.model.LaunchDto
import com.example.cleanarchhilt.home.data.model.LinksDto
import com.example.cleanarchhilt.home.domain.model.CompanyDetail
import com.example.cleanarchhilt.home.domain.model.Headquarters
import com.example.cleanarchhilt.home.domain.model.Launch
import com.example.cleanarchhilt.home.domain.model.Links

object LaunchMapper {
    fun mapToCompanyDetail(companyDetailDto: CompanyDetailDto) = companyDetailDto.run {
        CompanyDetail(
            name = this.name,
            founder = this.founder,
            founded = this.founded,
            employees = this.employees,
            valuation = this.valuation,
            headquarters = getHeadquarters(this.headquarters),
        )
    }

    private fun getHeadquarters(headquartersDto: HeadquartersDto?) = headquartersDto?.run {
        Headquarters(
            address = this.address,
            city = this.city,
            state = this.state,
        )
    }

    fun mapToLaunches(launchesDto: List<LaunchDto>) = launchesDto.map {
        Launch(
            mission_name = it.mission_name,
            launch_success = it.launch_success,
            launch_year = it.launch_year,
            links = getLinks(it.links),
            launch_date_local = it.launch_date_local,
        )
    }

    private fun getLinks(linksDto: LinksDto?) = linksDto?.run {
        Links(
            article_link = linksDto.article_link,
            video_link = linksDto.video_link,
            wikipedia = linksDto.wikipedia,
            youtube_id = linksDto.youtube_id,
        )
    }
}