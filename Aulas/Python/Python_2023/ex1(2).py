clientes = []

while True:
  opcao = input("O que você deseja fazer?\n(C)cadastrar cliente\n(E)exibir clientes\n(S)sair\n")

  if opcao == "c":
    nome = input("Digite o nome do cliente: ")
    idade = int(input("Digite a idade do cliente: "))
    profissao = input("Digite a profissão do cliente: ")
    salario = float(input("Digite o salário do cliente: "))
    cliente = {"nome": nome, "idade": idade, "profissao": profissao, "salario": salario}
    contas = []

    tem_conta = input("O cliente tem conta bancária? (s/n) ")
    while tem_conta == "s":
      banco = input("Digite o banco da conta: ")
      agencia = input("Digite a agência da conta: ")
      numero = input("Digite o número da conta: ")
      conta = {"banco": banco, "agencia": agencia, "numero": numero}
      contas.append(conta)
      tem_conta = input("O cliente tem mais alguma conta bancária? (s/n) ")

    cliente["contas"] = contas
    clientes.append(cliente)

  elif opcao == "e":
    for cliente in clientes:
      print("Nome:", cliente["nome"])
      print("Idade:", cliente["idade"])
      print("Profissão:", cliente["profissao"])
      print("Salário:", cliente["salario"])
      if len(cliente["contas"]) > 0:
        print("Contas bancárias:")
        for conta in cliente["contas"]:
          print(" - Banco:", conta["banco"])
          print(" - Agência:", conta["agencia"])
          print(" - Número:", conta["numero"])
      print()

  elif opcao == "s":
    break