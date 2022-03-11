# cadeias-markov

O programa simula partidas de tênis representando o jogo por meio de Cadeias de Markov. 

  -A primeira partida é simulada 30 vezes e nessa partida a probabilidade do jogador A vencer um ponto é p, sendo que p é um número aleatório entre 0,7 e 0,8. E a probabilidade do   jogador B vencer um ponto é q = 1 - p.
  
  -A segunda partida também é simulada 30 vezes e nessa partida a probabilidade do jogador A vencer um ponto é p, sendo que p é um número aleatório entre 0,45 e 0,55. E a probabilidade do jogador B vencer um ponto é q = 1 - p.
  
##Como Usar

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

Para testar basta executar o programa, e os arquivos de log/dataset serão criados em uma pasta test. Cada arquivo tem um nome padrão Partida#número da partida_Simu_#número da simulação.txt e também nessa pasta temos o arquivo txt de estatísticas gerais que contém a quatidade de partidas vencidas por cada jogador, o placar de cada partida, assim como o placar de cada set de cada partida.
