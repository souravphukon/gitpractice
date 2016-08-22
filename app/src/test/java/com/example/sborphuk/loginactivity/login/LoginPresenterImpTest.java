package com.example.sborphuk.loginactivity.login;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by sborphuk on 8/17/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterImpTest
    {
        @Mock
        private LoginPresenterImp presenter;
        @Mock
        private LoginView view;
        @Before
        public void setUp() throws Exception
            {
                presenter=new LoginPresenterImp(view);
            }

        @Test
        public void shouldShowErrorMsgWhenUserNameIsEmpty() throws Exception
            {

               // when(view.)
            }
    }