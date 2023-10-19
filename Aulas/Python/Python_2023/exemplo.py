# Aula Dicinários

dados = []

while True:
    nome = input("Digite o nome: ")
    idade = int(input("Digite a idade: "))
    salario = float(input("Digite o salário: "))


    pessoa = {"nome": nome, "idade": idade, "salario": salario}


    dados.append(pessoa)
    continuar = input("Deseja continuar? (S/N) ")
    if continuar.upper() == "N":
        break


for pessoa in dados:
    print(f"Nome: {pessoa['nome']} | Idade: {pessoa['idade']} | Salário: {pessoa['salario']}")