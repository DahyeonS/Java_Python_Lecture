import my_package.scattering as ms

data = [1, 5, 11, 15]
print('avg =', ms.Avg(data))
print('var =', ms.var_sd(data)[0])
print('std =', ms.var_sd(data)[1])
