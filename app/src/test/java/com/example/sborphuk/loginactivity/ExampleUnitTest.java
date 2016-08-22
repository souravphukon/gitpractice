package com.example.sborphuk.loginactivity;

import com.example.sborphuk.loginactivity.login.LoginPresenterImp;
import com.example.sborphuk.loginactivity.login.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest
    {
       @Mock
        private LoginPresenterImp presenter;
        @Mock
        private LoginView view;
        @Before
        public void setUp() throws Exception
            {
                presenter=new LoginPresenterImp( view );
            }

        @Test
        public void shouldShowErrorMsgWhenUserNameIsEmpty() throws Exception
            {

            }
        /*@Test
        public void addition_isCorrect() throws Exception
            {
                assertEquals(4, 2 + 2);
            }*/
    }