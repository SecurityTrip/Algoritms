import time


def fibonacci_iterative(n):
    fib_sequence = [0, 1]  # Начальные числа Фибоначчи
    for i in range(2, n): # O(n-2)
        fib_sequence.append(fib_sequence[-1] + fib_sequence[-2]) # O(m)
    return fib_sequence # т.к. длина чисел Фибоначчи растёт экспоненциально, то O(m) ≈ O(n) => O(n^2)


def fibonacci_recursive(n):
    if n <= 1:
        return n
    else:

        return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2)  # -> O(2^n * m), где m - кол-во рязрядов в числе



def generate_fibonacci_sequence_recursive(n):
    fib_sequence = []
    for i in range(n):
        fib_sequence.append(fibonacci_recursive(i))
    return fib_sequence


if __name__ == "__main__":
    print("Введите n для генерации чисел Фибоначчи")
    n = int(input())

    start_time_i = time.time()
    f_i = fibonacci_iterative(n)
    delta_time_i = time.time() - start_time_i

    start_time_r = time.time()
    f_r = generate_fibonacci_sequence_recursive(n)
    delta_time_r = time.time() - start_time_r
    print(f_i, "Время работы: ", delta_time_i, "\n")
    print(f_r, "Время работы: ", delta_time_r, "\n")
