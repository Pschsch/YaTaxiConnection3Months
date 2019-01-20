package ru.pschsch.pschschapps.yataxiconnection3months.DaggerClasses;

import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpPresenter;

import dagger.Component;
import ru.pschsch.pschschapps.yataxiconnection3months.Presenter.RegistrationPresenter;
import ru.pschsch.pschschapps.yataxiconnection3months.View.MainActivity;
/**Dagger генерирует класс, имплементирующий этот интерфейс, который и будет классом компонента
 *В аннотации Component передаются классы модулей, если их несколько, в которых компонент
 * будет искать объекты.
 *После билда сгенерировался класс DaggerAppComponent, который и позволяет внедрять зависимости
 * в Activity.
 * Есть два способа получать объекты из компонента: 1-й: обычные геттеры, но нам нужно прописать
 * геттеры для каждого объекта и прописывать их в Activity. Это не удобно, поэтому используются
 * inject-методы: с помощью него, компонент сам внедрит все нужные поля в Activity(которые поме-
 * чены как Inject)*/
@Component(modules = DependencyModule.class)
public interface AppComponent {
    void injectToPresenter(RegistrationPresenter presenter);
}
