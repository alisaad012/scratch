def fibonacci(n):
    if n < 0: return -1
    if n == 0: return 0
    if n == 1: return 1
    first = 0
    second = 1
    for i in range(n - 1):
        tmp = second
        second += first
        first = tmp
    return second

def fib_list(num1, num2):
    answer = []
    for i in range(num2 - num1 + 1):
        i += num1
        fib_num = fibonacci(i)
        if fib_num % 2 == 1:
            answer.append(fib_num)
    return answer

def prompt():
    num1 = None
    num2 = None
    while True:
        try:
            num1 = int(input("n_1: "))
            if num1 < 0: print("n_1 must be nonnegative.")
            else: break
        except ValueError:
            print("n_1 must be an interger.")
    while True:
        try:
            num2 = int(input("n_2: "))
            if num2 < 0: print("n_1 must be nonnegative.")
            else: break
        except ValueError:
            print("n_1 must be an interger.")
    return num1, num2

def fib_list_efficient(num1, num2):
    if num1 == 0 or num1 == 1 and num2 >= 1: print(1)
    first = 0
    second = 1
    for i in range(num2 - 1):
        tmp = first
        first = second
        second += tmp
        if i+2 >= num1 and second % 2 == 1:
            print (second)

def main():
    num1, num2 = prompt()
    while num2 < num1:
        print("n_1 must be less than or equal to n_2")
        num1, num2 = prompt()
    for num in fib_list(num1, num2):
        print(num)
    print("====================")
    fib_list_efficient(num1, num2)

N1 = 0
N2 = 10
    
def one():
    for num in fib_list(N1, N2):
        print(num)

def two():
    fib_list_efficient(N1, N2)

if __name__ == "__main__":
    main()
#    one()
#    two()
