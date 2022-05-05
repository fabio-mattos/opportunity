
# Opportunity

O nome do projeto se deu em homenagem ao rôbo da Nasa enviado para Marte, mas se trata de um teste técnico feito para a Conta Azul.

## Requerimentos

Para buildar o projeto, você precisará de:

- [JDK 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Iniciar ambiente de desenvolvimento

Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método `main` na classe `com.fabiomattos.opportunity.OpportunityApplication` do seu IDE.

Alternativamente, você pode usar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html).
Basta rodar o comando abaixo no seu terminal:

```shell
mvn spring-boot:run
```

## Como utilizar

### Especificações
- O terreno que o robo pode andar, é uma matriz 5x5 onde não pode sair deste terreno (caso passe, retorna erro 400);
- Robo inicia na posição (0, 0, N) -> (eixo X, eixo y, direção);
- Não é persistido a ultima posição, logo a cada comando enviado ele faz o calculo a partir da posição inicial;
- A direção é formada por:  NORTH, SOUTH, EAST e WEST; 

### Calcular posição
Os comandos são formados por letras maiusculas que representam ações conforme a tabela:

- M -> Andar para frente;
- R -> Virar para direita;
- L -> Virar para esquerda;

Abaixo está um exemplo de um calculo de posição a partir de um comando "MML" 
```shel
curl -s --request POST http://localhost:8080/rest/mars/MML
```



