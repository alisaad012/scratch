ERROR = -13

def mid_sqrt(NUM):
    low = 0
    hi = NUM
    ans = (low + hi) / 2.0
    guess = ans * ans
    guesses = 1
    while abs(guess - NUM) > 10 ** ERROR:
        if guess < NUM:
            low = (low + ans) / 2.0
        else:
            hi = (hi + ans) / 2.0
        ans = (low + hi) / 2.0
        guess = ans * ans
        guesses += 1
    return ans, guesses

def quot_sqrt(NUM):
    guess = 1
    quotient = float(NUM) / guess
    guesses = 1
    while abs(guess * guess - NUM) > 10 ** ERROR:
        guess = (guess + quotient) / 2.0
        quotient = float(NUM) / guess
        guesses += 1
    return guess, guesses

def mid_sqrt_print(NUM):
    ans, guesses = mid_sqrt(NUM)
    ans = round(ans, -ERROR - 1)
    print("~ Midpoint Square Root Method ~")
    print("\tSquare root of " + str(NUM) + " is " + str(ans) + ". (" + str(guesses) + " guesses)")

def quot_sqrt_print(NUM):
    ans, guesses = quot_sqrt(NUM)
    ans = round(ans, -ERROR - 1)
    print("~ Quotient Square Root Method ~")
    print("\tSquare root of " + str(NUM) + " is " + str(ans) + ". (" + str(guesses) + " guesses)")

def def_sqrt_print(NUM):
    print("~ Default Square Root Method ~")
    print("\tSquare root of " + str(NUM) + " is " + str(NUM ** 0.5) + ".")

def sqrt(NUM):
    print("===== " + str(NUM) + " =====")
    mid_sqrt_print(NUM)
    quot_sqrt_print(NUM)
    def_sqrt_print(NUM)
    print("\n")
    
def main():
    import sys
    print()
    for i in range(len(sys.argv) - 1):
        try:
            NUM = float(sys.argv[i + 1])
            sqrt(NUM)
        except ValueError:
            print(sys.argv[i + 1] + " is not a number.\n")

if __name__ == "__main__":
    main()
