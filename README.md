# Jogo de Tênis

O programa simula partidas de tênis representando o jogo por meio de _Cadeias de Markov_. 

  -A primeira partida é simulada 30 vezes e nessa partida a probabilidade do jogador A vencer um ponto é p = 0,76. E a probabilidade do jogador B vencer um ponto é q = 1 - p = 0,24.
  
  -A segunda partida também é simulada 30 vezes e nessa partida a probabilidade do jogador A vencer um ponto é p = 0,53. E a probabilidade do jogador B vencer um ponto é q = 1 - p = 0,47.

## Instalação
Para executar o programa é necessário que o Java esteja intalado.Instale o java para [Windows](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR) ou para [Linux](https://www.java.com/pt-BR/download/). Siga as intruções dadas nos link de instalação e já poderá seguir para execução do programa.

Se você já tiver o Java instalado então pode pular essa parte e seguir para Como Usar.


## Como Usar

Para compilar: 
```bash
make
```
Para executar: 
```bash
make run
```
Para limpar: 
```bash
make clean
```
## Logs
Para testar basta executar o programa, e os arquivos de log/dataset serão criados em uma pasta Test. Cada arquivo tem um nome padrão Partida"_número da partida_"_Simu"_número da simulação_".txt e também nessa pasta temos o arquivo txt de estatísticas gerais que contém a quatidade de partidas vencidas por cada jogador, o placar de cada partida, o placar de cada set de cada partida, além de conter o total de pontos feitos por cada jogadpr em cada set e o total de pontos feitos por cada jogador na partida inteira e por fim o total de pontos conjuntos da partida. Os logs/datasets usados para fazer as anaálises se econtram na pasta Test. 

Legenda:

Pontuação do Game: Significa quantos pontos cada jogador fez no Game.

Placar de Games: Significa quantos Games cada jogador ganhou no Set.

Placar de Sets: Significa quantos Sets cada jogador ganhou na Partida.

Placar de Sets Final: Significa o placar final da Partida, mostrando qual jogador ganhou quantos Sets.

## Apresentação e Análise
O vídeo de apresentação se encontra disónível em dois links [parte 1](https://drive.google.com/file/d/1xutQYID5gJNGXzotmlhUG2csjuRne8y1/view?usp=sharing) e [parte 2](https://www.loom.com/share/893912bcda5c4c208ba3277ccd27fd6d).

O relatório de análise se encontra neste repositório.
