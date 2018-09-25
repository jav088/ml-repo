# ML - Challenge
Repositorio de ML- Challenge

API en Google App Engine: https://ml-challenge-217516.appspot.com

Precondiciones:
- La matriz ingresada deberá ser cuadrada y solo tener los siguientes caracteres A,T,C,G. Caso contrario no se guardara en la Base de Datos, se lanzara una exception y la API mostrara 403-Forbidden.
- Si se encuentran 5 caracteres iguales, solo se contara 1 combinacion, si se contaran 2 combinaciones si hay 8 caracteres iguales juntos.

Instrucciones para ejecutar el programa:
- En Eclipse, correr la clase  ar.com.ml.challenge.Application
- En Google App Engine, ir a https://ml-challenge-217516.appspot.com, tiene dos servicios https://ml-challenge-217516.appspot.com/mutant y https://ml-challenge-217516.appspot.com/stats.
- Tests en eclipse, ejecutar con JUnit el Test Suite ar.com.ml.challenge.ApplicationTestSuite
