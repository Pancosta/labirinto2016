# █ THE MAZE █

**The Maze** é um jogo de labirinto desenvolvido em Java. Originalmente criado em 2016 como um projeto acadêmico para a disciplina de Lógica de Programação e Estrutura de Dados do IFPE, o código foi modernizado para utilizar Programação Orientada a Objetos (POO) e uma interface gráfica simples (Swing) com leitura direta do teclado.

O objetivo é simples: guiar o personagem (`ツ`) pelo labirinto escuro até a saída (`✩`), desviando de armadilhas invisíveis que punem o jogador mandando-o de volta ao início.

## 🎮 Controles
* **W** - Cima
* **S** - Baixo
* **A** - Esquerda
* **D** - Direita

*Nota: Ao abrir o jogo, clique na janela do labirinto para que ela reconheça as teclas.*

## ⚙️ Pré-requisitos
* Java Development Kit (JDK 8 ou superior) instalado.
* Terminal (Linux/Mac) ou PowerShell/CMD (Windows).

## 🚀 Como compilar e executar em casa

1. Clone o repositório ou baixe os arquivos.
2. Abra o terminal e navegue até a pasta principal do projeto (onde está localizada a pasta `projetoifpe`).
3. Compile o código forçando a codificação UTF-8 (necessário para renderizar os caracteres do mapa corretamente):
`javac -encoding UTF-8 projetoifpe/*.java`

4. Inicie o jogo:
`java -cp . projetoifpe.Principal`

## 🏆 Ranking e Fases
O projeto original conta com duas fases desafiadoras. O sistema avalia a sua eficiência: quanto menos passos você der para finalizar a fase, maior será a sua nota (Rank S, C ou F). 

## 👥 Autores
* Maria Eduarda
* Gustavo Dantas