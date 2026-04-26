TRABALHO DE IPOO - PRIMEIRA ENTREGA

Nome do jogo: Royale Run


Integrantes do grupo:

Lucas Oliveira Rodrigues

Matheus Botelho Pereira

Willian Custodio de Oliveira


REQUISITOS DE JOGABILIDADE

J4.1 Deve existir um mundo, que podemos chamar de tela inicial, que mostra o nome do jogo e instruções de como jogar.
R.: Sim. Foi criado um mundo chamado TelaInicial, além de outro mundo chamado Instruções, onde ficam as normas e orientações do jogo.

J4.2 Deve existir um mundo que é a primeira fase do jogo.
R.: Sim. Existe o mundo correspondente à primeira fase.

J4.3 Deve ser possível terminar o jogo com vitória ou derrota, e isso deve ser informado de alguma forma ao jogador.
R.: Sim. Há um mundo para representar o Game Over (derrota) e outro chamado Tela Vitória (vitória).

J4.4 Deve existir um ator que é controlado pelo jogador.
R.: Sim. O ator controlado é o Goblin.

J4.5 Devem existir pelo menos dois tipos de atores que representem inimigos que precisem ser atacados ou evitados.
R.: Sim. Existem os Bárbaros (que podem ser mortos e ameaçam o jogador) e as Princesas (que disparam projéteis que devem ser evitados).

J4.6 Deve existir pelo menos um tipo de ator que represente um item que o jogador poderá coletar no jogo.
R.: Sim. As Coroas são os itens que o jogador precisa coletar para avançar para a próxima fase.

J4.7 Deve existir pelo menos um tipo de ator que represente um obstáculo para o jogador.
R.: Sim. O Rio, que só pode ser atravessado pelas pontes, e as Vinhas, que impedem a movimentação do jogador.

J4.8 Deve existir alguma forma de pontuação, e deve ser possível que o jogador vença o jogo com diferentes pontuações. A pontuação deve aparecer na tela do jogo durante toda a partida.
R.: Sim. A pontuação fica visível durante toda a partida, e é possível vencer o jogo coletando diferentes quantidades de coroas.

J4.9 O jogo deve ter efeitos sonoros e deve usar, pelo menos, três arquivos de áudio diferentes.
R.: Sim. O jogo utiliza mais de três efeitos sonoros distintos.

J4.10 O jogo deve ter som de fundo (pelo menos um).
R.: Sim. O jogo possui trilhas de fundo em mais de um momento.

REQUISITOS DE IMPLEMENTAÇÃO

I4.1 O trabalho deve usar corretamente os conceitos de Classes, Objetos e Encapsulamento.
R.: Sim. Criamos classes para cada ator e mundo, mantendo os dados importantes encapsulados com métodos de acesso quando necessário.

I4.2 O trabalho deve usar corretamente os conceitos de Abstração e Modularização.
R.: Sim. Cada função tem responsabilidade clara: movimentação, ataque, colisão ou coleta, o que deixa o código organizado e fácil de entender.

I4.3 O trabalho deve usar corretamente os conceitos de atributos, variáveis locais e parâmetros.
R.: Sim. Atribuímos informações importantes aos atributos, usamos variáveis locais para cálculos temporários e passamos dados por parâmetros quando preciso.

I4.4 O trabalho deve usar corretamente os conceitos de atributos e métodos estáticos.
R.: Sim. Utilizamos atributos e métodos estáticos em pontos que precisam ser compartilhados, como a pontuação total do jogador.

I4.5 O trabalho deve ser implementado com bom design de classes: baixo acoplamento, alta coesão (não ter replicação de código), com design baseado em responsabilidade e sem acoplamento implícito.
R.: Sim. Cada classe faz apenas o que precisa, sem depender de outras desnecessariamente, evitando repetir código.

I4.6 O código deve estar legível, organizado e comentado.
R.: Sim. Escrevemos o código de forma clara, comentando as partes importantes e mantendo identação consistente para facilitar a leitura.

I4.7 A implementação deve, necessariamente, utilizar o Greenfoot versão 3.9.0 (veja ANEXO A2).
R.: Sim. Todo o projeto foi desenvolvido e testado no Greenfoot 3.9.0.

I4.8 O código entregue deve estar compilando. Caso ocorram erros de compilação, o trabalho não será corrigido e a nota será zero.
R.: Sim. O código está compilando sem problemas e todos os mundos e atores funcionam corretamente.

I4.9 Não é permitido o uso de funções lambda e técnicas de programação funcional da linguagem Java (ex.:, operador ->, lista.forEach(...), stream(), filter(), etc.).
R.: Sim. Todo o código foi feito usando apenas programação orientada a objetos tradicional, sem recursos extras.

COMENTÁRIOS (OPCIONAIS)

Algum comentário sobre o tema do trabalho?
R.: Todos os desenhos e elementos visuais foram feitos por nós, sem a utilização de IA. Acreditamos que isso mostra o esforço do grupo e gostaríamos que fosse considerado na avaliação.

Algum comentário sobre o Greenfoot?
R.: 