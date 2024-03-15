<br>

## 📌Sobre

![LOGO_LETWE](https://letwe.com.br/wp-content/uploads/2022/08/LOGO_LETWE-OFICIAL.svg)

<div align="center">
    <p>TESTE TÉCNICO LETWE</p>
</div>

## 📝Perguntas

**Teste Conceitual: Java, PrimeFaces, JSF, Hibernate, MySQL**

### Java Fundamentals:

a. Explique o conceito de polimorfismo em Java e forneça um exemplo prático.

```java
// Classe abstrata Animal
abstract class Animal {
    abstract void som();
}

// Classe Cachorro que herda de Animal
class Cachorro extends Animal {
    void som() {
        System.out.println("Au Au");
    }
}

// Classe Gato que herda de Animal
class Gato extends Animal {
    void som() {
        System.out.println("Miau");
    }
}

// Classe principal
public class Main { 
    public static void main(String[] args) {
        Animal meuCachorro = new Cachorro(); // Cachorro é um Animal
        Animal meuGato = new Gato(); // Gato é um Animal
        meuCachorro.som(); // Imprime "Au Au"
        meuGato.som(); // Imprime "Miau"
    }
}


b. Diferencie entre herança e composição em programação orientada a objetos.

Herança permite que uma classe herde os campos e métodos de outra classe. Por exemplo, um Cachorro é um Animal. 
Isso permite o reuso de código, mas pode levar a hierarquias de classes complexas e pode violar o princípio de encapsulamento se não for usado corretamente.

Composição é um mecanismo que permite que uma classe inclua instâncias de outras classes como campos.
Por exemplo, um Carro tem um Motor. A composição é geralmente mais flexível que a herança, pois permite mudar o comportamento em tempo de execução ao substituir partes (composições).

JSF (JavaServer Faces):
a. Qual é a finalidade principal do JSF em um aplicativo web Java?
O JSF é um framework web baseado em java e ele tem como objetivo principal facilitar o desenvolvimento de interfaces ou telas de sistemas para web, atraves de um modelo de componentes reutilizaveis.
b. Explique o ciclo de vida de um Managed Bean no contexto do JSF.
O ciclo de vida de um Managed Bean é composto por várias fases, desde a criação até a destruição do objeto.
A primeira fase é a inicialização, na qual o Managed Bean é instanciado e suas dependências são injetadas.
Em seguida, ocorre a fase de preparação, na qual o Managed Bean é configurado e seus atributos são inicializados.
Durante o ciclo de vida, a implementação JSF deve construir a “view” conhecida como árvore de componentes UI, enquanto considerar o estado salvo de uma submissão passada da página.
Quando o cliente submete uma página, a implementação JSF executa várias tarefas, como validações dos dados de entrada dos componentes na “view” e conversões de entrada de dados para tipos específicos do servidor.


PrimeFaces:
a. O que é o PrimeFaces e como ele se integra com o JSF?
O PrimeFaces é um framework que possui um conjunto de componentes que adicionam maior funcionalidade aos componentes padrões do JSF.
Por exemplo, no JSF temos o DataTable e no Primefaces também, porém o dataTable do Primefaces possui um maior número de funcionalidades que proporcionam facilidade e agilidade na construção de uma tabulação completa com pesquisa, paginação, ordenação, seleção e etc.

b. Dê um exemplo de um componente PrimeFaces e explique como ele pode ser usado para melhorar a interface do usuário em um aplicativo web.
Um exemplo de componente PrimeFaces é o Ribbon.
O Ribbon facilita a criação de barras de ferramentas, ele pode ser usado para melhorar a interface do usuário em um aplicativo web, fornecendo uma maneira intuitiva e eficiente de dar aos usuários acesso a várias funcionalidades e operações.

Hibernate:
a. Qual é o propósito do Hibernate em um projeto Java?
Hibernate é um framework de mapeamento objeto-relacional para aplicações Java.
O objetivo do Hibernate é diminuir a complexidade entre os sistemas Java, baseado no modelo orientado a objeto, que precisam trabalhar com um banco de dados do modelo relacional.
Ele simplifica a persistência de dados em um banco de dados, mapeando automaticamente objetos Java para tabelas de banco de dados e vice-versa.
A ideia por trás desse tipo de framework é que você possa persistir e consultar dados utilizando apenas classes e objetos Java, minimizando a necessidade de lidar diretamente com SQL.

b. Explique a diferença entre FetchType.LAZY e FetchType.EAGER em mapeamentos de entidades JPA com Hibernate. Indique, na sua opinião, qual deve-se usar de forma majoritária.

FetchType.EAGER: Esta estratégia carrega as entidades relacionadas imediatamente junto com a entidade pai.
Isso significa que, quando você carrega uma entidade, todas as suas entidades relacionadas também são carregadas na mesma consulta.
Isso pode ser útil quando você sabe que vai precisar das entidades relacionadas e quer evitar várias consultas ao banco de dados.
No entanto, isso pode levar a um grande volume de dados sendo carregado desnecessariamente, especialmente se a entidade pai tiver muitas entidades relacionadas.

FetchType.LAZY: Esta estratégia, por outro lado, carrega as entidades relacionadas sob demanda, ou seja, elas são carregadas apenas quando você acessa a associação.
Isso pode ser mais eficiente em termos de uso de memória e desempenho, pois evita o carregamento de grandes volumes de dados desnecessários.
No entanto, você deve estar ciente de que o carregamento preguiçoso requer que a sessão do Hibernate esteja aberta, o que pode não ser o caso se você estiver em um ambiente desconectado.

Na minha opinião, FetchType.LAZY deve ser usado de forma majoritária, pois ele permite um melhor uso da memória e do desempenho ao evitar o carregamento desnecessário de dados.
Porem, a escolha entre FetchType.LAZY e FetchType.EAGER deve ser feita com base nas necessidades específicas da aplicação e no entendimento do modelo de dados.


MySQL:
a. Descreva as diferenças entre os tipos de índices no MySQL (por exemplo, índice único, índice composto).

Índices B-Tree:Os índices B-Tree armazenam os dados de forma ordenada, o que permite que o MySQL realize buscas, inserções e exclusões de maneira eficiente.

Índices Hash:Os índices Hash são extremamente rápidos para consultas de igualdade, mas não são eficientes para consultas que envolvem intervalos de valores.

Índices Full-Text:Eles são projetados para melhorar a eficiência das buscas de texto.

Índices UNIQUE:Uma tabela pode conter múltiplos índices UNIQUE, mas no máximo uma PRIMARY KEY, um índice UNIQUE pode conter valores NULL, enquanto que uma PRIMARY KEY não.

Índices de agrupamento ou ordenados:Os dados são armazenados em uma página de dados, em ordem crescente.

Índice Único:Este tipo de índice garante que cada valor da chave seja diferente de todos os outros, a exceção é que valores NULL podem ocorrer múltiplas vezes, isso é apropriado para colunas que são sabidamente únicas, no MySQL, ALTER TABLE tabela ADD CONSTRAINT UNIQUE KEY é a mesma coisa que CREATE UNIQUE INDEX.

Índice Composto:Este tipo de índice é usado pelo MySQL para otimizar consultas para colunas utilizadas em cláusulas WHERE, ORDER BY, GROUP BY e MIN/MAX, um índice de três colunas (col1, col2, col3) pode ser usado para pesquisas em (col1), (col1, col2) e (col1, col2, col3) (a ordem não importa), no entanto, ele não pode ser usado para (col2), (col2, col3) ou (col3), se todos os campos selecionados em uma consulta são cobertos por um índice, o MySQL nunca precisa atingir o banco de dados e pode buscar os campos diretamente do índice.

b. Como você otimizaria uma consulta SQL para garantir um desempenho ideal em grandes conjuntos de dados?
Para garantir um desempenho ideal em grandes conjuntos de dados ao trabalhar com consultas SQL, eu adotaria as seguintes estratégias:

Índices: Os índices são nossos melhores amigos quando se trata de melhorar o desempenho das consultas. 
Eles podem acelerar significativamente as consultas, especialmente em grandes conjuntos de dados.
Portanto, é crucial garantir que as colunas mais consultadas estejam indexadas.
Minimizar o uso de Junções: As junções podem ser bastante caras em termos de desempenho, especialmente em grandes conjuntos de dados.
Se pudermos obter os dados necessários sem uma junção, isso geralmente será mais rápido.
Cláusula LIMIT: Se só precisamos de uma certa quantidade de linhas, usar a cláusula LIMIT pode evitar a leitura de linhas desnecessárias.
Evitar funções em colunas em cláusulas WHERE: Isso pode impedir que o MySQL use um índice, o que pode levar a um desempenho subótimo.
Uso moderado de consultas de agregação: Funções como COUNT, SUM, AVG, MAX e MIN podem ser caras em termos de desempenho em grandes conjuntos de dados.
Análise de Consultas: A cláusula EXPLAIN do MySQL é uma ferramenta poderosa que nos ajuda a entender como nossas consultas estão sendo executadas.
Isso pode nos ajudar a identificar onde as otimizações podem ser feitas.
Normalização de Dados: A normalização pode reduzir a redundância de dados e melhorar a eficiência das consultas.
