package testapplication.ui

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import testapplication.data.mock.RepositoryImpl
import testapplication.domain.CreateDocumentUseCase
import testapplication.domain.GetAdditionalInfo
import testapplication.domain.ICreateDocumentUseCase
import testapplication.domain.IGetAdditionalInfo

val repositoryModule = module {
    single { RepositoryImpl() }
}

val appModule = module {
    single<ICreateDocumentUseCase> { CreateDocumentUseCase(RepositoryImpl()) }
    single<IGetAdditionalInfo> { GetAdditionalInfo(RepositoryImpl()) }
}

val viewModule = module {
    viewModel {
        MyViewModel(get(), get())
    }
}