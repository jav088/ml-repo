package ar.com.ml.challenge;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ar.com.ml.challenge.controller.MlMutantControllerTest;
import ar.com.ml.challenge.service.MlServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ MlServiceTest.class, MlMutantControllerTest.class })

public class ApplicationTestSuite {

}
