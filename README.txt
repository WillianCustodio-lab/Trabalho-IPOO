# 🏰 Jogo em Greenfoot — Sistema de Fases com Progressão e Boss

## 📌 Visão Geral

Projeto desenvolvido em Java utilizando o Greenfoot, com foco em organização orientada a objetos, reutilização de código e separação de responsabilidades.

O jogo possui múltiplas fases progressivas, sistema de itens, inimigos, mecânicas especiais (gelo, buffs) e uma batalha contra chefe (Mega Cavaleiro).

---

## 🎮 Estrutura do Jogo

### 🔹 Fases

* **Fase 1**

  * Introdução ao jogo
  * Coleta de coroas para liberar a saída
  * Inimigos básicos (bárbaros)

* **Fase 2**

  * Introdução de mecânicas:

    * Gelo (reduz velocidade)
    * Elixir Negro (buff de velocidade)
    * Chave (necessária para escapar)
  * Maior complexidade de interação

* **Fase 3**

  * Boss: **Mega Cavaleiro**
  * Sistema de ataque com área (SombraLuva)
  * Vitória depende de:

    * derrotar o chefe
    * coletar chave

---

## 🧱 Arquitetura

### 🔸 Classe base das fases

`FaseBase`

* Controla:

  * pontuação
  * derrota
  * vitória
  * geração de posições livres
* Permite reutilização entre todas as fases

---

### 🔸 Jogador

`JogadorBase`

* Movimento
* Animação por direção
* Sistema de tiro
* Colisão com itens e inimigos

Extensões:

* `JogadorFase2`
* `JogadorFase3`

Adicionam:

* velocidade temporária
* interação com gelo
* coleta de chave

---

### 🔸 Sistema de Itens

Classe base:

* `ItemBase`

Itens:

* `ItemCoroa` → adiciona pontos
* `ItemChave` → libera saída
* `ElixirNegro` → buff de velocidade

---

### 🔸 Sistema de Spawn

Base:

* `GeradorItemBase`

Implementações:

* `GeradorCoroa`
* `GeradorChave`
* `GeradorElixirNegro`

Controle:

* intervalo de spawn
* flags para evitar duplicação

---

### 🔸 Inimigos

* `InimigoTorre` → base para inimigos que disparam projéteis
* `TiroTorre` → projétil que derrota o jogador

---

### 🔸 Boss

`MegaCavaleiro`

* Sistema de vida
* Animação de ataque
* Cooldown
* Ataques direcionados ou aleatórios
* Integração com barra de vida (`BarraVidaMega`)

---

### 🔸 Objetos do cenário

* `TorreRei`

  * Controla abertura da saída
  * Detecta proximidade do jogador
  * Dispara condição de vitória

---

## ⚙️ Principais Mecânicas

* Sistema de pontuação global
* Liberação progressiva da saída
* Buff temporário com duração controlada por frames
* Interação com terreno (gelo)
* Sistema de spawn controlado
* Boss com comportamento semi-aleatório
* Transição entre fases com tela de vitória

---

## 🧠 Conceitos aplicados

* Herança (`FaseBase`, `JogadorBase`, `ItemBase`)
* Polimorfismo (métodos sobrescritos por fase)
* Encapsulamento (controle interno de estados)
* Separação de responsabilidades
* Baixo acoplamento entre sistemas principais
* Reutilização de código

---

## ⚠️ Desafios Técnicos

* Sincronização de animações com lógica de ataque
* Controle de estados (vida, buffs, chave)
* Evitar duplicação de itens com flags estáticas
* Integração entre jogador, fase e itens
* Gerenciamento de múltiplas fases sem acoplamento direto
* Atualização da interface (barra de vida)

---

## 🚀 Possíveis melhorias

* Sistema de HUD mais robusto
* Refatoração para reduzir uso de variáveis estáticas
* Melhor desacoplamento entre fases e lógica de vitória
* Sistema de eventos (observer) para comunicação entre classes
* Persistência de dados (pontuação/tempo)

---

## ▶️ Como executar

1. Abrir o projeto no Greenfoot
2. Executar o cenário inicial
3. Utilizar:

   * **W A S D** → movimento
   * **Espaço** → ataque

---

## 👤 Autor

Projeto desenvolvido como parte de estudo em:

* Programação Orientada a Objetos (Java)
* Estruturas de jogo em Greenfoot
* Organização de sistemas interativos

---

## 📎 Observação

O foco principal do projeto não é apenas o jogo em si, mas a construção de uma arquitetura sólida e evolutiva ao longo das fases.
