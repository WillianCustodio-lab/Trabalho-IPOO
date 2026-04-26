TRABALHO DE IPOO - ENTREGA FINAL
Nome do jogo: RoyaleRun
Integrantes do grupo: Matheus Botelho, Lucas Rodrigues, Willian Custódio
-
-
-
Escreva abaixo de cada Requisito se ele foi atendido no projeto ou não.
REQUISITOS DE JOGABILIDADE

J4.1 Deve existir um mundo, que podemos chamar de tela inicial, que mostra o nome do jogo e
instruções de como jogar.
R.: Sim, após abrir a tela inicial e clicar em start, aparece também as instruções de como jogar o jogo.

J4.2 Deve existir um mundo que é a primeira fase do jogo.
R.: Sim, existe uma primeira fase.

J4.3 Deve ser possível terminar o jogo com vitória ou derrota e isso deve ser informado de
alguma forma para o jogador.
R.: Sim, há uma tela para cada ocasião no jogo, uma para vitória e outra para derrota.

J4.4 Deve existir um ator que é controlado pelo jogador.
R.: Sim, o jogador principal (Goblin) é controlado pelo jogador em todas as fases.

J4.5 Devem existir pelo menos dois tipos de atores que representam inimigos que precisem ser
atacados ou evitados.
R.: Sim, em cada fase há no mínimo dois inimigos a serem evitados.
Primeira fase: Barbaro e princesa da torre.
Segunda fase: Barbaros, golem de gelo e o mago de gelo da torre.
Terceira fase: MegaCavaleiro(boss) e canhoneiro da torre.

J4.6 Deve existir pelo menos um tipo de ator que representa um item que o jogador poderá
coletar no jogo.
R.:Sim, no jogo há três itens coletaveis: coroa(incrementa pontuação), elixir(aumenta velocidade do jogador) e a chave(libera acesso a proxima fase).

J4.7 Deve existir pelo menos um tipo de ator que representa um obstáculo para o jogador.
R.: Sim, temos as vinhas na primeira fase, o gelo na segunda, a lápide na terceira.

J4.8 Deve existir alguma forma de pontuação e deve ser possível que o jogador vença o jogo com
diferentes pontuações. A pontuação deve aparecer na tela do jogo durante toda a partida.
R.:Sim, é possivel que o jogador alcance uma pontuação maior a cada coroa que ele coleta, independente se ele terminou a fase ou não.

J4.9 O jogo deve ter sons de efeitos sonoros e deve usar, pelo menos, três arquivos de áudio
diferentes.
R.:Sim, há diversos sons no jogo, para coleta de itens, sons dos inimigos, do jogador,etc.

J4.10 O jogo deve ter som de fundo (pelo menos um).
R.: Sim, tanto no menu e na arena de batalha temos trilha de fundo durante o jogo.

J5.1 A tela inicial feita na primeira entrega será dividida em dois mundos: tela inicial e tela
de instruções. Através da tela inicial deve ser possível disparar o início do jogo ou disparar
a tela com as instruções do jogo.
R.:Sim, após iniciar o jogo na telaInicial é possível abrir a tela de instruções

J5.2 Deve existir um mundo que é a segunda fase do jogo.
R.:Sim, há uma segunda fase.

J5.3 Deve existir um mundo que é a terceira fase do jogo e que tenha um ator que é o inimigo
final a ser derrotado (chefão).
R.:Sim, a terceira fase possui o MegaCavaleiro como chefão.

J5.4 Deve existir pelo menos mais um tipo de ator (além dos dois da primeira entrega) que
representam inimigos que precisem ser atacados ou evitados (sem contar o chefão).
R.:Foram adicionados o golem de gelo + inimigos diferentes nas torres(que possuem dinamicas diferentes de tiro).

J5.5 Deve existir pelo menos mais dois tipos de atores que representam itens que o jogador
poderá coletar no jogo (além do item da primeira entrega).
R.:Sim, foram adicionados a chave(libera acesso de fase) e o elixir(aumento de velocidade).

J5.6 Deve existir pelo menos mais um tipo de ator que representa um obstáculo para o jogador
(além do obstáculo da primeira entrega). Poderia ser, por exemplo, ser uma parede, uma pedra,
uma armadilha, etc.
R.:Sim, temos a dinamica do gelo, que ao derrotar um golem de gelo, é spawnado um obstaculo "Gelo" que diminui a velocidade do jogador ao passar sobre ele.

