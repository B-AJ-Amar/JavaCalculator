from math import *
import sys
def main():
#     get all the math frunctions from the math module
    expression = sys.argv[1]
    math_functions = {key: value for key, value in math.__dict__.items() if not key.startswith("__")}
    print(math_functions)
    


if __name__ == "__main__":
    main()
