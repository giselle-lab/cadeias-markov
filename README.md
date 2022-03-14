# Jogo de Tênis

O programa simula partidas de tênis representando o jogo por meio de _Cadeias de Markov_. 

  -A primeira partida é simulada 30 vezes e nessa partida a probabilidade do jogador A vencer um ponto é p, sendo que p é um número aleatório entre 0,7 e 0,8. E a probabilidade do   jogador B vencer um ponto é q = 1 - p.
  
  -A segunda partida também é simulada 30 vezes e nessa partida a probabilidade do jogador A vencer um ponto é p, sendo que p é um número aleatório entre 0,45 e 0,55. E a probabilidade do jogador B vencer um ponto é q = 1 - p.

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
Para testar basta executar o programa, e os arquivos de log/dataset serão criados em uma pasta GeradosAgora. Cada arquivo tem um nome padrão Partida"_número da partida_"_Simu"_número da simulação_".txt e também nessa pasta temos o arquivo txt de estatísticas gerais que contém a quatidade de partidas vencidas por cada jogador, o placar de cada partida, assim como o placar de cada set de cada partida. Os logs/datasets usados para fazer as anaálises se econtram na pasta Test. 

Legenda:

Pontuação do Game: Significa quantos pontos cada jogador fez no Game.

Placar de Games: Significa quantos Games cada jogador ganhou no Set.

Placar de Sets: Significa quantos Sets cada jogador ganhou na Partida.

Placar de Sets Final: Significa o placar final da Partida, mostrando qual jogador ganhou quantos Sets.

## Apresentação e Análise
O vídeo de apresentação se encontra disónível [neste link]().

O relatório de análise se encontra disponível [neste link](https://docs.google.com/document/d/18jU4jgHwZAC3uNRPuKMFLMhoqvtz9O-rvna3OdfHtH8/edit?usp=sharing). 
