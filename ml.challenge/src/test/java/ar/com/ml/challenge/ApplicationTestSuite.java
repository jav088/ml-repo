package ar.com.ml.challenge;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ar.com.ml.challenge.controller.MlMutantControllerTest;
import ar.com.ml.challenge.service.MlMutantServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ MlMutantServiceTest.class, MlMutantControllerTest.class })
public class ApplicationTestSuite {

}
