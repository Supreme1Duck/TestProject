package testapplication.domain

import io.reactivex.Single

interface RepositoryAdditionalData {

    fun getInfo(): Single<String>

    fun getCount(): Single<Int>

}