J5.7 O jogo deve usar pelo menos mais dois arquivos de áudio, além dos usados na primeira
entrega.
R.: Sim, foram adicionados novos sons de personagens, de ataque e coleta de itens.

J5.8 Deve existir um mundo que aparece ao final do jogo e que mostre se o jogador venceu ou
perdeu (vitória ou game over). Nele devem ser exibidos os pontos obtidos pelo jogador em cada
fase, e no total e o que tempo durou a partida. Deve ser possível reiniciar o jogo sem que o
usuário tenha que pressionar o botão “Executar” (ou “Run”) do Greenfoot.
R.:Sim, ao final de cada fase(independente se houve vitória ou derrota), o usuário é informado sobre sua pontuação e tempo de partida.

REQUISITOS DE IMPLEMENTAÇÃO

I4.1 O trabalho deve usar corretamente os conceitos de Classes, Objetos e Encapsulamento.
R.: Sim, todas as funcionalidades principais do jogo estão organizadas em classes específicas, com atributos privados e métodos de acesso quando necessário, garantindo o encapsulamento.

I4.2 O trabalho deve usar corretamente os conceitos de Abstração e Modularização.
R.: Sim, o código está modularizado com superclasses e subclasses que abstraem comportamentos comuns, como inimigos, itens e geradores.

I4.3 O trabalho deve usar corretamente os conceitos de atributos, variáveis locais e
parâmetros.
R.: Sim, os atributos são usados para armazenar o estado dos objetos, variáveis locais são utilizadas dentro dos métodos para cálculos temporários e parâmetros são passados corretamente entre métodos e construtores.

I4.4 O trabalho deve usar corretamente os conceitos de atributos e métodos estáticos.
R.: Sim, usamos métodos e atributos estáticos para variáveis compartilhadas entre o jogo, como o uso de PONTUACAONECESSARIA para designar o necessário para passar de certa fase.

I4.5 O trabalho deve ser implementado com bom design de classes: baixo acoplamento, alta coesão
(não ter replicação de código), com design baseado em responsabilidade e sem acoplamento
implícito.
R.:Sim, cada classe tem responsabilidades bem definidas, como geradores, inimigos, itens e controle de pontuação, evitando código duplicado e mantendo baixo acoplamento entre classes.

I4.6 O código deve estar legível, organizado e comentado.
R.:Sim, o código foi escrito de forma clara, com identação adequada e comentários explicando as funções de cada método e classe.

I4.7 A implementação deve, necessariamente, utilizar o Greenfoot versão 3.9.0 (veja ANEXO A2).
R.: Sim, o projeto foi desenvolvido e testado na versão 3.9.0 do Greenfoot.

I4.8 O código entregue deve estar compilando. Caso ocorram erros de compilação, o trabalho não
será corrigido e a nota será zero.
R.: Sim, todo o código está compilando e funcionando corretamente no Greenfoot.

I4.9 Não é permitido o uso de funções lambda e técnicas de programação funcional da linguagem
Java (ex.:, operador ->, lista.forEach(...), stream(), filter(), etc.).
R.: Sim, nenhuma função lambda ou técnica de programação funcional foi utilizada.

I5.1 A implementação do jogo deve utilizar algum tipo de coleção (ArrayList, HashMap, etc.)
Pode ser na implementação de algum ator ou mundo ou poderia ser para mostrar um histórico de
pontuação, por exemplo. A coleção utilizada precisa ter utilidade real no jogo.
R.: Sim, foram utilizados principalmente Arrays para controle de imagens durante as animações dos personagens e itens do jogo

I5.2 A implementação deve usar herança: devem existir pelo menos três superclasses criadas por
vocês (portanto, não contam as classes Actor e World), cujas subclasses tenham alguma
implementação útil.
R.:Sim, foram criadas várias superclasses, como exemplo temos: InimigoBase, ItemBase e GeradorItemBase, que são estendidas por várias subclasses específicas para cada inimigo, item ou gerador, aproveitando métodos e atributos comuns.

COMENTÁRIOS (OPCIONAIS)
Algum comentário sobre o tema do trabalho?
R.: Muito bacana a ideia, principalmente por podermos colocar nossa criatividade em prática, além das próprias aplicações de java, como um bom design de classe, que garante que o código não seja apenas funcional, mas também bem estruturado,
principalmente na transição da primeira entrega para a segunda, pude perceber como a ideia de herança é útil na perspectiva de expansão do código, garantindo reutilizações para futuras ideias e melhorias.

Algum comentário sobre o Greenfoot?