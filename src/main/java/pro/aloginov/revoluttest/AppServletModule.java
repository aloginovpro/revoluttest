package pro.aloginov.revoluttest;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import pro.aloginov.revoluttest.exception.AppExceptionMapper;

public class AppServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(UserController.class);
        bind(AccountController.class);
        bind(TransferController.class);
        bind(AppExceptionMapper.class);
        serve("/*").with(GuiceContainer.class);
    }
}
