def check_parens(s):
    stack = []
    for char in s:
        if char == '(':
            stack.append(char)
        elif char == ')':
            if not stack or stack.pop() != '(':
                return False
    return not stack

# Пример использования
print(check_parens("((()))"))  # True
print(check_parens("()()()"))  # True
print(check_parens("(()))"))   # False
