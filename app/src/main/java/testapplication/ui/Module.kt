package testapplication.ui

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import testapplication.data.mock.RepositoryImpl
import testapplication.domain.CreateDocumentUseCase
import testapplication.domain.GetAdditionalInfo

val repositoryModule = module {
    single { RepositoryImpl() }
}

val appModule = module {
    single { CreateDocumentUseCase(get()) }
    single { GetAdditionalInfo(get()) }
}

val viewModule = module {
    viewModel {
        MyViewModel(get(), get())
    }
}