# multi-datasources-demo

Модульный Spring-based монолит состоит из first-module и second-module.
У каждого из них - свой datasource и свои liquibase миграции.

У каждого модуля есть собственная мета-аннотация над @Transactional c прописанным дефолтным transactionManager.
В остальном мета-аннотация должна работать идентично оригиналу.

Параметры hibernate прописывать в бин *EntityManagerFactoryBuilder.
