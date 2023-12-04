# scattering.py
from statistics import mean, variance
from math import sqrt

def Avg(data) :
    avg = mean(data)
    return avg

def var_sd(data) :
    avg = Avg(data)
    var = variance(data)
    sd = sqrt(var)
    return var, sd

# print('__name__ =', __name__) # __main__

if (__name__ == '__main__') : # (해당 파일에서 실행할 때만 작동)
    data = [1, 3, 5, 7]
    print('avg =', Avg(data))
    print('var =', round(var_sd(data)[0], 2))
    print('sd =', round(var_sd(data)[1]))