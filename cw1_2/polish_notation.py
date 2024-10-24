def Calculation(symbol, number1, number2):
  if symbol == '+':
      return number1 + number2
  elif symbol == '-':
      return number1 - number2
  elif symbol == '*':
      return number1 * number2
  elif symbol == '/':
      if number2 == 0:
          return None
      return int(number1 / number2)


def evaluatePNExpression(tokens):
  Numbers= []
  for token in reversed(tokens):
      if (token.isdigit() or (token[0] == '-' and token[1:].isdigit())) and abs(int(token)) <= 300:
        Numbers.append(int(token))
      elif token == '+' or token == '-' or token =='*' or token == '/':
          if len(Numbers) < 2:
              return None
          number1 = Numbers.pop()
          number2 = Numbers.pop()
          result = Calculation(token, number1, number2)
          if result is None:
              return None  
          Numbers.append(result)
      else:
          return None  
  if len(Numbers) == 1:
      return Numbers[0]
  else:
      return None


# Example usage:
expression1 = ["/", "-288", "2"] #-144
expression2 = ["*", "-" ,"+", "3", "3", "-10", "4"] #64
expression3 = ["/", "+", "200", "-50", "3"] #50
expression4 = ["*", "-", "100", "50", "+", "10", "20"] #1500
expression5 = ["/", "300", "3"] #100
expression6 = ["+", "*", "2", "/", "100", "5", "-", "60", "20"] #80
expression7 = ["/", "100", "0"] #None
expression8 = ["/", "309", "3"] #None

result1 = evaluatePNExpression(expression1)
result2 = evaluatePNExpression(expression2)
result3 = evaluatePNExpression(expression3)
result4 = evaluatePNExpression(expression4)
result5 = evaluatePNExpression(expression5)
result6 = evaluatePNExpression(expression6)
result7 = evaluatePNExpression(expression7)
result8 = evaluatePNExpression(expression8)

print("Output for expression 1:", result1)
print("Output for expression 2:", result2)
print("Output for expression 3:", result3)
print("Output for expression 4:", result4)
print("Output for expression 5:", result5)
print("Output for expression 6:", result6)
print("Output for expression 7:", result7)
print("Output for expression 8:", result8)





