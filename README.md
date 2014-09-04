Conference Track Management
===========================

Aplicação construída a partir do gradle-testng-mockito-bootstrap - https://github.com/miguno/gradle-testng-mockito-bootstrap/blob/master/build.gradle .

Algorítmo para ordenar as talks é bem simples e infelizmente não atende todos os casos de alocação de talks, porém é robusto o suficiente para identificar seus próprios defeitos. Ele parte do princípio de que as maiores talks devem ser alocadas primeiramente.

Dependências
============
* Java 1.6
* Gradle 

Como executar
=============
gradle execConference -Pinput=<arquiv_de_entrada>

Como rodar os testes
====================
* Comand line:
  $gradle test
  Veja o resultado em build/reports/tests/index.html

