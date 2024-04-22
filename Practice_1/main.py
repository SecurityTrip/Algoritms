import random
import time


# Пузырьковая сортировка
def bubble_sort(mas):
    for j in range(1, len(mas) - 1):
        for i in range(0, len(mas) - 1):
            if mas[i] > mas[i + 1]:
                v = mas[i]
                mas[i] = mas[i + 1]
                mas[i + 1] = v
    return mas


# Быстрая сортировка (quick sort)
def quick_sort(mas):
    if len(mas) <= 1:
        return mas
    else:
        index_of_support_element = random.randint(0, len(mas) - 1)  # Выбираем опорный элемент случайным образом
        min_mas = []
        equal_mas = []
        max_mas = []
        for i in range(0, len(mas)):
            if mas[i] < mas[index_of_support_element]:
                min_mas.append(mas[i])
            elif mas[i] == mas[index_of_support_element]:
                equal_mas.append(mas[i])
            elif mas[i] > mas[index_of_support_element]:
                max_mas.append((mas[i]))
        return quick_sort(min_mas) + equal_mas + quick_sort(max_mas)

    # 2 / (j -i +1)


def function(count):
    # count = random.randint(1000, 10000)
    print("Количество элементов в массиве: " + str(count))
    arr1 = []
    for i in range(0, count):
        arr1.append(random.randint(-1000, 1000))

    arr2 = arr1.copy()

    start_time = time.time()
    bubble_sort(arr1)
    tmp_time = time.time() - start_time
    print("Время выполнения сортировки пузырьком:", tmp_time * 1000, "мс")

    start_2_time = time.time()
    arr2 = quick_sort(arr2)
    tmp_time = time.time() - start_2_time
    print("Время выполнения быстрой сортировки:", tmp_time * 1000, "мс", "\n")


if __name__ == "__main__":
    print("Практическая работа № 1. Алгоритмы сортировки, Вариант 5. Выполнил: Лысов Илья, 6204-020302D")

    function(1000)
    function(5000)
    function(10000)
