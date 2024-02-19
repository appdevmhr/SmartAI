package app.dev.mahmudul.hasan.smartai.di

import app.dev.mahmudul.hasan.smartai.features.course.home.data.CourseHomeRepositoryImpl
import app.dev.mahmudul.hasan.smartai.features.course.home.domain.CourseHomeRepository
import app.dev.mahmudul.hasan.smartai.features.course.home.ui.CourseHomeViewModel
import app.dev.mahmudul.hasan.smartai.features.signin.data.SignInRepositoryImpl
import app.dev.mahmudul.hasan.smartai.features.signin.data.SignInUseCase
import app.dev.mahmudul.hasan.smartai.features.signin.domain.SignInRepository
import app.dev.mahmudul.hasan.smartai.features.signin.ui.SignInViewModel
import app.dev.mahmudul.hasan.smartai.features.signup.data.SignUpRepositoryImpl
import app.dev.mahmudul.hasan.smartai.features.signup.domain.SignUpRepository
import app.dev.mahmudul.hasan.smartai.features.signup.ui.SignUpViewModel
import app.dev.mahmudul.hasan.smartai.features.student.home.data.StudentHomeRepositoryImpl
import app.dev.mahmudul.hasan.smartai.features.student.home.domain.StudentHomeRepository
import app.dev.mahmudul.hasan.smartai.features.student.home.ui.StudentHomeViewModel
import app.dev.mahmudul.hasan.smartai.features.student.profile.data.StudentProfileRepositoryImpl
import app.dev.mahmudul.hasan.smartai.features.student.profile.domain.StudentProfileRepository
import app.dev.mahmudul.hasan.smartai.features.student.profile.ui.StudentProfileViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    single(createdAtStart = true) { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single  { SignInUseCase(get())}
    single<SignInRepository> { SignInRepositoryImpl(get(), get()) }
    viewModel {
        SignInViewModel(get(), get())
    }
    single<SignUpRepository> { SignUpRepositoryImpl(get(), get()) }
    viewModel {
        SignUpViewModel(get())
    }
    single<StudentHomeRepository> { StudentHomeRepositoryImpl(get(),get()) }
    viewModel {
        StudentHomeViewModel(get(), get())
    }

    single <StudentProfileRepository>{ StudentProfileRepositoryImpl(get(),get()) }
    viewModel {
        StudentProfileViewModel(get(),get(),get())
    }
    single<CourseHomeRepository> { CourseHomeRepositoryImpl(get()) }
    viewModel {
        CourseHomeViewModel(get(),get())
    }

}
